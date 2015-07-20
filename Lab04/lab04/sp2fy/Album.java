/* 114210779 - Daniyel Negromonte Nascimento Rocha: LAB 04 - Turma 03*/
package sp2fy;

import java.util.ArrayList;

public class Album implements Comparable<Album>{

	private ArrayList<Musica> musicas;
	private int tempoDuracao;
	private String artista;
	private String titulo;
	private int ano;

	public Album(String artista, String titulo, int ano) throws Exception {
		if (ano > 0) {
			this.artista = artista;
			this.titulo = titulo;
			this.ano = ano;
			this.musicas = new ArrayList<Musica>();
		} else {
			throw new Exception("Ano nao pode ser negativo.");
		}
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void addMusica(Musica m) {
		this.musicas.add(m);
		this.tempoDuracao += m.getDuracao();
	}

	public int getFaixa(Musica m) {
		return musicas.lastIndexOf(m) + 1;
	}

	public Musica getMusica(int faixa) {
		return this.musicas.get(faixa - 1);
	}

	public boolean pertenceAlbum(Musica m) {
		return this.musicas.contains(m);
	}

	public boolean removeMusica(Musica m) {
		this.tempoDuracao -= m.getDuracao();
		return this.musicas.remove(m);
	}
	
	public int getTempoDuracao(){
		return this.tempoDuracao;
	}

	@Override
	public int compareTo(Album outroAlbum) {
		if (this.getAno() > outroAlbum.getAno()){
			return 1;
		} else if (this.getAno() == outroAlbum.getAno()){
			return 0;
		} else {
			return -1;
		}
	}
	
	public int compareTo(String nomeArtista){
		return nomeArtista.compareTo(nomeArtista);
	}
	
	public int compareTo1(int qtdMusicas){
		if (this.musicas.size() > qtdMusicas){
			return 1;
		} else if (this.musicas.size() == qtdMusicas){
			return 0;
		} else {
			return -1;
		}
	}
	
	public int compareTo2(int tempoDuracaoTotal){
		if ( this.getTempoDuracao() > tempoDuracaoTotal){
			return 1;
		} else if (this.getTempoDuracao() > tempoDuracaoTotal){
			return 0;
		} else {
			return -1;
		}
	}
	
}
