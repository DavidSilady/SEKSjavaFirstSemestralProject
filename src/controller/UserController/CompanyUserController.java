package controller.UserController;

import controller.SceneController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.user.User;
import model.user.userTypes.CompanyUser;

import java.io.IOException;

public class CompanyUserController extends UserController {
	private CompanyUser activeUser;
	
	public User getActiveUser () {
		return activeUser;
	}
	
	@Override
	public void showDefault (AnchorPane dynamicPane) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceMenu.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		CompanyUser temp = new CompanyUser();
		activeUser = (CompanyUser) temp.loginUser(actionEvent, loginMail, loginPassword);
		if (activeUser != null){
			sceneController.switchStage(actionEvent, "companyUserInterface");
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
		sceneController.switchStage(actionEvent, "companyUserInterface");
	}
}
