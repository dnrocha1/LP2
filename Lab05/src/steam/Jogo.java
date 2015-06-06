package steam;

import java.util.Collections;
import java.util.HashSet;

public abstract class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int vezesJogadas;
	private int vezesZerou;
	private HashSet<EstilosDeJogo> estilosDeJogo;
	private final int MAX_SCORE = 100000;

	public Jogo(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
		if (nome == null)
			throw new Exception("Nome nao pode ser null.");
		if (preco < 0)
			throw new Exception("Preco nao pode ser negativo.");
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZerou = 0;
		this.estilosDeJogo = new HashSet<EstilosDeJogo>();
		Collections.addAll(this.estilosDeJogo, estilosDeJogo);
	}

	protected Jogo(Jogo jogo) {
		this.nome = jogo.getNome();
		this.preco = jogo.getPreco();
		this.maiorScore = jogo.getMaiorScore();
		this.vezesJogadas = jogo.vezesJogadas;
		this.vezesZerou = jogo.vezesZerou;
		this.estilosDeJogo = jogo.getEstilosDeJogo();
	}

	public int joga(int score, boolean zerouJogo) {
		int novoX2p = 0;
		vezesJogadas++;
		if (score > maiorScore)
			maiorScore = score;
		if (zerouJogo)
			vezesZerou++;
		if (this instanceof RPG)
			novoX2p += 10;
		if (this instanceof Luta)
			novoX2p += score >= MAX_SCORE ? 100 : (score / 1000);
		if (this instanceof Plataforma)
			if (zerouJogo)
				novoX2p += 20;
		return novoX2p;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public HashSet<EstilosDeJogo> getEstilosDeJogo() {
		return estilosDeJogo;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public int getVezesJogadas() {
		return vezesJogadas;
	}

	public int getVezesZerou() {
		return vezesZerou;
	}

	public void listaInformacoes() {
		System.out.println("==> Jogou " + vezesJogadas + " vez(es)");
		System.out.println("==> Zerou " + vezesZerou + " vez(es)");
		System.out.println("==> Maior score: " + maiorScore);
	}

}
