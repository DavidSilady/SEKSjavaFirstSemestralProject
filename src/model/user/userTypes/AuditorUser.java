package model.user.userTypes;

import javafx.event.Event;
import model.user.Listable;
import model.user.User;

public class AuditorUser extends User implements java.io.Serializable, Listable {
	
	@Override
	public boolean loginUser (Event actionEvent, String loginMail, String loginPassword, User user) throws Exception {
		
		return false;
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	
	}
}
