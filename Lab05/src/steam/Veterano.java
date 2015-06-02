package steam;

public class Veterano extends Usuario {

	public Veterano(String nome, String login, double dinheiro)
			throws Exception {
		super(nome, login, dinheiro);
	}

	@Override
	public double getDesconto() {
		return 0.8;
	}
	
}
