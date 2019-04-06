package controller.UserController;

import controller.SceneController;
import javafx.event.Event;
import model.user.userTypes.CompanyUser;

public class CompanyUserController extends UserController {
	private CompanyUser companyUser = new CompanyUser();
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		if (companyUser.loginUser(actionEvent, loginMail, loginPassword, companyUser)) {
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
		companyUser.signUpUser(actionEvent, companyName, companyICO, email, phone, password);
		System.out.println("Signed up!");
		SceneController sceneController = new SceneController();
		sceneController.switchStage(actionEvent, "userInterface");
	}
}
