package steam;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaLoja {

	@Test
	public void test() {
		Loja loja = new Loja();
		Usuario user1 = loja.criaUsuario("Francisco Neto", "francisco.neto", 40, "Noob");
		Jogo magicka = loja.criaJogo("Magicka", 25, "RPG", EstilosDeJogo.OFFLINE, EstilosDeJogo.MULTIPLAYER);
		loja.vendeJogo(user1, magicka);
		loja.imprimeInformacoes();
	}

}
