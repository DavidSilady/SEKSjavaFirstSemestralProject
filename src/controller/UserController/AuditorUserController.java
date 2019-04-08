package controller.UserController;

import controller.SceneController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.user.User;
import model.user.userTypes.AuditorUser;

import java.io.IOException;

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
	
	@Override
	public void showDefault (AnchorPane dynamicPane) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/companyMenu.fxml"));
		Pane deviceListTable = (Pane) fxmlLoader.load();
		try {
			dynamicPane.getChildren().clear();
			dynamicPane.getChildren().add(deviceListTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
