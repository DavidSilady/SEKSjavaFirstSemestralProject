package model;

import model.notification.Notification;

public interface Observer {
	public void update(Notification notification);
}
