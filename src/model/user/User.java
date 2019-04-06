package model.user;

import controller.LoginController;
import model.Notification;
import model.user.userTypes.AuditorUser;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

import java.util.ArrayList;

public abstract class User implements java.io.Serializable, Listable {
	private String name;
	private String mail;
	private String password;
	
	protected boolean isAuthenticated (ArrayList<? extends Listable> userList, String loginMail, String loginPassword, User user) {
		System.out.println("Login button clicked!");
		for (Listable temp: userList) {
			System.out.println(temp.getMail());
			if (temp.getMail().equals(loginMail)) {
				if (temp.getPassword().equals(loginPassword)) {
					user = (User) temp;
					System.out.println("Logged in!\n Welcome " + user.getName() + "!");
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
