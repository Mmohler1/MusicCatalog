package business;

import beans.Song;

import java.util.ArrayList;
import java.util.List;
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

	
	//Array List of Songs
	List <Song> songs = new ArrayList<Song>();
	
	
	//Default constructor, mostly used for testing
    public SongBusinessService() 
    {
        // TODO Auto-generated constructor stub
    	//Default add 

    }
    
    
    
    //Default Constructor, used for testing
	public void addSong()
	{
		System.out.println("Hi---------------------------");
	   	songs.add(new Song(1, "Run This Town", "The Blueprint 3", "Jay-Z", "Rap"));
    	songs.add(new Song(2, "Welcome To the Jungle", "Appetite for Destruction", "Guns N' Roses", "Rock"));
    	songs.add(new Song(3, "Crazy", "Personnel", "Patsy Cline", "Country"));
 

	}
    
    //Constructor
	public void addSong(int num, String name, String album, String artist, String genre)
	{
		songs.add(new Song(num, name, album, artist, genre));

	}


	
	//Getters and Setters for song list
	public List<Song> getSongs() {
		return songs;
	}


	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	

}
