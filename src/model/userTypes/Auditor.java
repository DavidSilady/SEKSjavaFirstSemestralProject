package model.userTypes;

import javafx.event.Event;
import model.Listable;
import model.User;

public class Auditor extends User implements java.io.Serializable, Listable {
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
	
	}
}
