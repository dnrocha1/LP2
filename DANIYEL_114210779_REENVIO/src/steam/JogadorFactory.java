package steam;

import exceptions.TipoUsuarioInvalidoException;

public class JogadorFactory {
	
	public Jogador criaJogador(String tipoJogador) throws TipoUsuarioInvalidoException {
		Jogador jogador = null;
		if (tipoJogador.equalsIgnoreCase("Noob"))
			jogador = this.criaJogadorNoob();
		if (tipoJogador.equalsIgnoreCase("Veterano"))
			jogador = this.criaJogadorVeterano();
		if (jogador == null)
			throw new TipoUsuarioInvalidoException();
		return jogador;
	}
	
	private Jogador criaJogadorNoob() {
		return new Noob();
	}
	
	private Jogador criaJogadorVeterano() {
		return new Veterano();
	}
}
