package model.user.userTypes;

import javafx.event.Event;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;

public class AuditorUser extends User implements Serializable, IUser {
	
	@Override
	public User loginUser (String loginMail, String loginPassword) {
		if(loginMail.equals("admin") && loginPassword.equals("admin"))
			return new AuditorUser();
		return null;
	}
	
	@Override
	public User signUpUser (String name, String companyICO, String email, String phone, String password) {
		return null;
	}
	
	@Override
	public void updateNotifications () {
	
	}
}
