package steam;

public class Main {

	public static void main(String[] args) {
		Loja loja = new Loja();
		Usuario user1 = loja.criaUsuario("Francisco Neto", "francisco.neto", 400, "Noob");
		//Jogo magicka = loja.criaJogo("Magicka", 25, "RPG", EstilosDeJogo.OFFLINE, EstilosDeJogo.MULTIPLAYER);
		//loja.vendeJogo(user1, magicka);
		Jogo gg = loja.criaJogo("Guilty Gears", 97, "Luta", EstilosDeJogo.OFFLINE, EstilosDeJogo.MULTIPLAYER);
		loja.vendeJogo(user1, gg);
		try {
			/*
			user1.jogaUsuario(magicka.getNome(), 5, false);
			user1.jogaUsuario(magicka.getNome(), 20, false);
			user1.jogaUsuario(magicka.getNome(), 15, false);
			user1.jogaUsuario(magicka.getNome(), 15, false);
			user1.jogaUsuario(magicka.getNome(), 15, false);
			*/
			//user1.recompensar(magicka.getNome(), 15, false);
			//user1.recompensar(gg.getNome(), 80000, true);
			user1.recompensar(gg.getNome(), 0, false);
			user1.recompensar(gg.getNome(), 0, false);
			user1.recompensar(gg.getNome(), 100000, true);
			user1.recompensar(gg.getNome(), 70000, true);//nao ta recompensando nem fazendo upcast
			loja.upgrade(user1.getLogin());
			loja.downgrade(user1.getLogin());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loja.imprimeInformacoes();
	}

}
