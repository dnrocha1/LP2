package steam;

import java.util.Arrays;
import java.util.HashSet;

public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int vezesJogadas;
	private int vezesZerou;
	// existem tres tipos de Jogos ​, o RPG (Role Playing Game), Luta e
	// Plataforma.
	private String[] tiposDeJogos = { "RPG", "Luta", "Plataforma" }; //usar ENUM?
	private HashSet<String> jogabilidade = new HashSet<String>(Arrays.asList(
			"online", "offline", "multiplayer", "cooperativo", "competitivo")); //usar ENUM?

	public Jogo() {
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZerou = 0;
	}

	private void joga(int score, boolean zerouJogo) {
		vezesJogadas++;
		if (score > maiorScore)
			maiorScore = score;
	}
}
