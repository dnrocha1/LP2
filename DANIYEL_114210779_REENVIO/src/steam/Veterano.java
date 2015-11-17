/**
 * Classe Veterano, que é filha da classe Usuario. Vai ter um atributo chamado desconto.
 */
package steam;

import exceptions.DowngradeException;
import exceptions.JogoInvalidoException;
import exceptions.ScoreNegativoException;
import exceptions.UpgradeException;

public class Veterano extends Jogador {

	private double desconto = 0.8;

	/*public Veterano(String nome, String login, double dinheiro)
			throws Exception {
		super(nome, login, dinheiro);
	}*/

	/*public Veterano(Usuario user) {
		super(user);
	}*/

	@Override
	public double getDesconto() {
		return desconto;
	}

	@Override
	public int recompensar(Jogo jogo, int score, boolean zerou, int x2p)
			throws Exception {
		//Jogo jogo = this.buscaJogo(nomeJogo);
		//int x2pAtual = this.getX2p();
		int x2pAtual = x2p;
		if (jogo == null)
			throw new JogoInvalidoException();
		if (score < 0)
			throw new ScoreNegativoException();
		int x2pJogo = jogo.joga(score, zerou);
		x2pAtual += x2pJogo;
		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE))
			x2pAtual += 10;
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO))
			x2pAtual += 20;
		return x2pAtual;
	}

	@Override
	public int punir(Jogo jogo, int score, boolean zerou, int x2p)
			throws Exception {
		//Jogo jogo = this.buscaJogo(nomeJogo);
		//int x2pAtual = this.getX2p();
		int x2pAtual = x2p;
		if (jogo == null)
			throw new JogoInvalidoException();
		if (score < 0)
			throw new ScoreNegativoException();
		int x2pJogo = jogo.joga(score, zerou);
		x2pAtual += x2pJogo;
		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO))
			x2pAtual -= 20;
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO))
			x2pAtual -= 20;
		//this.setX2p(x2pAtual);
		return x2pAtual;
	}

	/*@Override
	public void upgrade(int x2p) throws Exception {
		throw new UpgradeException();
	}
	
	@Override
	public void downgrade(int x2p) throws Exception {
		if(x2p >= Usuario.LIMITE_X2P)
			throw new DowngradeException();
	}*/

}
