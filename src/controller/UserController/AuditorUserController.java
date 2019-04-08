package controller.UserController;

import controller.SceneController;
import javafx.event.Event;
import model.user.User;
import model.user.userTypes.AuditorUser;

public class AuditorUserController extends UserController {
	private AuditorUser user;
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		user = (AuditorUser) new AuditorUser().loginUser(actionEvent, loginMail, loginPassword);
		if (user != null) {
			SceneController sceneController = new SceneController();
			sceneController.switchStage(actionEvent, "auditorUserInterface");
		}
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	}
	
	@Override
	public User getActiveUser () {
		return user;
	}
}
