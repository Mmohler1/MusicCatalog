package business;

import beans.Song;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.ViewScoped;

/**
 * Session Bean implementation class SongBusinessService
 */
@Stateless
@Local(SongBusinessInterface.class)
@LocalBean
@Alternative
@ViewScoped
public class SongBusinessService implements SongBusinessInterface {
	
	List <Song> songs = new ArrayList<Song>();
	List <Song> dsongs = new ArrayList<Song>();
	
	@EJB
	DataSongInterface service;

    /**
     * Default constructor. 
     */
    public SongBusinessService() {
        // TODO Auto-generated constructor stub
    }

    
    
	/**
     * @see SongBusinessInterface#addSong(Song)
     * Adds a song to the above list
     */
    public void addSong(Song song) {
    	
        // TODO Auto-generated method stub
    	service.create(song);
    	
    }

	/**
     * @see SongBusinessInterface#test()
     * Simple print line to show interface is working
     */
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Song Business service worked!");
    }
    
    //Updates song found in id to something different, unless it is null.
    public void changeSong(int songID, Song song) {
    	

    	//Find out if the location even has a song.
    	if (service.findById(songID) == null)
    	{
    		System.out.println("No Song Found!");
    	}
    	else
    	service.update(songID, song);
    }
    
    
    
	//Getters and Setters for song list
	public List<Song> getSongs() {
		return service.findAll();
	}


	public void setSongs(List<Song> songs) {
		//this.songs = songs;
	}

	//Getters and Setters from detailed list
	public List<Song> getDetailedSongs() {
		return dsongs;
	}
}
