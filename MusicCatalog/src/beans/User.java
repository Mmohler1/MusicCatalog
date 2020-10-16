package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

@ManagedBean
@ViewScoped
public class User {

		//Initializing the values 
		@NotNull(message = "Please enter a First Name. This is a required field")
		@Size(min=4, max=15)
		String firstName = "";

		@NotNull(message = "Please enter a Last Name. This is a required field")
		@Size(min=4, max=15)
		String lastName = "";

		//@AssertTrue("Email is not valid",isValid(email))
		@NotNull(message = "Please enter an email. This is a required field")
		@Size(min=10, max=20)
		String email  = "";

		@NotNull(message = "Please enter an address. This is a required field")
		@Size(min=10, max=25)
		String address = "";

		@NotNull(message = "Please enter your phone number. This is a required field")
		@Size(min=4, max=15)
		String phoneNumber = "";
	
		@NotNull(message = "Please enter a Username. This is a required field")
		@Size(min=4, max=15)
		String userName = "";
		
		@NotNull(message = "Please enter a password. This is a required field")
		@Size(min=8, max=15)
		String password ="";
		
		//Default Constructor
		public User() 
		{
			firstName = "first name";
			lastName = "last name";
			email = "name@example.com";
			address = "3000 west Ln";
			phoneNumber = "phone number";
			userName = "username";
			password ="password";
		}

		public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void saveData() 
	{
		try 
		{
			FileWriter writer = new FileWriter("RegistrationFile.txt");
			
			writer.write(this.getFirstName() + "\n" + this.getLastName() + "\n" + this.getEmail() + "\n" + this.getAddress()
						 + "\n"+ this.getPhoneNumber()+ "\n"+ this.getUserName()+"\n"+this.getPassword());
			System.out.println("Successfully wrote to the file");
			writer.close();
			
		}
		catch(IOException e) 
		{
			System.out.println("Error occured file wasn't created");
			e.printStackTrace();
		}	
	}
		
		
}
