package steam;

public class Luta extends Jogo {

	public Luta(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
		super(nome, preco, estilosDeJogo);
	}

	public Luta(Jogo jogo) {
		super(jogo);
	}

}
