package model.user;

import model.notification.Notification;

import java.util.ArrayList;

public abstract class User implements java.io.Serializable, IUser {
	private String name;
	private String mail;
	private String password;
	
	protected User isAuthenticated (ArrayList<? extends IUser> userList, String loginMail, String loginPassword) {
		System.out.println("Login button clicked!");
		for (IUser temp: userList) {
			System.out.println(temp.getMail());
			if (temp.getMail().equals(loginMail)) {
				if (temp.getPassword().equals(loginPassword)) {
					User activeUser = (User) temp;
					System.out.println("Logged in!\n Welcome " + activeUser.getName() + "!");
					return (User) temp;
				} else {
					System.out.println("Wrong Password!");
					return null;
				}
			}
		}
		return null;
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
