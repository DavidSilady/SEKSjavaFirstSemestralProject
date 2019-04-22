package model.user;

import javafx.event.Event;

public interface IUser {
	String getMail ();
	String getPassword ();
	User loginUser(String loginMail, String loginPassword);
	User signUpUser(String name,
	                       String organizationID,
	                       String email,
	                       String phone,
	                       String password);
}
