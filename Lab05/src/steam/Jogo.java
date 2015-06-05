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

	public Jogo(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws Exception {
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

	public void joga(int score, boolean zerouJogo) {
		vezesJogadas++;
		if (score > maiorScore)
			maiorScore = score;
		if (zerouJogo)
			vezesZerou++;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public void listaInformacoes() {
		System.out.println("==> Jogou " + vezesJogadas + " vez(es)");
		System.out.println("==> Zerou " + vezesZerou + " vez(es)");
		System.out.println("==> Maior score: " + maiorScore);
	}

	@Override
	public Jogo clone() throws CloneNotSupportedException {
		Jogo j = (Jogo) super.clone();
		j.estilosDeJogo = new HashSet<EstilosDeJogo>(estilosDeJogo);
		return j;
	}

}
