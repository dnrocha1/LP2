/**
 * Classe principal de testes.
 */
package steam;

public class Main {

	public static void main(String[] args) {
		/*Loja loja = new Loja();
		loja.criaUsuario("Francisco Neto", "francisco.neto", 40000, "Noob");
		loja.criaJogo("Magicka", 2500, "Plataforma", Jogabilidade.OFFLINE, Jogabilidade.MULTIPLAYER);
		loja.vendeJogo("francisco.neto", "Magicka");
		loja.recompensar("francisco.neto", "Magicka", 20000, true);
		loja.upgrade("francisco.neto");
		//loja.downgrade("francisco.neto");
		loja.imprimeInformacoes();*/
		Facade facade = new Facade();
		facade.criaUsuario("Francisco Neto", "francisco.neto", 40000, "Noob");
		facade.criaUsuario("Carlos Wilson", "carlos.wilson", 100, "Veterano");
		facade.criaJogo("Magicka", 2500, "Plataforma", Jogabilidade.OFFLINE, Jogabilidade.MULTIPLAYER);
		facade.criaJogo("Mario RPG", 20, "RPG", Jogabilidade.ONLINE, Jogabilidade.COMPETITIVO, Jogabilidade.COOPERATIVO);
		facade.vendeJogo("francisco.neto", "Magicka");
		facade.vendeJogo("francisco.neto", "Mario RPG");
		facade.vendeJogo("carlos.wilson", "Mario RPG");
		facade.ganhouPartida("francisco.neto", "Magicka", 20000, true);
		//facade.upgrade("francisco.neto");
		facade.perdeuPartida("francisco.neto", "Mario RPG", 2000, false);
		//facade.punir("carlos.wilson", "Mario RPG", 1500, false);
		//facade.downgrade("carlos.wilson");
		facade.imprimeInformacoes();
	}

}
