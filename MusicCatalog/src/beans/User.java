package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

@ManagedBean
@ViewScoped
public class User {

		//Initializing the values 
	
		@NotNull(message = "Username can't be empty!")
		String username ="";
		
		@NotNull(message = "Password can't be empty!")
		String password = "";
		
		//Default Constructor
		public User()
		{
			username ="Michael";
			password ="Password";
			
		}

		//Get for first name
		public String getUsername() {
			return username;
		}
		
		//Set for first name
		public void setUsername(String username) {
			this.username = username;
		}

		//Get for last name
		public String getPassword() {
			return password;
		}

		//Set for last name
		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
