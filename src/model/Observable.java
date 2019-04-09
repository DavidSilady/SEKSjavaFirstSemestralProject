package model;

import model.notification.Notification;

public interface Observable {
	public void notifyUser(Notification notification);
}
