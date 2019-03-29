package model;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements java.io.Serializable, Listable {
	private String name;
	private String mail;
	private String password;
	
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
