/**
 * Classe Plataforma, que � uma classe filha de Jogo.
 */
package steam;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
		super(nome, preco, estilosDeJogo);
	}

	public Plataforma(Jogo jogo) {
		super(jogo);
	}

}
