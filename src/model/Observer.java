package model;

import model.notification.Notification;

public interface Observer {
	public void addNotification (Notification notification);
}
