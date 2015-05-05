package sp2fy;

import java.util.ArrayList;

public class Album {
	
	private ArrayList<Musica> musicas;
	private int faixa;
	private double tempoDuracao; //mudar para o tipo time (ou similar)???
	private String artista; //fazer classe propria -> Artista.class
	private String titulo;
	private int ano; //mudar para tipo time???*
	
	public Album(String artista, String titulo, int ano) {
		this.artista = artista;
		this.titulo = titulo;
		this.ano = ano;
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
	
}
