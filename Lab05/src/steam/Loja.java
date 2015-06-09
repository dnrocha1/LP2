package steam;

import java.util.ArrayList;

import exceptions.DinheiroInsuficienteException;
import exceptions.LoginInvalidoException;
import exceptions.NullTipoUsuarioException;
import exceptions.TipoJogoInvalidoException;
import exceptions.TipoUsuarioInvalidoException;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	private double totalArrecado;
	private JogoFactory jogoFactory;

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.jogos = new ArrayList<Jogo>();
		this.totalArrecado = 0;
		this.jogoFactory = new JogoFactory();
	}

	public void criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario) {
		Usuario novoUsuario = null;
		try {
			if (tipoUsuario == null)
				throw new NullTipoUsuarioException();
			if (tipoUsuario.equalsIgnoreCase("Noob")) {
				novoUsuario = new Noob(nome, login, dinheiro);
			} else if (tipoUsuario.equalsIgnoreCase("Veterano"))
				novoUsuario = new Veterano(nome, login, dinheiro);
			else {
				throw new TipoUsuarioInvalidoException();
			}
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);

		}
		this.usuarios.add(novoUsuario);
	}

	public void criaJogo(String nome, double preco, String tipoDeJogo,
			EstilosDeJogo... estilosDeJogo) {
		Jogo novoJogo = null;
		if (tipoDeJogo.equalsIgnoreCase("RPG")) {
			novoJogo = jogoFactory.criaJogoRPG(nome, preco, estilosDeJogo);
		} else if (tipoDeJogo.equalsIgnoreCase("Luta"))
			novoJogo = jogoFactory.criaJogoLuta(nome, preco, estilosDeJogo);
		else if (tipoDeJogo.equalsIgnoreCase("Plataforma")) {
			novoJogo = jogoFactory.criaJogoPlataforma(nome, preco,
					estilosDeJogo);
		} else {
			try {
				throw new TipoJogoInvalidoException();
			} catch (TipoJogoInvalidoException e) {
				int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
						.getLineNumber();
				System.out.println("Erro na linha " + linhaErro + ": "
						+ e.getMessage());
				System.exit(0);
			}
		}
		jogos.add(novoJogo);
	}

	public boolean vendeJogo(String login, String nomeJogo) {
		try {
			Usuario user = this.buscaUsuario(login);
			Jogo jogo = this.buscaJogo(nomeJogo);
			if (user.getDinheiro() >= jogo.getPreco()) {
				totalArrecado += jogo.getPreco() * user.getDesconto();
				Jogo novoJogo = copiaJogo(jogo);
				user.compraJogo(novoJogo);
				return true;
			} else {
				throw new DinheiroInsuficienteException();
			}
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
		return false;
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

	public void adicionaDinheiro(Usuario usuario, double dinheiro) {
		try {
			usuario.adicionaDinheiro(dinheiro);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void recompensar(String login, String nomeJogo, int score,
			boolean zerouJogo) {
		try {
			Usuario user = this.buscaUsuario(login);
			user.recompensar(nomeJogo, score, zerouJogo);
		} catch (Exception e) {
			// e.printStackTrace();
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void punir(String login, String nomeJogo, int score,
			boolean zerouJogo) {
		try {
			Usuario user = this.buscaUsuario(login);
			user.punir(nomeJogo, score, zerouJogo);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void upgrade(String login) {
		Usuario user;
		try {
			user = this.buscaUsuario(login);
			user.upgrade();
			int index = usuarios.indexOf(user);
			Usuario novoVeterano = new Veterano(user);
			usuarios.set(index, novoVeterano);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void downgrade(String login) {
		Usuario user;
		try {
			user = this.buscaUsuario(login);
			user.downgrade();
			int index = usuarios.indexOf(user);
			Usuario novoNoob = new Noob(user);
			usuarios.set(index, novoNoob);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	private Usuario buscaUsuario(String login) throws Exception {
		Usuario user = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login))
				user = usuario;
		}
		if (user == null)
			throw new LoginInvalidoException();
		return user;
	}

	private Jogo buscaJogo(String nomeJogo) throws Exception {
		Jogo jogo = null;
		for (Jogo outroJogo : jogos) {
			if (outroJogo.getNome().equalsIgnoreCase(nomeJogo))
				jogo = outroJogo;
		}
		if (jogo == null)
			throw new Exception("Jogo invalido.");
		return jogo;
	}

	public void imprimeInformacoes() {
		System.out.print("=== Central P2-CG ===");
		System.out.println();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			if (usuario instanceof Noob) {
				System.out
						.println("Jogador Noob: " + usuario.getX2p() + " x2p");
			}
			if (usuario instanceof Veterano) {
				System.out.println("Jogador Veterano: " + usuario.getX2p()
						+ " x2p");
			}
			System.out.println("Lista de Jogos:");
			usuario.listaJogosComprados();
			System.out.println("Total de preco dos jogos: R$ "
					+ usuario.totalJogosComprados());
			System.out.println("нннннннннннннннннннннннннннннннннннннннннннн");
			System.out.println("Total arrecadado com vendas de jogos: R$ "
					+ this.totalArrecado);
		}
	}

}
