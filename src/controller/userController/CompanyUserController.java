package controller.userController;

import controller.DeviceMenuController;
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
	
	@Override
	public User getActiveUser () {
		return activeUser;
	}
	
	@Override
	public void showDefaultPane (AnchorPane dynamicPane) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/deviceMenu.fxml"));
		Pane deviceMenu = (Pane) fxmlLoader.load();
		DeviceMenuController deviceMenuController = fxmlLoader.getController();
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/view/deviceList.fxml"));
		Pane deviceList = (Pane) fxmlLoader1.load();
		deviceMenuController.setDynamicDevicePane(deviceList);
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		CompanyUser temp = new CompanyUser();
		activeUser = (CompanyUser) temp.loginUser(loginMail, loginPassword);
		if (activeUser != null){
			sceneController.switchStage(actionEvent, "companyUserInterface");
		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public void signUpUser (Event actionEvent,
	                        String name,
	                        String organizationID,
	                        String email,
	                        String phone,
	                        String password) throws Exception{
		CompanyUser temp = new CompanyUser();
		activeUser = (CompanyUser) temp.signUpUser(name, organizationID, email, phone, password);
		System.out.println("Signed up!");
		SceneController sceneController = new SceneController();
		sceneController.switchStage(actionEvent, "companyUserInterface");
	}
	
}
