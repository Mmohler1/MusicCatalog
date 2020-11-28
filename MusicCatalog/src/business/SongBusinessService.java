package business;

import beans.Song;
import data.DataSongInterface;

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
     * Adds a song by calling the database.
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
    
    //Updates song found in id, if null output message that no song was found..
    public void changeSong(Song song) {
    	
    	//Find out if the location even has a song.
    	if (service.findById(song.getId()) == null)
    	{
    		System.out.println("No Song Found!");
    	}
    	else
    	service.update(song);
    }
    
    public void deleteSong(Song song)
    {
    	System.out.println("It worked");
    }
    
	//Getters and Setters for song list
	public List<Song> getSongs() {
		return service.findAll();
	}


	public void setSongs(List<Song> songs) {
		//this.songs = songs;
	}

	//Getters from detailed list
	public List<Song> getFewSongs() {
		return service.findFew();
	}
}
