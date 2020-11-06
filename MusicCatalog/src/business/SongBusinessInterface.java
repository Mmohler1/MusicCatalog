package business;

import java.util.List;
import javax.ejb.Local;
import beans.Song;

@Local
public interface SongBusinessInterface {
	public List<Song> getSongs();
	public void setSongs(List<Song> orders);
	public void addSong();
}
