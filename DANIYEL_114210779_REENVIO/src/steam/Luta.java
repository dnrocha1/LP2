/**
 * Classe Luta, que é uma classe filha de Jogo.
 */
package steam;

public class Luta extends Jogo {

	public Luta(String nome, double preco, Jogabilidade... jogabilidade)
			throws Exception {
		super(nome, preco, jogabilidade);
	}

	public Luta(Jogo jogo) {
		super(jogo);
	}

}
