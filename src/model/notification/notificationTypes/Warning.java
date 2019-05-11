package model.notification.notificationTypes;

import model.Observable;
import model.notification.Notification;
import model.user.User;

import java.time.LocalDate;

public class Warning extends Notification {
	public Warning (String text, Observable observable) {
		super.setText(text);
		super.setGeneratorName(observable.getName());
		super.setGeneratorType(observable.getClass().getSimpleName());
		super.setNextReminder(LocalDate.now());
	}
	
	/**
	 * Always set the next reminder to now
	 * @param user - owner of the notification
	 */
	@Override
	public void dismiss (User user) {
		user.getNotifications().remove(this);
		super.setNextReminder(LocalDate.now());
	}
}
