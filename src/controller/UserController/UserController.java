package controller.UserController;

import javafx.event.Event;

public abstract class UserController {
	private static UserController userController;
	public static UserController getInstance() {
		return userController;
	}
	public void castToCompanyController() {
		userController = new CompanyUserController();
	}
	public void castToAuditorController() {
		userController = new AuditorUserController();
	}
	public void castToInspectionController() {
		userController = new InspectionUserController();
	}
	public void loginUser (Event actionEvent,
	                String loginMail,
	                String loginPassword) throws Exception {};
	
	public void signUpUser (Event actionEvent,
	                 String companyName,
	                 String companyICO,
	                 String email,
	                 String phone,
	                 String password) throws Exception {};
}
