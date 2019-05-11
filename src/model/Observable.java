package model;

import model.notification.Notification;
import model.user.User;

public interface Observable {
	void notifyUser (User user, Notification notification);
	
	/**
	 * Used in building notifications
	 * @return the name of the observed object
	 */
	String getName ();
}
