/**
 * Classe RPG, que é uma classe filha de Jogo.
 */
package steam;

public class RPG extends Jogo {

	public RPG(String nome, double preco, Jogabilidade... jogabilidade)
			throws Exception {
		super(nome, preco, jogabilidade);
	}

	public RPG(Jogo jogo) {
		super(jogo);
	}

}
