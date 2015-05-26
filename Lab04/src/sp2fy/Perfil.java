package sp2fy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Perfil {

	private String nome;
	private ArrayList<Album> albuns;
	private ArrayList<Album> albunsFavoritos;
	//private HashMap<String, ArrayList<Musica>> playlist;
	private ArrayList<Playlist> playlists;
	
	public Perfil(String nomePerfil) {
		this.nome = nomePerfil;
		this.albuns = new ArrayList<Album>();
		this.albunsFavoritos = new ArrayList<Album>();
	}

	public boolean adicionaAlbum(Album album) {
		return this.albuns.add(album);
	}

	public boolean adicionaAosFavoritos(Album album) {
		if (pertenceAlbuns(album.getTitulo())) {
			return this.albunsFavoritos.add(album);
		}
		return false;
	}

	public boolean pertenceAlbuns(String nomeAlbum) {
		for (Album album : this.albuns) {
			if (album.getTitulo().equalsIgnoreCase(nomeAlbum))
				return true;
		}
		return false;
	}

	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		ArrayList<Musica> listaMusicas;
		Album outroAlbum;
		if (!this.hasPlaylist(nomePlaylist)) {
			this.playlist = new HashMap<String, ArrayList<Musica>>();
			listaMusicas = new ArrayList<Musica>();
			this.playlist.put(nomePlaylist, listaMusicas);
		} else {
			listaMusicas = this.playlist.get(nomePlaylist);
		}
		if (!this.pertenceAlbuns(nomeAlbum)) {
			throw new Exception("Album nao pertence ao Perfil especificado");
		} else {
			/*
			 * Se existir, pegue a faixa do álbum especificado na assinatura do
			 * método e adicione no agrupamento resultante da operação em 1.
			 */
			outroAlbum = this.getAlbum(nomeAlbum);
			this.playlist.get(nomePlaylist).add(outroAlbum.getMusica(faixa));
		}
	}

//	public boolean hasPlaylist(String nomePlaylist) {
//		return this.playlist.containsKey(nomePlaylist);
//	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Album> getAlbuns() {
		return albuns;
	}
	
	public int getIndiceAlbuns(String nomeAlbum){
		int index = 0;
		for (Album album : this.albuns) {
			if (album.getTitulo().equalsIgnoreCase(nomeAlbum))
				return index;
			index++;
		}
		if(index == 0)
			index = -1;
		return index;
	}
	
	public Album getAlbum(String nomeAlbum){
		return this.albuns.get(this.getIndiceAlbuns(nomeAlbum));			
	}
		
}
