package steam;

public abstract class Jogador {
	
	public abstract int recompensar(Jogo nomeJogo, int score, boolean zerou, int x2p)
			throws Exception;

	public abstract int punir(Jogo nomeJogo, int score, boolean zerou, int x2p)
			throws Exception;

	//public abstract void upgrade(int x2p) throws Exception;

	//public abstract void downgrade(int x2p) throws Exception;
	
	public abstract double getDesconto();
	
}
