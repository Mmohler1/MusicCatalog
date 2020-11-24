package business;

import java.util.List;

import beans.Song;

public interface SongBusinessInterface {
	
	public void addSong(Song song);
	public void test();
	public List<Song> getSongs();
	public void setSongs(List<Song> songs);
	public void changeSong(int songID, Song song);
	public List<Song> getDetailedSongs();

}
