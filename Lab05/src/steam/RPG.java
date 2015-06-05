package steam;

public class RPG extends Jogo {

	public RPG(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
		super(nome, preco, estilosDeJogo);
	}

	protected RPG(Jogo jogo) {
		super(jogo);
	}

}
