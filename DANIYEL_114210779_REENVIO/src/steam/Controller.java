package steam;

import java.util.ArrayList;

import exceptions.DinheiroInsuficienteException;
import exceptions.NullTipoUsuarioException;
import exceptions.TipoJogoInvalidoException;

public class Controller {

	private Loja loja = new Loja();
	private JogoFactory jogoFactory = new JogoFactory();

	public void criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario) throws Exception {
		Usuario novoUsuario = null;
		if (tipoUsuario == null)
			throw new NullTipoUsuarioException();
		/*
		 * if (tipoUsuario.equalsIgnoreCase("Noob")) { novoUsuario = new
		 * Noob(nome, login, dinheiro); } else if
		 * (tipoUsuario.equalsIgnoreCase("Veterano")) novoUsuario = new
		 * Veterano(nome, login, dinheiro); else { throw new
		 * TipoUsuarioInvalidoException(); }
		 */
		novoUsuario = new Usuario(nome, login, dinheiro, tipoUsuario);
		loja.adicionaUsuario(novoUsuario);
	}

	public void criaJogo(String nome, double preco, String tipoDeJogo,
			Jogabilidade... jogabilidade) throws TipoJogoInvalidoException {
		Jogo novoJogo = null;
		if (tipoDeJogo.equalsIgnoreCase("RPG")) {
			novoJogo = jogoFactory.criaJogoRPG(nome, preco, jogabilidade);
		} else if (tipoDeJogo.equalsIgnoreCase("Luta"))
			novoJogo = jogoFactory.criaJogoLuta(nome, preco, jogabilidade);
		else if (tipoDeJogo.equalsIgnoreCase("Plataforma")) {
			novoJogo = jogoFactory
					.criaJogoPlataforma(nome, preco, jogabilidade);
		} else {
			throw new TipoJogoInvalidoException();
		}
		loja.adicionaJogo(novoJogo);
	}

	public boolean vendeJogo(String login, String nomeJogo) throws Exception {
		Usuario user = loja.buscaUsuario(login);
		Jogo jogo = loja.buscaJogo(nomeJogo);
		if (user.getDinheiro() >= jogo.getPreco()) {
			loja.atualizaArrecadado(jogo.getPreco() * user.getDesconto());
			Jogo novoJogo = copiaJogo(jogo);
			user.compraJogo(novoJogo);
			return true;
		} else {
			throw new DinheiroInsuficienteException();
		}
	}

	private Jogo copiaJogo(Jogo jogo) {
		Jogo novoJogo = null;
		if (jogo instanceof RPG)
			novoJogo = jogoFactory.criaJogoRPG(jogo);
		if (jogo instanceof Luta)
			novoJogo = jogoFactory.criaJogoLuta(jogo);
		if (jogo instanceof Plataforma)
			novoJogo = jogoFactory.criaJogoPlataforma(jogo);
		return novoJogo;
	}

	public void adicionaDinheiro(String usuario, double dinheiro)
			throws Exception {
		loja.buscaUsuario(usuario).adicionaDinheiro(dinheiro);
	}

	public void ganhouPartida(String login, String nomeJogo, int score,
			boolean zerouJogo) throws Exception {
		loja.buscaUsuario(login).ganhouPartida(nomeJogo, score, zerouJogo);
	}

	public void perdeuPartida(String login, String nomeJogo, int score,
			boolean zerouJogo) throws Exception {
		Usuario user = loja.buscaUsuario(login);
		user.perdeuPartida(nomeJogo, score, zerouJogo);
	}

	/*public void upgrade(String login) throws Exception {
		loja.upgrade(login);
	}*/

	/*public void downgrade(String login) throws Exception {
		loja.downgrade(login);
	}*/

	public void imprimeInformacoes() {
		loja.imprimeInformacoes();
	}

	public void imprimeTop5Usuarios() {
		loja.ordenaUsuarios();
		ArrayList<Usuario> users = loja.getUsuarios();
		System.out.println();
		System.out.println("Top 5 Usuarios: ");
		for (int i = 0; i < 5; i++) {
			// #1 Joao, 12 x2p;
			// #2 Jose, 10 x2p;
			System.out.printf("#%d %s, %d x2p;", i + 1, users.get(i).getNome(),
					users.get(i).getX2p());
		}
	}
}
