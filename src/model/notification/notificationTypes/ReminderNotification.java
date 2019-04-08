package model.notification.notificationTypes;

import model.notification.Notification;

public class ReminderNotification extends Notification {
	public ReminderNotification(String text) {
		super.setText(text);
	}
}
