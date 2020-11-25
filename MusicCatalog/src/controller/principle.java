package controller;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

//Imports user class
import beans.User;
import business.SongBusinessInterface;
import business.UserBusinessInterface;
import beans.Song;



@ManagedBean
@ViewScoped
public class principle {

	
	@Inject
	UserBusinessInterface userService;
	
	@EJB
	SongBusinessInterface service;
	
	
	
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
		if (userService.checkPassword(user))
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
	
	
	public String onUpdate(Song song)
	{
		//Forward response view with the song managed bean.
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("song", song);
		return "UpdateSong.xhtml";
	}
	
	
	public String onDetailed(Song song)
	{
		//Forward response view with the song managed bean.
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("songs", song);
		return "DetailSong.xhtml";
	}
	
	
	
	//Button that adds a song to the product list
	public String addProduct(Song song)
	{
		//adds song from the values added in the get button page.
		service.addSong(song);
		

		
		return "Main.xhtml";
	}

	//Button that adds a song to the product list
	public String changeProduct(Song song)
	{
		int songID = song.getId();
		//Changes song with values from the 
		service.changeSong(songID, song);
		

		
		return "UpdateSong.xhtml";
	}
	
	public void detailedProduct(int songID)
	{
		
	}
	
	public UserBusinessInterface getService1()
	{
		return userService;
	}
	
	public SongBusinessInterface getService()
	{
		return service;
	}
	
}

