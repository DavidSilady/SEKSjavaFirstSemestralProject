package controller.UserController;

import javafx.event.Event;
import model.user.User;
import model.user.userTypes.InspectionUser;

public class InspectionUserController extends UserController {
	private InspectionUser user = new InspectionUser();
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
	
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	
	}
	
	@Override
	public User getUser () {
		return user;
	}
}
