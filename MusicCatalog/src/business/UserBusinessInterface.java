package business;
import javax.ejb.Local;


@Local
public interface UserBusinessInterface {

	public void saveData();
	String findLogin();
	public boolean checkPassword();
    public void test();
	
}
