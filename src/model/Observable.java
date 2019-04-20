package model;

import model.notification.Notification;
import model.user.User;

public interface Observable {
	public void notifyUser(User user, Notification notification);
	
	String getName ();
}
