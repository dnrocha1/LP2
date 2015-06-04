package steam;

import java.util.ArrayList;

public abstract class Usuario {

	private String nome;
	private String login;
	private double desconto = 0;
	private double dinheiro;
	private ArrayList<Jogo> jogosComprados;

	public Usuario(String nome, String login, double dinheiro)
			throws Exception {
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
			this.dinheiro -= jogo.getPreco() * this.desconto; //sobrescrita correta??
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

	public abstract double getDesconto(); // metodo abstrato ou nao? abstrato
											// pois cada filho tera o metodo,
											// mas nao necessariamente tera que
											// usa-lo

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

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	protected boolean adicionaJogo(Jogo novoJogo) throws Exception {
		if (novoJogo == null) {
			throw new Exception("Jogo nao foi referenciado.");
		}
		this.jogosComprados.add(novoJogo);
		return true;
	}

	public String listaJogosComprados(){ //terminar depois
		String texto = "";
		for (Jogo jogo : jogosComprados) {
			texto += " "+jogo.getNome()+" - "
		}
	}
}
