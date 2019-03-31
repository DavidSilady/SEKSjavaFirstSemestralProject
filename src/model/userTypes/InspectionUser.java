package model.userTypes;

import javafx.event.Event;
import model.Listable;
import model.User;

public class InspectionUser extends User implements java.io.Serializable, Listable {
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
	
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	
	}
}
