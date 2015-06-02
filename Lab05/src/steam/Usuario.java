package steam;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double dinheiro;
	private TiposUsuarios tiposUsuarios;

	public Usuario(String nome, String login, double dinheiro) throws Exception {
		if (nome == null)
			throw new Exception("Nome nao pode ser null.");
		if (login == null)
			throw new Exception("Login nao pode ser null.");
		if (dinheiro < 0)
			throw new Exception("Dinheiro nao pode ser negativo.");
		this.nome = nome;
		this.login = login;
		this.dinheiro = dinheiro;
		this.jogosComprados = new ArrayList<Jogo>();
	}
	
	//Usuario pode comprar jogos.
	public boolean compraJogo(Jogo jogo) throws Exception {
		if(jogo == null)
			throw new Exception("Jogo nao foi referenciado.");
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco(); //sem o desconto!
			this.jogosComprados.add(jogo);
			return true;
		}
		return false;
	}
	
	//Usuario pode adicionar dinheiro ao seu perfil.
	public void adicionaDinheiro(double dinheiro) throws Exception {
		if (dinheiro <= 0)
			throw new Exception("Valor de dinheiro invalido.");
		this.dinheiro += dinheiro;
	}

	private abstract double getDesconto();
	
	public double totalJogosComprados(){
		double total = 0;
		for (Jogo jogo : jogosComprados) {
			total += jogo.getPreco();
		}
		return total;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public TiposUsuarios getTiposUsuarios(){
		return this.tiposUsuarios;
	}
	
	public String listaJogosComprados(){
		String texto = "";
		for (Jogo jogo : jogosComprados) {
			texto += " "+jogo.getNome()+" - "
		}
	}
	
	enum TiposUsuarios{
		NOOB, VETERANO;
	}
}
