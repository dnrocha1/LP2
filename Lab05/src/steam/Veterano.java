package steam;

public class Veterano extends Usuario {

	private double desconto = 0.8;

	public Veterano(String nome, String login, double dinheiro)
			throws Exception {
		super(nome, login, dinheiro);
	}

	public Veterano(Usuario user) {
		super(user);
	}

	@Override
	public double getDesconto() {
		return desconto;
	}

	@Override
	public void recompensar(String nomeJogo, int score, boolean zerou)
			throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		int x2pAtual = this.getX2p();
		if (jogo == null)
			throw new Exception("Jogo nao foi comprado ou nao existe.");
		if (score < 0)
			throw new Exception("Score nao pode ser negativo.");
		int x2pJogo = jogo.joga(score, zerou);
		x2pAtual += x2pJogo;
		if (jogo.getEstilosDeJogo().contains(EstilosDeJogo.ONLINE))
			x2pAtual += 10;
		if (jogo.getEstilosDeJogo().contains(EstilosDeJogo.COOPERATIVO))
			x2pAtual += 20;
		this.setX2p(x2pAtual);
	}

	@Override
	public void punir(String nomeJogo, int score, boolean zerou)
			throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		int x2pAtual = this.getX2p();
		if (jogo == null)
			throw new Exception("Jogo nao foi comprado ou nao existe.");
		if (score < 0)
			throw new Exception("Score nao pode ser negativo.");
		int x2pJogo = jogo.joga(score, zerou);
		x2pAtual += x2pJogo;
		if (jogo.getEstilosDeJogo().contains(EstilosDeJogo.COMPETITIVO))
			x2pAtual -= 20;
		if (jogo.getEstilosDeJogo().contains(EstilosDeJogo.COOPERATIVO))
			x2pAtual -= 20;
		this.setX2p(x2pAtual);
	}

	@Override
	public void upgrade() throws Exception {
		throw new Exception("Upgrade indisponivel.");
	}
	
	@Override
	public void downgrade() throws Exception {
		if(this.getX2p() >= LIMITE_X2P)
			throw new Exception("Downgrade indisponivel.");
	}

}
