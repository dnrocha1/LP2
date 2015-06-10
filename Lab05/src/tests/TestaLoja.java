/**
 * Classe de Testes
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import steam.EstilosDeJogo;
import steam.Loja;

public class TestaLoja {

	@Test
	public void testCriarUsuario() {
		try {
			Loja loja = new Loja();
			loja.criaUsuario("Francisco Neto", "francisco.neto", 40000, "Noob");
			loja.criaUsuario("Carlos Wilson", "carlos.wilson", 100, "Veterano");
			loja.criaJogo("Magicka", 2500, "Plataforma", EstilosDeJogo.OFFLINE, EstilosDeJogo.MULTIPLAYER);
			loja.criaJogo("Mario RPG", 20, "RPG", EstilosDeJogo.ONLINE, EstilosDeJogo.COMPETITIVO, EstilosDeJogo.COOPERATIVO);
			loja.vendeJogo("francisco.neto", "Magicka");
			loja.vendeJogo("francisco.neto", "Mario RPG");
			loja.vendeJogo("carlos.wilson", "Mario RPG");
			loja.recompensar("francisco.neto", "Magicka", 20000, true);
			loja.upgrade("francisco.neto");
			loja.punir("francisco.neto", "Mario RPG", 2000, false);
			loja.punir("carlos.wilson", "Mario RPG", 1500, false);
			loja.downgrade("carlos.wilson");
			loja.imprimeInformacoes();
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
