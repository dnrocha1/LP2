/**
 * Classe Plataforma, que é uma classe filha de Jogo.
 */
package steam;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco, Jogabilidade... jogabilidade)
			throws Exception {
		super(nome, preco, jogabilidade);
	}

	public Plataforma(Jogo jogo) {
		super(jogo);
	}

}
