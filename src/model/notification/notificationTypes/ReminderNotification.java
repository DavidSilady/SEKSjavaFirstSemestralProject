package model.notification.notificationTypes;

import model.notification.Notification;
import model.user.User;

import java.util.Date;

public class ReminderNotification extends Notification {
	private Date nextReminder = new Date(0);
	
	public void dismiss(User user, Date date) {
		user.getNotifications().remove(this);
		setNextReminder(date);
	}
	
	public void checkNextReminder(User user) {
		if (new Date().after(nextReminder)) {
			user.getNotifications().add(this);
		}
	}
	
	private void setNextReminder (Date date) {
		this.nextReminder = date;
	}
	
	public ReminderNotification(String text) {
		super.setText(text);
	}
}
