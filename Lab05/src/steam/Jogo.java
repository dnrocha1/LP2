package steam;

import java.util.HashSet;

public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int vezesJogadas;
	private int vezesZerou;
	private HashSet<Jogabilidade> estilosDeJogo;
	
	public Jogo(String nome, double preco) throws Exception {
		if (preco < 0)
			throw new Exception("Preco nao pode ser negativo.");
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZerou = 0;
		this.estilosDeJogo = new HashSet<Jogabilidade>;
	}

	private void joga(int score, boolean zerouJogo) {
		vezesJogadas++;
		if (score > maiorScore)
			maiorScore = score;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

}
