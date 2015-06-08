package steam;

import java.util.ArrayList;

import exceptions.DinheiroInsuficienteException;
import exceptions.NullTipoUsuarioException;
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
			else{
				throw new TipoUsuarioInvalidoException();
			}
			this.usuarios.add(novoUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void criaJogo(String nome, double preco, String tipoDeJogo,
			EstilosDeJogo... estilosDeJogo) {
		Jogo novoJogo = null;
		if (tipoDeJogo.equalsIgnoreCase("RPG"))
			novoJogo = jogoFactory.criaJogoRPG(nome, preco, estilosDeJogo);
		if (tipoDeJogo.equalsIgnoreCase("Luta"))
			novoJogo = jogoFactory.criaJogoLuta(nome, preco, estilosDeJogo);
		if (tipoDeJogo.equalsIgnoreCase("Plataforma"))
			novoJogo = jogoFactory.criaJogoPlataforma(nome, preco,
					estilosDeJogo);
		jogos.add(novoJogo);
	}

	public boolean vendeJogo(String login, String nomeJogo) {
		try {
			Usuario user = this.buscaUsuario(login);
			Jogo jogo = this.buscaJogo(nomeJogo);
			if (user.getDinheiro() >= jogo.getPreco()) {
				totalArrecado += jogo.getPreco() * user.getDesconto();
				Jogo novoJogo = null;
				if (jogo instanceof RPG)
					novoJogo = new RPG(jogo);
				if (jogo instanceof Luta)
					novoJogo = new Luta(jogo);
				if (jogo instanceof Plataforma)
					novoJogo = new Plataforma(jogo);
				user.compraJogo(novoJogo);
				return true;
			} else {
				throw new DinheiroInsuficienteException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void adicionaDinheiro(Usuario usuario, double dinheiro) {
		try {
			usuario.adicionaDinheiro(dinheiro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void recompensar(String login, String nomeJogo, int score,
			boolean zerouJogo) {
		try {
			Usuario user = this.buscaUsuario(login);
			user.recompensar(nomeJogo, score, zerouJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void punir(String login, String nomeJogo, int score,
			boolean zerouJogo) {
		try {
			Usuario user = this.buscaUsuario(login);
			user.punir(nomeJogo, score, zerouJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upgrade(String login) {
		Usuario user;
		try {
			user = this.buscaUsuario(login);
			user.upgrade();
			int index = usuarios.indexOf(user);
			//usuarios.remove(index);
			Usuario novoVeterano = new Veterano(user);
			//usuarios.add(index, novoVeterano);
			usuarios.set(index, novoVeterano);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downgrade(String login) {
		Usuario user;
		try {
			user = this.buscaUsuario(login);
			user.downgrade();
			int index = usuarios.indexOf(user);
			//usuarios.remove(index);
			Usuario novoNoob = new Noob(user);
			//usuarios.add(index, novoNoob);
			usuarios.set(index, novoNoob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Usuario buscaUsuario(String login) throws Exception {
		Usuario user = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login))
				user = usuario;
		}
		if (user == null)
			throw new Exception("Login invalido.");
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
		System.out.print("=== Central P2ญCG ===");
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
			System.out.println("ญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญ");
			System.out.println("Total arrecadado com vendas de jogos: R$ "
					+ this.totalArrecado);
		}
	}

}
