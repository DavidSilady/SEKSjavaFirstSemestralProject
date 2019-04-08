package model.notification;

import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Notification implements Serializable {
	private String text;
	
	public String getText () {
		return text;
	}
	
	public void setText (String text) {
		this.text = text;
	}
}
