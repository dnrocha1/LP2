package sp2fy;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class TestaAlbum {

	Musica chandelier;
	Musica elasticHeart;
	Musica cellophane;

	@Before
	public void setUp() throws Exception {
		try {
			//cria as instancias p/ evitar repeticao de codigo
			chandelier = new Musica("Chandelier", 3, "Pop");
			elasticHeart = new Musica("Elastic Heart", 3, "Pop");
			cellophane = new Musica("Cellophane", 4, "Pop");
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAlbum() {
		try {
			Album formsOfFear = new Album("Sia", "1000 Forms Of Fear", 2014);

			Assert.assertEquals("Sia", formsOfFear.getArtista());
			Assert.assertEquals("1000 Forms Of Fear", formsOfFear.getTitulo());
			Assert.assertEquals(2014, formsOfFear.getAno());
			
			formsOfFear.addMusica(chandelier);
			formsOfFear.addMusica(elasticHeart);
			formsOfFear.addMusica(cellophane);
			
			//verifique se as musicas pertencem ao album
			Assert.assertTrue(formsOfFear.verificaMusica(chandelier));
			Assert.assertTrue(formsOfFear.verificaMusica(elasticHeart));
			Assert.assertTrue(formsOfFear.verificaMusica(cellophane));
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
