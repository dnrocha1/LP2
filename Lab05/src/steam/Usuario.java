package steam;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double dinheiro;
	private TiposUsuarios tiposUsuarios;

	public Usuario(String nome, String login) throws Exception {
		if (nome == null)
			throw new Exception("Nome nao pode ser null.");
		if (login == null)
			throw new Exception("Login nao pode ser null.");
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
		this.dinheiro = 0;
	}

	public boolean compraJogo(Jogo jogo) {
		if (this.dinheiro >= jogo.getPreco()) {
			this.dinheiro -= jogo.getPreco() * this.getDesconto();
			this.jogosComprados.add(jogo);
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
