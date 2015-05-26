package steam;

import java.util.ArrayList;

public class Loja {

	ArrayList<Usuario> listaUsuarios;

	public Loja() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}
	
	public Usuario criaUsuario(String nome, String login){
		
	}
	
	public Jogo criaJogo(String nome, double preco){
		Jogo novoJogo;
		try {
			novoJogo = new Jogo(nome, preco);
			return novoJogo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
