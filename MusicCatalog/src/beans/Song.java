package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
//Product Model
public class Song {
	
	//Initialized values for each
	//Variables go Num, Name, Album, Artist, and Genre, Length
	
	@NotNull(message = "Please enter a number.")
	int num = 1;
	
	
	@NotNull(message = "Please enter a name.")
	@Size(min=1, max=100)
	String name = "";
	
	@NotNull(message = "Please enter an album")
	@Size(min=1, max=40)
	String album = "";
	
	@NotNull(message = "Please enter a artist")
	@Size(min=1, max=40)
	String artist = "";
	
	@NotNull(message = "Please enter a genre")
	@Size(min=3, max=20)
	String genre = "";
	
	public Song()
	{
		num = 1;
		name = "Name";
		album = "Album";
		artist = "Artist";
		genre = "Genre";
		
		
	}

	public Song(int num, String name, String album, String artist, String genre)
	{
		this.num = num;
		this.name = name;
		this.album = album;
		this.artist = artist;
		this.genre = genre;
		
	}

	
	//Getters and Setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
