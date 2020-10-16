package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

//Imports user class
import beans.User;

//Reading files
import java.io.File;  //Importing the File
import java.io.FileNotFoundException;
import java.util.Scanner;

@ManagedBean
@ViewScoped
public class principle {

	
	//Searches a file for a username and then returns the password.
	String findLogin(String Username)
	{
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
				if (theReader.nextLine().equals(Username))
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
	
	//Default constructor 
	public String onSubmit()
	{
		//Get the User Managed bean
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}s", User.class);
		
		//Forward to Test Response View along with the user Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "Main.xhtml";
	}
	
	
	//Submits button that checks if username and password match
	public String onSubmit(User user)
	{
		//Saves parameters from user
		String name = user.getUserName();
		String password = user.getPassword();
		
		//Searches file for users password and saves it.
		String loginPassword = findLogin(name);
		
		//if both passwords are the same then forward to main page
		if (password.equals(loginPassword))
		{
			
			//Forward to test response view with the user managed bean.
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "Main.xhtml";
		}
		//If password is not the same then tell customer unknown information.
		else
		{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown username or password"));
			return "Login.xhtml";
		}
		
	}

	
}
