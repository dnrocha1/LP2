package steam;

public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int vezesJogadas;
	private int vezesZerou;
	//existem tres tipos de Jogos ​, o RPG (Role Playing Game), Luta e Plataforma.

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
