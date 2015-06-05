package steam;

import java.util.ArrayList;

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

	public Usuario criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario) {
		Usuario novoUsuario = null;
		try {
			if (tipoUsuario.equalsIgnoreCase("noob"))
				novoUsuario = new Noob(nome, login, dinheiro);
			if (tipoUsuario.equalsIgnoreCase("veterano"))
				novoUsuario = new Veterano(nome, login, dinheiro);
			this.usuarios.add(novoUsuario);
			return novoUsuario;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return novoUsuario;
	}

	public Jogo criaJogo(String nome, double preco, String tipoDeJogo,
			EstilosDeJogo... estilosDeJogo) { // chamar JogoFactory OK
		Jogo novoJogo = null;
		if (tipoDeJogo.equalsIgnoreCase("RPG"))
			novoJogo = jogoFactory.criaJogoRPG(nome, preco, estilosDeJogo);
		if (tipoDeJogo.equalsIgnoreCase("Luta"))
			novoJogo = jogoFactory.criaJogoLuta(nome, preco, estilosDeJogo);
		if (tipoDeJogo.equalsIgnoreCase("Plataforma"))
			novoJogo = jogoFactory.criaJogoPlataforma(nome, preco,
					estilosDeJogo);
		jogos.add(novoJogo);
		return novoJogo;
	}

	public boolean vendeJogo(Usuario user, Jogo jogo) { // preciso copiar o jogo
														// original
		if (user.getDinheiro() >= jogo.getPreco()) {
			try {
				totalArrecado += jogo.getPreco() * user.getDesconto();
				Jogo novoJogo = jogo.clone();
				user.compraJogo(novoJogo);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean adicionaDinheiro(Usuario usuario, double dinheiro) {
		try {
			usuario.adicionaDinheiro(dinheiro);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void imprimeInformacoes() {
		System.out.print("=== Central P2ญCG ===");
		System.out.println();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getLogin());
			if (usuario instanceof Noob) {
				System.out.println(usuario.getNome() + " - Jogador Noob");
			}
			if (usuario instanceof Veterano) {
				System.out.println(usuario.getNome() + " - Jogador Veterano");
			}
			System.out.println("Lista de Jogos:");
			usuario.listaJogosComprados();
			System.out.println("Total de preco dos jogos: R$ "
					+ usuario.totalJogosComprados());
			System.out.println("ญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญญ");
			System.out.println("Total arrecadado com vendas de jogos: R$ " + totalArrecado);
		}
	}

}
