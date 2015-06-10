/**
 * Classe Jogo, responsável por ser uma entidade que representa um jogo.
 * 
 * @author Daniyel Negromonte Nascimento Rocha
 */
package steam;

import java.util.Collections;
import java.util.HashSet;

import exceptions.NullNomeException;
import exceptions.PrecoNegativoException;

public abstract class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int vezesJogadas;
	private int vezesZerou;
	private HashSet<EstilosDeJogo> estilosDeJogo;
	private final int MAX_SCORE = 100000;

	public Jogo(String nome, double preco, EstilosDeJogo... estilosDeJogo)
			throws NullNomeException, PrecoNegativoException {
		if (nome == null)
			throw new NullNomeException();
		if (preco < 0)
			throw new PrecoNegativoException();
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesJogadas = 0;
		this.vezesZerou = 0;
		this.estilosDeJogo = new HashSet<EstilosDeJogo>();
		Collections.addAll(this.estilosDeJogo, estilosDeJogo);
	}

	public Jogo(Jogo jogo) {
		this.nome = jogo.getNome();
		this.preco = jogo.getPreco();
		this.maiorScore = jogo.getMaiorScore();
		this.vezesJogadas = jogo.vezesJogadas;
		this.vezesZerou = jogo.vezesZerou;
		this.estilosDeJogo = jogo.getEstilosDeJogo();
	}

	/**
	 * Metodo que joga o jogo. Incrementa a quantidade de vezes que o jogo é
	 * jogado e atualiza o maior score quando é necessário. Vai retornar um
	 * valor de x2p diferente de acordo com cada tipo de jogo.
	 * 
	 * @param score Pontuacao obtida naquela jogada.
	 * @param zerouJogo Confere se zerou o jogo.
	 * @return Retorna uma pontuacao de x2p de acordo como o tipo de jogo.
	 */
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

	/**
	 * Metodo que lista as informacoes acerca do jogo, são elas: quantidade de vezes que um jogo foi jogado; 
	 * quantidade de vezes que um jogo foi zerado; maior score do jogo.
	 */
	public void listaInformacoes() {
		System.out.println("==> Jogou " + vezesJogadas + " vez(es)");
		System.out.println("==> Zerou " + vezesZerou + " vez(es)");
		System.out.println("==> Maior score: " + maiorScore);
	}

}
