package data;

import java.util.List;


import beans.Song;

//Interface for the Database
public interface DataSongInterface {
	public List<Song> findAll();
    public List<Song> findFew();
	public void create(Song song);
	public void update(Song song);
	public void delete(Song song);
	public Song findById(int id);
	public void test();


}
