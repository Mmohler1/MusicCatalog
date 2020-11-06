package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

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
    public String findLogin() {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see UserBusinessInterface#checkPassword()
     */
    public boolean checkPassword() {
        // TODO Auto-generated method stub
			return false;
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
