package steam;

import java.util.Comparator;

public class ComparatorExperiencia implements Comparator<Jogo> {

	@Override
	public int compare(Jogo jogo, Jogo outroJogo) {
		if (jogo.getVezesZerou() < outroJogo.getVezesZerou())
			return -1;
		if (jogo.getVezesZerou() > outroJogo.getVezesZerou())
			return 1;
		return 0;
	}

}
