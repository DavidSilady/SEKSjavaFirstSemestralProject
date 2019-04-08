package model;

import model.Notification;

public interface Observer {
	public void update(Notification notification);
}
