package steam;

import java.util.ArrayList;

public class Usuario {
	
	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double dinheiro;
	
	public Usuario(String nome, String login){
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
	}
	
	public boolean compraJogo(){
		
	}
	
	public void adicionaDinheiro(){
		
	}
}
