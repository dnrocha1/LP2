package sp2fy;

import java.util.ArrayList;

public class Perfil {

	private String nome;
	private ArrayList<Album> albuns;
	private ArrayList<Album> albunsFavoritos;

	public Perfil(String nomePerfil) {
		this.nome = nomePerfil;
		this.albuns = new ArrayList<Album>();
		this.albunsFavoritos = new ArrayList<Album>();
	}

	public boolean adicionaAlbum(Album album) {
		return this.albuns.add(album);
	}

	public boolean adicionaAosFavoritos(Album album) {
		if (pertenceAlbuns(album)) {
			return this.albunsFavoritos.add(album);
		}
		return false;
	}

	public boolean pertenceAlbuns(Album album) {
		return this.albuns.contains(album);
	}

	public String getNome() {
		return nome;
	}

}
