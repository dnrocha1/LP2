/**
 * Classe JogoFactory, responsável por desacoplar a criação de um jogo da classe Loja.
 * Sua responsabilidade é criar os diferentes tipos de jogos.
 * 
 * @author Daniyel Negromonte Nascimento Rocha
 */
package steam;

public class JogoFactory {

	public Jogo criaJogoRPG(String nome, double preco,
			EstilosDeJogo... estilosDeJogo) {
		Jogo novoJogo = null;
		try {
			novoJogo = new RPG(nome, preco, estilosDeJogo);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
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
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
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
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
		return novoJogo;
	}

	public Jogo criaJogoPlataforma(Jogo jogo) {
		Jogo novoJogo = new Plataforma(jogo);
		return novoJogo;
	}

}
