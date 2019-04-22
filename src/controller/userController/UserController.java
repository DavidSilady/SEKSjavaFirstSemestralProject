package controller.userController;

import javafx.event.Event;
import javafx.scene.layout.AnchorPane;
import model.user.User;

import java.io.IOException;

public abstract class UserController {
	private static UserController userController;
	public static UserController getInstance() {
		return userController;
	}
	public static void castToCompanyController() {
		userController = new CompanyUserController();
	}
	public static void castToAuditorController() {
		userController = new AuditorUserController();
	}
	public static void castToInspectionController() {
		userController = new InspectionUserController();
	}
	
	public abstract void loginUser (Event actionEvent,
	                String loginMail,
	                String loginPassword) throws Exception;
	
	public abstract void signUpUser (Event actionEvent,
	                 String companyName,
	                 String companyICO,
	                 String email,
	                 String phone,
	                 String password) throws Exception;
	public abstract void signUpUser (String name, String organization, String mail, String phone, String identificationNumber);
	
	public abstract User getActiveUser ();
	
	public abstract void showDefaultPane (AnchorPane dynamicPane) throws IOException;
}
