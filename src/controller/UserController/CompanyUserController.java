package controller.UserController;

import controller.SceneController;
import javafx.event.Event;
import model.user.User;
import model.user.userTypes.CompanyUser;

public class CompanyUserController extends UserController {
	private CompanyUser user = new CompanyUser();
	
	public User getUser() {
		return user;
	}
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		if (user.loginUser(actionEvent, loginMail, loginPassword, user)) {
			sceneController.switchStage(actionEvent, "userInterface");
		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public void signUpUser (Event actionEvent,
	                        String companyName,
	                        String companyICO,
	                        String email,
	                        String phone,
	                        String password) throws Exception{
		user.signUpUser(actionEvent, companyName, companyICO, email, phone, password);
		System.out.println("Signed up!");
		SceneController sceneController = new SceneController();
		sceneController.switchStage(actionEvent, "userInterface");
	}
}
