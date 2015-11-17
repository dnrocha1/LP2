/**
 * Classe Usuario, que vai utilizar de herança para ter dois tipos de filhos: Noob/Veterano. 
 */
package steam;

import exceptions.DinheiroNegativoException;
import exceptions.JogoInvalidoException;
import exceptions.NullLoginException;
import exceptions.NullNomeException;
import exceptions.TipoUsuarioInvalidoException;

public class Usuario implements Comparable<Usuario> {

	private String nome;
	private String login;
	private double dinheiro;
	// private ArrayList<Jogo> jogosComprados;
	private CatalogoJogos catalogo;
	private int x2p;
	public final static int LIMITE_X2P = 1000;
	private JogadorFactory jogadorFactory = new JogadorFactory();
	private Jogador jogador;//composicao

	public Usuario(String nome, String login, double dinheiro, String tipoJogador) throws Exception {
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
		// this.jogosComprados = new ArrayList<Jogo>();
		this.catalogo = new CatalogoJogos();
		this.jogador = jogadorFactory.criaJogador(tipoJogador);
	}

	public Usuario(Usuario user) throws TipoUsuarioInvalidoException {
		this.nome = user.getNome();
		this.login = user.getLogin();
		this.dinheiro = user.getDinheiro();
		this.x2p = user.getX2p();
		// this.jogosComprados = user.jogosComprados;
		this.catalogo = new CatalogoJogos();
		//this.jogadorFactory = new JogadorFactory();
		if (jogador instanceof Noob)
			this.jogador = jogadorFactory.criaJogador("Veterano");
		if (jogador instanceof Veterano)
			this.jogador = jogadorFactory.criaJogador("Noob");
	}

	/*
	 * private boolean adicionaJogo(Jogo novoJogo) throws Exception { if
	 * (novoJogo == null) { throw new JogoInvalidoException(); }
	 * this.jogosComprados.add(novoJogo); return true; }
	 */

	public void adicionaDinheiro(double dinheiro) throws Exception {
		if (dinheiro < 0)
			throw new DinheiroNegativoException();
		this.dinheiro += dinheiro;
	}

	public Jogo buscaJogo(String nomeJogo) {
		return catalogo.buscaJogo(nomeJogo);
	}

	public void compraJogo(Jogo jogo) throws Exception {
		if (jogo == null)
			throw new JogoInvalidoException();
		//this.x2p += (int) (10 * jogo.getPreco());
		this.setX2p((int) (10 * jogo.getPreco()));
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco() * this.getDesconto();
			catalogo.adicionaJogo(jogo);
		}
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public String getLogin() {
		return login;
	}

	public String getNome() {
		return nome;
	}

	public int getX2p() {
		return x2p;
	}

	public void listaJogosComprados() {
		catalogo.listagemJogosComprados();
	}

	public void setX2p(int novoX2p) throws Exception {
		this.x2p = novoX2p;
		this.atualizacao();
	}

	public double totalJogosComprados() {
		return catalogo.totalJogosComprados();
	}

	public double getDesconto() {
		return jogador.getDesconto();
	}
	
	public Jogador getJogador() {
		return this.jogador;
	}
	
	public void perdeuPartida(String nomeJogo, int score, boolean zerou) throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		int x2pAtual = jogador.punir(jogo, score, zerou, this.x2p);
		this.setX2p(x2pAtual);
	}
	
	public void ganhouPartida(String nomeJogo, int score, boolean zerou) throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		int x2pAtual = jogador.recompensar(jogo, score, zerou, this.x2p);
		this.setX2p(x2pAtual);
	}
	
	private void atualizacao() throws Exception {
		if (this.x2p >= LIMITE_X2P)
			this.upgrade();
		if (this.x2p < LIMITE_X2P)
			this.downgrade();
	}
	
	private void upgrade() {
		this.jogador = new Veterano();
	}
	
	private void downgrade() {
		this.jogador = new Noob();
	}

	//public abstract void punir(String nomeJogo, int score, boolean zerou) throws Exception;

	//public abstract void recompensar(String nomeJogo, int score, boolean zerou) throws Exception;

	public int compareTo(Usuario outroUsuario) {
		if (this.x2p < outroUsuario.x2p)
			return -1;
		if (this.x2p > outroUsuario.x2p)
			return 1;
		return 0;
	}
}
