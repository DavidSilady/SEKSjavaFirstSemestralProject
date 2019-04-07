package controller.UserController;

import javafx.event.Event;
import model.user.User;
import model.user.userTypes.AuditorUser;

public class AuditorUserController extends UserController {
	private AuditorUser user = new AuditorUser();
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
	
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	
	}
	
	@Override
	public User getActiveUser () {
		return user;
	}
}
