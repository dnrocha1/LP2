/* 114210779 - Daniyel Negromonte Nascimento Rocha: LAB 04 - Turma 03*/
package sp2fy;

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
		Playlist outraPlaylist = null;
		ArrayList<Musica> listaMusicas;
		//verifica se a playlist com esse nome existe
		for (Playlist playlist : playlists) {
			if (playlist.hasPlaylist(nomePlaylist)){
				outraPlaylist = playlist;
				break;
			} else {
				listaMusicas = new ArrayList<Musica>();
				outraPlaylist = new Playlist(nomePlaylist, listaMusicas);
			}
		}
		//Recupera o álbum com o nome especificado no método (nomeAlbum)
		if (pertenceAlbuns(nomeAlbum)){
			Musica musicaSelecionada = getAlbum(nomeAlbum).getMusica(faixa);
			outraPlaylist.getPlaylist().get(nomePlaylist).add(musicaSelecionada);
		} else {
			throw new Exception("Album nao pertence ao perfil especificado.");
		}
		//Guarde a playlist atualizada no seu agrupamento de playlists
		playlists.add(outraPlaylist);
	}
	
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
