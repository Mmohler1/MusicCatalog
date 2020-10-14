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
			//FilePath in bin under wildfly 11
			File RegFile = new File("TextFile.txt");
			Scanner theReader = new Scanner(RegFile);
			
			while (theReader.hasNextLine())
			{
				for(int x = 0; x<5; x++)
				{
					theReader.nextLine();
				}
				
				if (theReader.nextLine().equals(Username))
				{
					String password = theReader.nextLine();
					
					
					theReader.close();
					
					return password;
					
				}
				else
				{
					theReader.close();
					return null;
				}
			}
			theReader.close();
			return null;
			
		}
		catch (FileNotFoundException e)
		{
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
		return "TestResponse.xhtml";
	}
	
	
	//Submit by the user in the test form using the methods parameters.
	public String onSubmit(User user)
	{
		String name = user.getUsername();
		String password = user.getPassword();
		
		String loginPassword = findLogin(name);
		if (password.equals(loginPassword))
		{
			
			//Forward to test response view with the user managed bean.
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "TestResponse.xhtml";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown username or password"));
			return "Login.xhtml";
		}
		
	}

	
}
