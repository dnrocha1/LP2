package steam;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double dinheiro;

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

	public boolean compraJogo(String nome, double preco) {
		if (this.dinheiro >= preco) {
			this.dinheiro -= preco * this.getDesconto();
			Jogo novoJogo = null;
			try {
				novoJogo = new Jogo(nome, preco);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.jogosComprados.add(novoJogo);
			return true;
		}
		return false;
	}

	public void adicionaDinheiro(double dinheiro) throws Exception {
		if (dinheiro <= 0)
			throw new Exception("Valor de dinheiro invalido.");
		this.dinheiro += dinheiro;
	}

	public TiposUsuarios getTiposUsuarios() {
		return this.tiposUsuarios;
	}

	private double getDesconto() { // nao sei se isso ta certo
		double percDesconto = 0;
		if (this.getTiposUsuarios() == TiposUsuarios.NOOB)
			percDesconto = 0.9;
		if (this.getTiposUsuarios() == TiposUsuarios.VETERANO)
			percDesconto = 0.8;
		return percDesconto;
	}
}
