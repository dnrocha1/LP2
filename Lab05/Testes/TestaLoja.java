package steam;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import steam.Loja;

public class TestaLoja {

	@Test
	public void testCriarUsuario() {
		try {
			Loja loja = new Loja();
			loja.criaUsuario("Francisco Neto", "francisco.neto", 40, "Noob");
			Assert.assert
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
