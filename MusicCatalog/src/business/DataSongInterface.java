package business;

import java.util.List;


import beans.Song;

//Interface for the Database
public interface DataSongInterface {
	public List<Song> findAll();
	public void create(Song song);
	public void update(int songID, Song song);
	public void delete(Song song);
	public void detail(Song song);
	public Song findById(int id);
	public void test();


}
