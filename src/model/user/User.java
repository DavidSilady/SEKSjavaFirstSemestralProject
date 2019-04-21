package model.user;

import model.Observer;
import model.notification.Notification;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable, IUser, Observer {
	private String name;
	private String mail;
	private String password;
	private int dismissLimitInDays = 1; // in days
	
	private ArrayList<Notification> notifications = new ArrayList<>();
	public abstract void updateNotifications ();
	public void addNotification (Notification notification) {
		notifications.add(notification);
	}
	
	public ArrayList<Notification> getNotifications() {
		return notifications;
	}
	
	protected User isAuthenticated (ArrayList<? extends IUser> userList, String loginMail, String loginPassword) {
		try {
			for (IUser temp: userList) {
				if (temp.getMail().equals(loginMail)) {
					if (temp.getPassword().equals(loginPassword)) {
						User activeUser = (User) temp;
						printNotifications(activeUser);
						return (User) temp;
					} else {
						return null;
					}
				}
			}
		} catch (NullPointerException npe) {
			System.out.println("UserList not found!");
		}
		return null;
	}
	
	public void printNotifications(User user) {
		for (Notification tmp: user.getNotifications() ) {
			System.out.println(tmp.getText());
		}
	}
	
	//GETTERS AND SETTERS
	
	
	public int getDismissLimitInDays () {
		return dismissLimitInDays;
	}
	
	public void setDismissLimitInDays (int dismissLimitInDays) {
		this.dismissLimitInDays = dismissLimitInDays;
	}
	
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
