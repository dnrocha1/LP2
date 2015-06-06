package steam;

public class JogoFactory {
	
	public Jogo criaJogoRPG(String nome, double preco,
			EstilosDeJogo... estilosDeJogo){
		Jogo novoJogo = null;
		try {
			novoJogo = new RPG(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoJogo;
	}
	
	public Jogo criaJogoLuta(String nome, double preco,
			EstilosDeJogo... estilosDeJogo){
		Jogo novoJogo = null;
		try {
			novoJogo = new Luta(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoJogo;
	}
	
	public Jogo criaJogoPlataforma(String nome, double preco,
			EstilosDeJogo... estilosDeJogo){
		Jogo novoJogo = null;
		try {
			novoJogo = new Plataforma(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoJogo;
	}

}
