package steam;

import java.util.Comparator;

public class ComparatorVicio implements Comparator<Jogo> {

	@Override
	public int compare(Jogo jogo, Jogo outroJogo) {
		if (jogo.getVezesJogadas() < outroJogo.getVezesJogadas())
			return -1;
		if (jogo.getVezesJogadas() > outroJogo.getVezesJogadas())
			return 1;
		return 0;
	}

}
