package steam;

import java.util.Comparator;

public class ComparatorDesempenho implements Comparator<Jogo> {

	@Override
	public int compare(Jogo jogo, Jogo outroJogo) {
		if (jogo.getMaiorScore() < outroJogo.getMaiorScore())
			return -1;
		if (jogo.getMaiorScore() > outroJogo.getMaiorScore())
			return 1;
		return 0;
	}

}
