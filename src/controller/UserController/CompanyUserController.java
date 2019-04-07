package controller.UserController;

import controller.SceneController;
import javafx.event.Event;
import model.user.User;
import model.user.userTypes.CompanyUser;

public class CompanyUserController extends UserController {
	private CompanyUser activeUser;
	
	public User getActiveUser () {
		return activeUser;
	}
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		CompanyUser temp = new CompanyUser();
		activeUser = (CompanyUser) temp.loginUser(actionEvent, loginMail, loginPassword, activeUser);
		if (activeUser != null){
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
		CompanyUser temp = new CompanyUser();
		activeUser = (CompanyUser) temp.signUpUser(actionEvent, companyName, companyICO, email, phone, password);
		System.out.println("Signed up!");
		SceneController sceneController = new SceneController();
		sceneController.switchStage(actionEvent, "userInterface");
	}
}
