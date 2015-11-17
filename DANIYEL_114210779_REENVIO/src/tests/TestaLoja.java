/**
 * Classe de Testes
 */
package tests;

import org.junit.Assert;
import org.junit.Test;

import steam.Jogabilidade;
import steam.Facade;

public class TestaLoja {

	@Test
	public void testCriarUsuario() {
		try {
			//Cria a Facade
			Facade facade = new Facade();
			
			//Cria Usuarios
			facade.criaUsuario("Francisco Neto", "francisco.neto", 40000, "Noob");
			facade.criaUsuario("Carlos Wilson", "carlos.wilson", 100, "Veterano");
			
			//Cria Jogo
			facade.criaJogo("Magicka", 2500, "Plataforma", Jogabilidade.OFFLINE, Jogabilidade.MULTIPLAYER);
			facade.criaJogo("Mario RPG", 20, "RPG", Jogabilidade.ONLINE, Jogabilidade.COMPETITIVO, Jogabilidade.COOPERATIVO);
			
			//Vende Jogo
			facade.vendeJogo("francisco.neto", "Magicka");
			facade.vendeJogo("francisco.neto", "Mario RPG");
			facade.vendeJogo("carlos.wilson", "Mario RPG");
			
			//Joga
			facade.ganhouPartida("francisco.neto", "Magicka", 20000, true);
			//facade.ganhouPartida("francisco.neto");
			facade.perdeuPartida("francisco.neto", "Mario RPG", 2000, false);
			facade.perdeuPartida("carlos.wilson", "Mario RPG", 1500, false);
			//facade.downgrade("carlos.wilson");
			
			
			facade.imprimeInformacoes();
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
