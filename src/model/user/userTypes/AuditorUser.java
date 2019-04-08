package model.user.userTypes;

import javafx.event.Event;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;

public class AuditorUser extends User implements Serializable, IUser {
	
	@Override
	public User loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		if(loginMail.equals("admin") && loginPassword.equals("admin"))
			return new AuditorUser();
		return null;
	}
	
	@Override
	public User signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
		return null;
	}
}
