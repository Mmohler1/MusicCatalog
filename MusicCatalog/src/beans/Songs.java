package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Songs {
	static //Array List of Songs
		List <Song> songs = new ArrayList<Song>();
		
		
		//Default constructor, Might be used for testing
	    public Songs() 
	    {
	        // TODO Auto-generated constructor stub
	    	//Default add 


	    }
	    
	    
	    
	    //Default Constructor, used for testing
		public static void addSong()
		{
			System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEEEH");
	
	    	songs.add(new Song(1, "Run This Town", "The Blueprint 3", "Jay-Z", "Rap"));
	    	songs.add(new Song(2, "Welcome To the Jungle", "Appetite for Destruction", "Guns N' Roses", "Rock"));
	    	songs.add(new Song(3, "Crazy", "Personnel", "Patsy Cline", "Country"));
	 

		}
	    
	    //Constructor
		public static void addSong(int num, String name, String album, String artist, String genre)
		{
			songs.add(new Song(num, name, album, artist, genre));

		}


		
		//Getters and Setters for song list
		public List<Song> getSongs() {
			return songs;
		}


		public void setSongs(List<Song> songs) {
			Songs.songs = songs;
		}
		
		

	}
