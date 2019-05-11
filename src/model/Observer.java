package model;

import model.notification.Notification;

public interface Observer {
	void addNotification (Notification notification);
}
