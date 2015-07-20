/* 114210779 - Daniyel Negromonte Nascimento Rocha: LAB 04 - Turma 03*/
package sp2fy;

import java.util.ArrayList;
import java.util.HashMap;

public class Playlist {
	
	
	public Playlist(String nomePlaylist, ArrayList<Musica> playlist) {
		this.playlist.put(nomePlaylist, playlist);
	}

	private HashMap<String, ArrayList<Musica>> playlist;

	public boolean hasPlaylist(String nomePlaylist) {
		return this.playlist.containsKey(nomePlaylist);
	}

	public HashMap<String, ArrayList<Musica>> getPlaylist() {
		return playlist;
	}
}
