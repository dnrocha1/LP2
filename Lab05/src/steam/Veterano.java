package steam;

public class Veterano extends Usuario {
	
	private double desconto = 0.8;
	
	public Veterano(String nome, String login, double dinheiro)
			throws Exception {
		super(nome, login, dinheiro);
	}

	@Override
	public double getDesconto() {
		return desconto;
	}

}
