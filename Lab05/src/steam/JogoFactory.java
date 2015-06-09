package steam;

public class JogoFactory {

	public Jogo criaJogoRPG(String nome, double preco,
			EstilosDeJogo... estilosDeJogo) {
		Jogo novoJogo = null;
		try {
			novoJogo = new RPG(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			e.printStackTrace();
			http://stackoverflow.com/questions/115008/how-can-we-print-line-numbers-to-the-log-in-java
		}
		return novoJogo;
	}

	public Jogo criaJogoRPG(Jogo jogo) {
		Jogo novoJogo = new RPG(jogo);
		return novoJogo;
	}

	public Jogo criaJogoLuta(String nome, double preco,
			EstilosDeJogo... estilosDeJogo) {
		Jogo novoJogo = null;
		try {
			novoJogo = new Luta(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoJogo;
	}

	public Jogo criaJogoLuta(Jogo jogo) {
		Jogo novoJogo = new Luta(jogo);
		return novoJogo;
	}

	public Jogo criaJogoPlataforma(String nome, double preco,
			EstilosDeJogo... estilosDeJogo) {
		Jogo novoJogo = null;
		try {
			novoJogo = new Plataforma(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoJogo;
	}

	public Jogo criaJogoPlataforma(Jogo jogo) {
		Jogo novoJogo = new Plataforma(jogo);
		return novoJogo;
	}

}
