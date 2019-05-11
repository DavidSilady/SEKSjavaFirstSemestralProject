package controller.userController;

import controller.SceneController;
import javafx.event.Event;
import javafx.scene.layout.AnchorPane;
import model.user.User;
import model.user.userTypes.InspectionUser;

import java.io.IOException;

public class InspectionUserController extends UserController {
	private InspectionUser activeUser;
	
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		InspectionUser temp = new InspectionUser();
		activeUser = (InspectionUser) temp.loginUser(loginMail, loginPassword);
		if (activeUser != null){
			sceneController.switchStage(actionEvent, "inspectionUserInterface");
		}
	}
	
	
	@Override
	public void signUpUser (Event actionEvent, String name, String organizationID, String email, String phone, String password) throws Exception {
		InspectionUser temp = new InspectionUser();
		activeUser = (InspectionUser) temp.signUpUser(name, organizationID, email, phone, password);
		System.out.println("Signed up!");
	}
	
	@Override
	public User getActiveUser () {
		return activeUser;
	}
	
	@Override
	public void showDefaultPane (AnchorPane dynamicPane) throws IOException {
	
	}
}
