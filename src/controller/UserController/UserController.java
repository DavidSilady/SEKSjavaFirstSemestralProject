package controller.UserController;

import javafx.event.Event;
import model.user.User;

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
	
	public abstract User getUser ();
}
