package steam;

public class Noob extends Usuario {

	public Noob(String nome, String login, double dinheiro) throws Exception {
		super(nome, login, dinheiro);
	}

	@Override
	public double getDesconto() {
		return 0.9;
	}
	
}
