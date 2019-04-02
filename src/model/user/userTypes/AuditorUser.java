package model.user.userTypes;

import javafx.event.Event;
import model.user.Listable;
import model.user.User;

public class AuditorUser extends User implements java.io.Serializable, Listable {
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
	
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	
	}
}
