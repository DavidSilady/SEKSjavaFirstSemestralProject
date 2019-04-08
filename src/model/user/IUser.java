package model.user;

import javafx.event.Event;

public interface IUser {
	String getMail ();
	String getPassword ();
	User loginUser(Event actionEvent, String loginMail, String loginPassword) throws Exception;
	User signUpUser(Event actionEvent,
	                       String companyName,
	                       String companyICO,
	                       String email,
	                       String phone,
	                       String password) throws Exception;
}
