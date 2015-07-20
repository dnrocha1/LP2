/**
 * Classe RPG, que é uma classe filha de Jogo.
 */
package steam;

public class RPG extends Jogo {

	public RPG(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
		super(nome, preco, estilosDeJogo);
	}

	public RPG(Jogo jogo) {
		super(jogo);
	}

}
