package controller;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

//Imports user class
import beans.User;
import business.UserBusinessInterface;
import beans.Song;
import beans.Songs;



@ManagedBean
@ViewScoped
public class principle {

	
	@Inject
	UserBusinessInterface service;
	
	
	Songs songList = new Songs();
	
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
		
		
		//if both passwords are the same then forward to main page
		if (service.checkPassword(user))
		{
			
			
			
			//New Testing! ------------------------------------------
			service.test();
			

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
	
	
	//Button that adds a song to the product list
	public String addProduct(Song song)
	{
		//adds song from the values added in the get button page.
		Songs.addSong(
				song.getNum(), 
				song.getName(), 
				song.getAlbum(), 
				song.getArtist(), 
				song.getGenre());
		
		return "Main.xhtml";
	}

	
	
	public UserBusinessInterface getService()
	{
		return service;
	}
	
}

