package model;

import controller.LoginController;
import controller.SceneController;
import javafx.event.ActionEvent;
import javafx.event.Event;

import java.util.ArrayList;

public abstract class User implements java.io.Serializable, Listable {
	private String name;
	private String mail;
	private String password;
	
	protected boolean isAuthenticated (ArrayList<? extends Listable> userList) {
		System.out.println("Login button clicked!");
		for (Listable temp: userList) {
			System.out.println(temp.getMail());
			LoginController loginController = new LoginController();
			if (temp.getMail().equals(loginController.getLoginMail().getText())) {
				if (temp.getPassword().equals(loginController.getLoginPassword().getText())) {
					User activeUser = (User) temp;
					System.out.println("Logged in!\n Welcome " + activeUser.getName() + "!");
					return true;
				} else {
					System.out.println("Wrong Password!");
					return false;
				}
			}
		}
		return false;
	}
	
	
	private ArrayList<Notification> notifications = new ArrayList<>();
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getMail () {
		return mail;
	}
	
	public void setMail (String mail) {
		this.mail = mail;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
}
