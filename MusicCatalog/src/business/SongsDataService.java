package business;

import beans.Song;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SongsDataService
 */
@Stateless
@Local(DataSongInterface.class)
@LocalBean
public class SongsDataService implements DataSongInterface {

	//Sets up which server to access for the entire program. 
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "chair";        //NEEDS TO BE CHANGE FOR EACH PERSONS POSTGRES PASSWORD!!!!!!!!!!!!

	
	/**
     * @see DataSongInterface#display()
     * Displays all the songs to the user from the database
     */
    public List<Song> findAll() {
        // TODO Auto-generated method stub
		Connection conn = null;	
		String sql = "SELECT * FROM milestone.SONGS";
		List<Song> songs = new ArrayList<Song>();
		
		try
		{
			//Connecting to database
			conn = DriverManager.getConnection(url, username, password);
			
			//Execute SQL Query and loop
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				//add new order with each new table
				songs.add(new Song(rs.getInt("ID"),
						rs.getInt("SONG_NO"),
						rs.getString("SONG_NAME"), 
						rs.getString("SONG_ALBUM"), 
						rs.getString("SONG_ARTIST"),
						rs.getString("SONG_GENRE")));			
			}
			
			
			conn.close();
			return songs;
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
			return null;
			
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
    }
	
	/**
     * @see DataSongInterface#update(Song)
     * updates the songs based on the ID in the database
     */
    public void update(int songID, Song song) {
        // TODO Auto-generated method stub
   	Connection conn = null;
    	
    	Song updateSong = song;
    	//Default values for string
		String sql = "UPDATE milestone.SONGS SET " + 
				"SONG_NO = "+ updateSong.getNum() + ", " +
				"SONG_NAME = '"+ updateSong.getName() + "', " +
				"SONG_ALBUM = '"+ updateSong.getAlbum() + "', " + 
				"SONG_ARTIST = '"+ updateSong.getArtist() + "', " +
				"SONG_GENRE = '"+updateSong.getGenre() + 
				"' WHERE ID = " + songID + ";";
		System.out.println(sql);
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
    	
    }

    
	/**
     * @see DataSongInterface#delete(Song)
     * Deletes the chosen song from database.
     */
    public void delete(Song song) {
        // TODO Auto-generated method stub
    }

    
	/**
     * @see DataSongInterface#detail(Song)
     * Shows all the details for the chosen song.
     */
    public void detail(Song song) {
        // TODO Auto-generated method stub
    }

    

	/**
     * @see DataSongInterface#create(Song)
     * Adds a song to the database
     */
    public void create(Song song) {
        // TODO Auto-generated method stub
    	Connection conn = null;
    	
    	Song newSong = song;
    	//Default values for string
		String sql = "INSERT INTO  milestone.SONGS(SONG_NO, SONG_NAME, SONG_ALBUM, SONG_ARTIST, SONG_GENRE) VALUES(" + 
				newSong.getNum() + ", '" +
				newSong.getName() + "', '" +
				newSong.getAlbum() + "', '" + 
				newSong.getArtist() + "', '" +
				newSong.getGenre() + "')";
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
    }
    
    
    
    
    //Returns song based on the ID in the Database
    public Song findById(int id) {
        // TODO Auto-generated method stub
    	Connection conn = null;	
		String sql = "SELECT * FROM milestone.SONGS";
		Song song = null;
		int newId = id;
		
		try
		{
			//Connecting to database
			conn = DriverManager.getConnection(url, username, password);
			
			//Execute SQL Query and loop
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				
				//add new order with each new table
				if (rs.getInt("ID") == newId)
				{
					
					song = new Song(rs.getInt("ID"),
							rs.getInt("SONG_NO"),
							rs.getString("SONG_NAME"), 
							rs.getString("SONG_ALBUM"), 
							rs.getString("SONG_ARTIST"),
							rs.getString("SONG_GENRE"));
				}
			}
			
			
			conn.close();
			return song;
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
			return null;
			
		}
		finally
		{
			//Database cleaning
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
    }
    
    //Tests to see if class is working
    public void test()
    {
    	System.out.println("test");
    }

}
