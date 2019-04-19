package model.notification.notificationTypes;

import model.Observable;
import model.device.Device;
import model.notification.Notification;
import model.user.User;

import java.time.LocalDate;
import java.util.Date;

public class ReminderNotification extends Notification {
	
	@Override
	public void dismiss(User user) {
		user.getNotifications().remove(this);
		super.setNextReminder(LocalDate.now().plusDays(user.getDismissTime()));
	}
	
	public ReminderNotification(String text, Observable observable) {
		super.setText(text);
		super.setAggregatorName(observable.getName());
		super.setAggregatorType(observable.getClass().getSimpleName());
		super.setNextReminder(LocalDate.now());
	}
}
