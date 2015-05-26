package sp2fy;

import java.util.ArrayList;

public class Album {

	private ArrayList<Musica> musicas;
	private int tempoDuracao; // mudar para o tipo time (ou similar)???
	private String artista; // fazer classe propria -> Artista.class
	private String titulo;
	private int ano; // mudar para tipo time???*

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
}
