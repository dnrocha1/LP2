package steam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import exceptions.JogabilidadeInvalidaException;
import exceptions.JogoInvalidoException;

public class CatalogoJogos {

	private ArrayList<Jogo> jogosComprados;
	private ComparatorFactory factory;

	public CatalogoJogos() {
		jogosComprados = new ArrayList<Jogo>();
		factory = new ComparatorFactory();
	}
	
	public ArrayList<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public void adicionaJogo(Jogo novoJogo) throws Exception {
		if (novoJogo == null)
			throw new JogoInvalidoException();
		this.jogosComprados.add(novoJogo);
	}
	
	public void removeJogo(Jogo jogo) throws Exception {
		if (jogo == null)
			throw new JogoInvalidoException();
		this.jogosComprados.remove(jogo);
	}
	
	public Jogo buscaJogo(String nomeJogo) {
		Jogo jogo = null;
		for (Jogo outroJogo : jogosComprados) {
			if (outroJogo.getNome().equalsIgnoreCase(nomeJogo))
				jogo = outroJogo;
		}
		return jogo;
	}
	
	public double totalJogosComprados() {
		double total = 0;
		for (Jogo jogo : jogosComprados) {
			total += jogo.getPreco();
		}
		return total;
	}
	
	public Jogo jogoMaiorScore() {
		Jogo bestScore = jogosComprados.get(0);
		for (Jogo jogo : jogosComprados) {
			if (bestScore.getMaiorScore() < jogo.getMaiorScore())
				bestScore = jogo;
		}
		return bestScore;
	}
	
	public Jogo jogoMaisJogado() {
		Jogo maisJogado = jogosComprados.get(0);
		for (Jogo jogo : jogosComprados) {
			if (maisJogado.getVezesJogadas() < jogo.getVezesJogadas())
				maisJogado = jogo;
		}
		return maisJogado;
	}
	
	public Jogo jogoMaisZerado() {
		Jogo maisZerado = jogosComprados.get(0);
		for (Jogo jogo : jogosComprados) {
			if (maisZerado.getVezesZerou() < jogo.getVezesZerou())
				maisZerado = jogo;
		}
		return maisZerado;
	}
	
	public HashSet<Jogo> jogosPorJogabilidade(Jogabilidade jogabilidade) throws Exception {
		try {
			HashSet<Jogo> jogosJogabilidade = new HashSet<Jogo>();
			for (Jogo jogo : jogosComprados) {
				if (jogo.getJogabilidade().contains(jogabilidade))
					jogosJogabilidade.add(jogo);
			}
			return jogosJogabilidade;
		} catch(Exception e) {
			throw new JogabilidadeInvalidaException();
		}
	}

	public void listagemJogosComprados(){
		String texto = "";
		for (Jogo jogo : jogosComprados) {
			if (jogo instanceof RPG)
				System.out.print("+ " + jogo.getNome() + " - RPG:");
			if (jogo instanceof Luta)
				System.out.print("+ " + jogo.getNome() + " - Luta:");
			if (jogo instanceof Plataforma)
				System.out.print("+ " + jogo.getNome() + " - Plataforma:");
			System.out.println(texto);
			jogo.listaInformacoes();
		}
	}
	
	public void ordenaJogos() {
		Collections.sort(jogosComprados);
	}
	
	public void ordenaJogos(TiposOrdenacao tiposOrdem) {
		Comparator<Jogo> comparator = null;
		if (tiposOrdem == TiposOrdenacao.DESEMPENHO)
			comparator = factory.criaComparatorDesempenho();
		if (tiposOrdem == TiposOrdenacao.EXPERIENCIA)
			comparator = factory.criaComparatorExperiencia();
		if (tiposOrdem == TiposOrdenacao.VICIO)
			comparator = factory.criaComparatorVicio();
		Collections.sort(jogosComprados, comparator);
	}

}
