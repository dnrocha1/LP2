package steam;

import java.util.ArrayList;

public abstract class Usuario {

	private String nome;
	private String login;
	private double dinheiro;
	private double desconto = 0;
	private ArrayList<Jogo> jogosComprados;

	public Usuario(String nome, String login, double dinheiro) throws Exception {
		if (nome == null)
			throw new Exception("Nome nao pode ser null.");
		if (login == null)
			throw new Exception("Login nao pode ser null.");
		if (dinheiro < 0)
			throw new Exception("Dinheiro nao pode ser negativo.");
		this.nome = nome;
		this.login = login;
		this.dinheiro = dinheiro;
		this.jogosComprados = new ArrayList<Jogo>();
	}

	// Usuario pode comprar jogos.
	public boolean compraJogo(Jogo jogo) throws Exception {
		if (jogo == null)
			throw new Exception("Jogo nao foi referenciado.");
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco() * desconto; // sobrescrita e
															// desconto aplicado
															// certo?
			this.adicionaJogo(jogo);
			return true;
		}
		return false;
	}

	// Usuario pode adicionar dinheiro ao seu perfil.
	public void adicionaDinheiro(double dinheiro) throws Exception {
		if (dinheiro <= 0)
			throw new Exception("Valor de dinheiro invalido.");
		this.dinheiro += dinheiro;
	}

	public double totalJogosComprados() {
		double total = 0;
		for (Jogo jogo : jogosComprados) {
			total += jogo.getPreco();
		}
		return total;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public double getDinheiro() {
		return dinheiro;
	}
	
	public double getDesconto(){
		return desconto;
	}

	private boolean adicionaJogo(Jogo novoJogo) throws Exception {
		if (novoJogo == null) {
			throw new Exception("Jogo nao foi referenciado.");
		}
		this.jogosComprados.add(novoJogo);
		return true;
	}

	public void listaJogosComprados() {
		String texto = "";
		for (Jogo jogo : jogosComprados) {
			if (jogo instanceof RPG)
				texto += " + " + jogo.getNome() + " - RPG:";
			if (jogo instanceof Luta)
				texto += " + " + jogo.getNome() + " - Luta:";
			if (jogo instanceof Plataforma)
				texto += " + " + jogo.getNome() + " - Plataforma:";
			System.out.println(texto);
			jogo.listaInformacoes();
		}
	}
	
}
