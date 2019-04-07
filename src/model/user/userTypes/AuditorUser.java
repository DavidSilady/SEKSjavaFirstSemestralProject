package model.user.userTypes;

import javafx.event.Event;
import model.user.Listable;
import model.user.User;

import java.io.Serializable;

public class AuditorUser extends User implements Serializable, Listable {
	
	@Override
	public User loginUser (Event actionEvent, String loginMail, String loginPassword, User user) throws Exception {
		
		return null;
	}
	
	@Override
	public User signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
		return null;
	}
}
