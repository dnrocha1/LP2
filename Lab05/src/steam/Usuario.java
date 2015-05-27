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
	public boolean compraJogo(Jogo jogo) {
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco();
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

	private double getDesconto() {
		double percDesconto = 0;
		if (tiposUsuarios.equals(TiposUsuarios.NOOB))
			percDesconto = 0.9;
		if (tiposUsuarios.equals(TiposUsuarios.VETERANO))
			percDesconto = 0.8;
		return percDesconto;
	}
	
	enum TiposUsuarios{
		NOOB, VETERANO;
	}
}
