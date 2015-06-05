package steam;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
		super(nome, preco, estilosDeJogo);
	}

	protected Plataforma(Jogo jogo) {
		super(jogo);
	}

}
