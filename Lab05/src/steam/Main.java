package steam;

public class Main {

	public static void main(String[] args) {
		Loja loja = new Loja();
		Usuario user1 = loja.criaUsuario("Francisco Neto", "francisco.neto", 40, "Noob");
		Jogo magicka = loja.criaJogo("Magicka", 25, "RPG", EstilosDeJogo.OFFLINE, EstilosDeJogo.MULTIPLAYER);
		/*magicka.joga(5, false);
		magicka.joga(20, true);
		magicka.joga(15, true);*/
		loja.vendeJogo(user1, magicka);
		try {
			user1.jogaUsuario(magicka.getNome(), 5, false);
			user1.jogaUsuario(magicka.getNome(), 20, true);
			user1.jogaUsuario(magicka.getNome(), 15, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loja.imprimeInformacoes();
	}

}
