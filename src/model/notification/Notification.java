package model.notification;

import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Notification implements Serializable {
	private String text;
	
	public String getText () {
		return text;
	}
	
	public void setText (String text) {
		this.text = text;
	}
	
	public abstract void dismiss(User user, Date date);
}
