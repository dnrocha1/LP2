package steam;

public class Noob extends Usuario {

	private double desconto = 0.9;
	
	public Noob(String nome, String login, double dinheiro) throws Exception {
		super(nome, login, dinheiro);
	}

	@Override
	public boolean compraJogo(Jogo jogo) throws Exception {
		if (jogo == null)
			throw new Exception("Jogo nao foi referenciado.");
		if (this.getDinheiro() >= jogo.getPreco()) {
			this.setDinheiro(jogo.getPreco() * this.getDesconto());
			// this.getDinheiro() -= jogo.getPreco() * this.getDesconto(); //SEM
			// O DESCONTO!
			this.adicionaJogo(jogo);
			return true;
		}
		return false;
	}

	@Override
	public double getDesconto() {
		return 0.9;
	}

}
