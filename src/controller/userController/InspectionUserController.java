package controller.userController;

import javafx.event.Event;
import javafx.scene.layout.AnchorPane;
import model.user.User;
import model.user.userTypes.InspectionUser;

import java.io.IOException;

public class InspectionUserController extends UserController {
	private InspectionUser user;
	@Override
	public void loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
	}
	
	@Override
	public void signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
	}
	public void signUpUser (String name, String organization, String mail, String phone, String identificationNumber) {
	
	}
	
	@Override
	public User getActiveUser () {
		return user;
	}
	
	@Override
	public void showDefaultPane (AnchorPane dynamicPane) throws IOException {
	
	}
}
