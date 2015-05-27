package steam;

import java.util.ArrayList;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Jogo> jogos;
	private double totalArrecado;	

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.jogos = new ArrayList<Jogo>();
		this.totalArrecado = 0;
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
	
	public boolean vendeJogo(Usuario user, Jogo jogo){
		try {
			Jogo outroJogo = new Jogo(jogo.getNome(), jogo.getPreco()); //copia do jogo original
			return user.compraJogo(outroJogo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
