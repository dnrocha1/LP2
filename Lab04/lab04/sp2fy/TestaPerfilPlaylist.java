package sp2fy;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestaPerfilPlaylist {

	@Test
	public void testPerfilPlaylist() {
		try {
			/*criar musicas*/
			Musica fluorescentAdolescent = new Musica("FluorescentAdolescent", 3, "indie");
			Musica teddyPicker = new Musica("Teddy Picker", 2, "indie");
			Musica brianstorm = new Musica("Brianstorm", 3, "indie");
			Musica mosquitoSong = new Musica("Mosquito Song", 4, "rock");
			Musica goWithTheFlow = new Musica("Go With The Flow", 4, "rock");
			Musica theSkyIsFallin = new Musica("The Sky Is Fallin", 4, "rock");
			Musica everlong = new Musica("Everlong", 4, "rock");
			Musica myHero = new Musica("My Hero", 4, "rock");
			Musica walkingAfterYou = new Musica("Walking After You", 5, "rock");
			
			/*criar albuns*/
			Album favouriteWorstNightmare = new Album("Arctic Monkeys", "Favourite Worst Nightmare", 2007);
			Album songsForTheDeaf = new Album("Queens Of The Stone Age", "Songs For The Deaf", 2002);
			Album theColourAndTheShape = new Album("Foo Fighters", "The Colour and the Shape", 1997);
			
			/*adicionar musicas aos albuns*/
			favouriteWorstNightmare.addMusica(brianstorm);
			favouriteWorstNightmare.addMusica(fluorescentAdolescent);
			favouriteWorstNightmare.addMusica(teddyPicker);
			songsForTheDeaf.addMusica(mosquitoSong);
			songsForTheDeaf.addMusica(theSkyIsFallin);
			songsForTheDeaf.addMusica(goWithTheFlow);
			theColourAndTheShape.addMusica(walkingAfterYou);
			theColourAndTheShape.addMusica(myHero);
			theColourAndTheShape.addMusica(everlong);
			
			/*criar um perfil*/
			Perfil perfil1 = new Perfil("Perfil 1");
			Perfil perfil2 = new Perfil("Perfil 2");
			
			/*adicionar albuns ao perfil*/
			perfil1.adicionaAlbum(songsForTheDeaf);
			perfil1.adicionaAlbum(theColourAndTheShape);
			
			perfil2.adicionaAlbum(songsForTheDeaf);
			perfil2.adicionaAlbum(theColourAndTheShape);
			perfil2.adicionaAlbum(favouriteWorstNightmare);
			
			/*adicionar albuns favoritos*/
			perfil1.adicionaAosFavoritos(songsForTheDeaf);
			perfil1.adicionaAosFavoritos(theColourAndTheShape);
			perfil1.adicionaAosFavoritos(favouriteWorstNightmare);
			
			perfil2.adicionaAosFavoritos(favouriteWorstNightmare);
			
			/*adiciona playlist*/
			perfil1.adicionaPlaylist("playlist1", "Songs For The Deaf", 2);
			
			
			
		} catch (Exception e) {
			Assert.fail();// nao deveria ter lancado nenhuma Exception nesse teste.
		}
	}

}
