package steam;

import java.util.ArrayList;

import exceptions.DinheiroNegativoException;
import exceptions.JogoInvalidoException;
import exceptions.NullLoginException;
import exceptions.NullNomeException;

public abstract class Usuario {

	private String nome;
	private String login;
	private double dinheiro;
	private double desconto = 0;
	private ArrayList<Jogo> jogosComprados;
	private int x2p;
	public final int LIMITE_X2P = 1000;

	public Usuario(String nome, String login, double dinheiro) throws Exception {
		if (nome == null)
			throw new NullNomeException();
		if (login == null)
			throw new NullLoginException();
		if (dinheiro < 0)
			throw new DinheiroNegativoException();
		this.nome = nome;
		this.login = login;
		this.dinheiro = dinheiro;
		this.x2p = 0;
		this.jogosComprados = new ArrayList<Jogo>();
	}

	protected Usuario(Usuario user) {
		this.nome = user.getNome();
		this.login = user.getLogin();
		this.dinheiro = user.getDinheiro();
		this.desconto = user.getDesconto();
		this.jogosComprados = user.jogosComprados;
		this.x2p = user.getX2p();
	}

	public void compraJogo(Jogo jogo) throws Exception {
		if (jogo == null)
			throw new JogoInvalidoException();
		this.x2p = (int) (10 * jogo.getPreco());
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco() * desconto;
			this.adicionaJogo(jogo);
		}
	}

	public void adicionaDinheiro(double dinheiro) throws Exception {
		if (dinheiro < 0)
			throw new DinheiroNegativoException();
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

	public int getX2p() {
		return x2p;
	}

	public ArrayList<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public void setX2p(int novoX2p) {
		this.x2p = novoX2p;
	}

	public abstract double getDesconto();

	public abstract void recompensar(String nomeJogo, int score, boolean zerou)
			throws Exception;

	public abstract void punir(String nomeJogo, int score, boolean zerou)
			throws Exception;

	protected Jogo buscaJogo(String nomeJogo) {
		Jogo jogo = null;
		for (Jogo outroJogo : jogosComprados) {
			if (outroJogo.getNome().equalsIgnoreCase(nomeJogo))
				jogo = outroJogo;
		}
		return jogo;
	}

	private boolean adicionaJogo(Jogo novoJogo) throws Exception {
		if (novoJogo == null) {
			throw new JogoInvalidoException();
		}
		this.jogosComprados.add(novoJogo);
		return true;
	}
	
	public abstract void upgrade() throws Exception;

	public abstract void downgrade() throws Exception;
	
	public void listaJogosComprados() {
		String texto = "";
		for (Jogo jogo : jogosComprados) {
			if (jogo instanceof RPG)
				System.out.print("+ " + jogo.getNome() + " - RPG:");
			if (jogo instanceof Luta)
				System.out.print("+ " + jogo.getNome() + " - Luta:");
			if (jogo instanceof Plataforma)
				System.out.print("+ " + jogo.getNome() + " - Plataforma:");
			System.out.println(texto);
			jogo.listaInformacoes();
		}
	}

}
