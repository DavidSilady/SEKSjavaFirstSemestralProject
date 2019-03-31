package model;

import javafx.event.Event;

public interface Listable {
	String getMail ();
	String getPassword ();
	void loginUser(Event actionEvent, String loginMail, String loginPassword) throws Exception;
	public void signUpUser(Event actionEvent,
	                       String companyName,
	                       String companyICO,
	                       String email,
	                       String phone,
	                       String password) throws Exception;
}
