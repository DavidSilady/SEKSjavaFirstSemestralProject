package model.notification.notificationTypes;

import model.Observable;
import model.notification.Notification;
import model.user.User;

import java.time.LocalDate;

public class Reminder extends Notification {
	
	@Override
	public void dismiss(User user) {
		user.getNotifications().remove(this);
		super.setNextReminder(LocalDate.now().plusDays(user.getDismissLimitInDays()));
	}
	
	public Reminder (String text, Observable observable) {
		super.setText(text);
		super.setAggregatorName(observable.getName());
		super.setAggregatorType(observable.getClass().getSimpleName());
		super.setNextReminder(LocalDate.now());
	}
}
