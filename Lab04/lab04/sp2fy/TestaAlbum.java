package sp2fy;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
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
			
			/*Crie algumas m�sicas e adicione as m�sicas no �lbum.*/
			formsOfFear.addMusica(chandelier);
			formsOfFear.addMusica(elasticHeart);
			formsOfFear.addMusica(cellophane);
			
			/*Verifique se as M�sicas pertencem realmente ao �lbum.*/
			Assert.assertTrue(formsOfFear.pertenceAlbum(chandelier));
			Assert.assertTrue(formsOfFear.pertenceAlbum(elasticHeart));
			Assert.assertTrue(formsOfFear.pertenceAlbum(cellophane));
			
			/*Verifique se as faixas est�o correspondentes � ordem de inser��o no �lbum.*/
			Assert.assertEquals(1, formsOfFear.getFaixa(chandelier));
			Assert.assertEquals(2, formsOfFear.getFaixa(elasticHeart));
			Assert.assertEquals(3, formsOfFear.getFaixa(cellophane));
			
			/*Testar tempo de duracao do album*/
			Assert.assertEquals(10, formsOfFear.getTempoDuracao());
			
			/*Remova algumas m�sicas do seu �lbum.*/
			formsOfFear.removeMusica(cellophane);
			formsOfFear.removeMusica(chandelier);
			
			/*Verifique se as m�sicas foram realmente removidas do �lbum.*/
			Assert.assertFalse(formsOfFear.pertenceAlbum(chandelier));
			Assert.assertFalse(formsOfFear.pertenceAlbum(cellophane));
			
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
