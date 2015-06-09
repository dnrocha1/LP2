package steam;

public class Main {

	public static void main(String[] args) {
		Loja loja = new Loja();
		/*loja.criaUsuario("Francisco Neto", "francisco.neto", 400, "Noob");
		loja.criaJogo("Magicka", 25, "RPG", EstilosDeJogo.OFFLINE,
				EstilosDeJogo.MULTIPLAYER);
		loja.vendeJogo("francisco.neto", "Magicka");
		loja.criaJogo("Guilty Gears", 97, "Luta", EstilosDeJogo.OFFLINE,
				EstilosDeJogo.MULTIPLAYER);
		loja.vendeJogo("francisco.neto", "Guilty Gears");
		// user1.recompensar(magicka.getNome(), 15, false);
		loja.recompensar("francisco.neto", "Guilty Gears", 80000, true);
		loja.recompensar("francisco.neto", "Guilty Gears", 0, false);
		loja.recompensar("francisco.neto", "Guilty Gears", 0, false);
		loja.recompensar("francisco.neto", "Guilty Gears", 100000, true);
		loja.recompensar("francisco.neto", "Guilty Gears", 70000, true);// nao
																		// ta
																		// recompensando
		loja.upgrade("francisco.neto");
		//loja.downgrade("francisco.neto");*/
		loja.criaUsuario("Francisco Neto", "francisco.neto", 400, "Noob");
		loja.criaJogo(null, 25, "Plataforma", EstilosDeJogo.OFFLINE, EstilosDeJogo.MULTIPLAYER);
		loja.vendeJogo("francisco.neto", "Magicka");
		loja.recompensar("francisco.neto", "Magicka", 20000, true);
		loja.imprimeInformacoes();
	}

}
