package business;
import javax.ejb.Local;

import beans.User;


@Local
public interface UserBusinessInterface {

	public void saveData(User user);
	String findLogin(String username);
	public boolean checkPassword(User user);
    public void test();
	
}
