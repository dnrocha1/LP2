package sp2fy;

import java.util.ArrayList;
import java.util.HashMap;

public class Playlist {
	private HashMap<String, ArrayList<Musica>> playlist;

	public boolean hasPlaylist(String nomePlaylist) {
		return this.playlist.containsKey(nomePlaylist);
	}
}
