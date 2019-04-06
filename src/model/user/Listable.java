package model.user;

import javafx.event.Event;

public interface Listable {
	String getMail ();
	String getPassword ();
	boolean loginUser(Event actionEvent, String loginMail, String loginPassword, User user) throws Exception;
	public void signUpUser(Event actionEvent,
	                       String companyName,
	                       String companyICO,
	                       String email,
	                       String phone,
	                       String password) throws Exception;
}
