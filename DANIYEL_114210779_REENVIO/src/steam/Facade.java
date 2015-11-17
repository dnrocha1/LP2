package steam;

import exceptions.TipoJogoInvalidoException;

public class Facade {

	private Controller controller = new Controller();

	public void criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario) {
		try {
			controller.criaUsuario(nome, login, dinheiro, tipoUsuario);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void criaJogo(String nome, double preco, String tipoDeJogo,
			Jogabilidade... jogabilidade) {
		try {
			controller.criaJogo(nome, preco, tipoDeJogo, jogabilidade);
		} catch (TipoJogoInvalidoException e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void vendeJogo(String login, String nomeJogo) {
		try {
			controller.vendeJogo(login, nomeJogo);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void adicionaDinheiro(String nomeUsuario, double dinheiro) {
		try {
			controller.adicionaDinheiro(nomeUsuario, dinheiro);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void ganhouPartida(String login, String nomeJogo, int score,
			boolean zerouJogo) {
		try {
			controller.ganhouPartida(login, nomeJogo, score, zerouJogo);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void perdeuPartida(String login, String nomeJogo, int score,
			boolean zerouJogo) {
		try {
			controller.perdeuPartida(login, nomeJogo, score, zerouJogo);
		} catch (Exception e) {
			int linhaErro = e.getStackTrace()[e.getStackTrace().length - 1]
					.getLineNumber();
			System.out.println("Erro na linha " + linhaErro + ": "
					+ e.getMessage());
			System.exit(0);
		}
	}

	public void imprimeInformacoes() {
		controller.imprimeInformacoes();
	}

}
