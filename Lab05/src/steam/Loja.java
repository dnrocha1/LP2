package steam;

import java.util.ArrayList;

public class Loja {

	ArrayList<Usuario> listaUsuarios;

	public Loja() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}
	
	public Usuario criaUsuario(String nome, String login){
		Usuario novoUsuario;
		try {
			novoUsuario = new Usuario(nome, login);
			this.listaUsuarios.add(novoUsuario);
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
	
	private boolean adicionaJogo(Usuario usuario, Jogo jogo){
		return usuario.compraJogo(jogo);
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
