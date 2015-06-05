package steam;

public class Noob extends Usuario {

	private double desconto = 0.9;
	
	public Noob(String nome, String login, double dinheiro) throws Exception {
		super(nome, login, dinheiro);
	}

	@Override
	public double getDesconto() {
		return desconto;
	}

}
