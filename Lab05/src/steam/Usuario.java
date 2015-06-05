package steam;

import java.util.ArrayList;

public abstract class Usuario {

	private String nome;
	private String login;
	private double dinheiro;
	private double desconto = 0;
	private ArrayList<Jogo> jogosComprados;
	private int x2p;
	private final int MAX_SCORE = 10000;

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
		this.x2p = 0;
		this.jogosComprados = new ArrayList<Jogo>();
	}

	public boolean compraJogo(Jogo jogo) throws Exception {
		if (jogo == null)
			throw new Exception("Jogo nao foi referenciado.");
		this.x2p = (int) (10 * jogo.getPreco());
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco() * desconto; 
			this.adicionaJogo(jogo);
			return true;
		}
		return false;
	}

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
	
	public int getX2p(){
		return x2p;
	}
	
	public abstract double getDesconto();
	
	public void jogaUsuario(String nomeJogo, int score, boolean zerouJogo) throws Exception{
		Jogo jogo = buscaJogo(nomeJogo);
		if (jogo == null)
			throw new Exception("Jogo nao foi comprado ou nao existe.");
		if (score < 0)
			throw new Exception("Score nao pode ser negativo.");
		jogo.joga(score, zerouJogo);
		if (jogo instanceof RPG)
			this.x2p += 10;
		if (jogo instanceof Luta)
			this.x2p += score >= MAX_SCORE ? 100 : (score/1000);
		if (jogo instanceof Plataforma)
			if(zerouJogo)
				this.x2p += 20;
	}
	
	private Jogo buscaJogo(String nomeJogo){
		Jogo jogo = null;
		for (Jogo outroJogo : jogosComprados) {
			if(outroJogo.getNome().equalsIgnoreCase(nomeJogo))
				jogo = outroJogo;
		}
		return jogo;
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
				texto += "+ " + jogo.getNome() + " - RPG:";
			if (jogo instanceof Luta)
				texto += "+ " + jogo.getNome() + " - Luta:";
			if (jogo instanceof Plataforma)
				texto += "+ " + jogo.getNome() + " - Plataforma:";
			System.out.println(texto);
			jogo.listaInformacoes();
		}
	}
	
}
