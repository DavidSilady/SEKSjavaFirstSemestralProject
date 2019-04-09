package model.notification.notificationTypes;

import model.notification.Notification;
import model.user.User;

import java.util.Date;

public class WarningNotification extends Notification {
	public WarningNotification(String text) {
		super.setText(text);
	}
	
	@Override
	public void dismiss (User user, Date date) {
		user.getNotifications().remove(this);
	}
}
