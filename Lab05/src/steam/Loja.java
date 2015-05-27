package steam;

import java.util.ArrayList;

public class Loja {

	ArrayList<Usuario> usuarios;
	ArrayList<Jogo> jogos;
	

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.jogos = new ArrayList<Jogo>();
	}
	
	public Usuario criaUsuario(String nome, String login, double dinheiro){
		Usuario novoUsuario;
		try {
			novoUsuario = new Usuario(nome, login, dinheiro);
			this.usuarios.add(novoUsuario);
			return novoUsuario;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
	private boolean adicionaJogo(Usuario usuario, Jogo jogo){ //metodo necessario?
		return usuario.compraJogo(jogo);
	}
	
	public boolean vendeJogo(Usuario user, Jogo jogo){
		
	}
	
	public boolean adicionaDinheiro(Usuario usuario, double dinheiro){
		try {
			usuario.adicionaDinheiro(dinheiro);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void imprimeInformacoes(){
		
	}
	
}
