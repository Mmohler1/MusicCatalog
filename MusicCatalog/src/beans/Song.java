package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
//Product Model
public class Song {
	
	//Initialized values for each
	//Variables go Num, Name, Album, Artist, and Genre, Length
	
	
	int num = 1;
	
	String name = "";
	
	String album = "";
	
	String artist = "";
	
	String genre = "";
	
	public Song()
	{
		num = 1;
		name = "name";
		album = "album";
		artist = "artist";
		genre = "genre";
		
		
	}

	public Song(int num, String name, String album, String artist, String genre)
	{
		this.num = num;
		this.name = name;
		this.album = album;
		this.artist = album;
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
