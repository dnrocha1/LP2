package sp2fy;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestaAlbum {

	@Test
	public void testAlbum() {
		try{
			Album formsOfFear = new Album("Sia", "1000 Forms Of Fear", 2014);
			
			Assert.assertEquals("Sia",formsOfFear.getArtista());
			Assert.assertEquals("1000 Forms Of Fear", formsOfFear.getTitulo());
			Assert.assertEquals(2014, formsOfFear.getAno());
			
			Musica chandelier = new Musica("Chandelier",3,"Pop");
			Musica elasticHeart = new Musica("Elastic Heart",3,"Pop");
			Musica cellophane = new Musica("Cellophane",4,"Pop");
			
		}catch(Exception e){
			Assert.fail();
		}
	}

}
