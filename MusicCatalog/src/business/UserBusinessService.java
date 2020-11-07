package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.User;

//Reading files
import java.io.File;  //Importing the File
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Session Bean implementation class UserBusinessService
 */
@Stateless
@Local(UserBusinessInterface.class)
@LocalBean
@Alternative
public class UserBusinessService implements UserBusinessInterface {

    /**
     * Default constructor. 
     */
    public UserBusinessService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see UserBusinessInterface#findLogin()
     */
    public String findLogin(String username) {
    	try 
		{
			//Looks for username in file
			//FilePath in bin under wildfly 11
			File RegFile = new File("RegistrationFile.txt"); 
			Scanner theReader = new Scanner(RegFile);
			
			//Will stop the loop if there is nothing left in the file
			while (theReader.hasNextLine())
			{
				//Takes file to line 6 which has the username. 
				for(int x = 0; x<5; x++)
				{
					theReader.nextLine();
				}
				
				//If the username fits then return password
				if (theReader.nextLine().equals(username))
				{
					String password = theReader.nextLine();
					
					//Closes file to allow others to use
					theReader.close();
					
					return password;
					
				}
				//returns nothing if username not found
				else
				{
					theReader.close();
					return null;
				}
			}
			//returns nothing if file reaches the end
			theReader.close();
			return null;
			
		}
		catch (FileNotFoundException e)
		{
			//Debugging, Tells maintenance it's an issue with the file.  
			System.out.println("File couldn't be read!");
			
			return null;
			
		}
		
    }

	/**
     * @see UserBusinessInterface#checkPassword()
     */
    public boolean checkPassword(User user) {
        // TODO Auto-generated method stub
    	//Saves parameters from user
    			String name = user.getUserName();
    			String password = user.getPassword();
    			
    			//Searches file for users password and saves it.
    			String loginPassword = findLogin(name);
    			if(loginPassword.equals(password))
    			{
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    }

	/**
     * @see UserBusinessInterface#saveData()
     */
    public void saveData() {
        // TODO Auto-generated method stub
    }
    
    public void test()
    {
    	System.out.println("HI----------------------------------------------------------HI");
    }
    

}
