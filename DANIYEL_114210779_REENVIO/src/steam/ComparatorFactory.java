package steam;

import java.util.Comparator;

public class ComparatorFactory {

	public Comparator<Jogo> criaComparatorVicio() {
		Comparator<Jogo> novoComparator = new ComparatorVicio();
		return novoComparator;
	}

	public Comparator<Jogo> criaComparatorDesempenho() {
		Comparator<Jogo> novoComparator = new ComparatorDesempenho();
		return novoComparator;
	}

	public Comparator<Jogo> criaComparatorExperiencia() {
		Comparator<Jogo> novoComparator = new ComparatorExperiencia();
		return novoComparator;
	}
}
