package steam;

import java.util.ArrayList;

public abstract class Usuario {
	
	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double dinheiro;
	
	public Usuario(){
		this.jogosComprados = new ArrayList<Jogo>();
	}
	
	public abstract boolean compraJogo();
	
	public void adicionaDinheiro(){
		
	}
}
