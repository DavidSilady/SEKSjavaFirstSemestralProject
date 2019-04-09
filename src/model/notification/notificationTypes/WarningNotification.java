package model.notification.notificationTypes;

import model.notification.Notification;

public class WarningNotification extends Notification {
	public WarningNotification(String text) {
		super.setText(text);
	}
}
