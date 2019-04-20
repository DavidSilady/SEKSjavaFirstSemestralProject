package model.device;

import model.notification.Notification;
import model.Observable;
import model.notification.notificationTypes.Reminder;
import model.notification.notificationTypes.Warning;
import model.user.User;
import model.user.userTypes.InspectionUser;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//gonna be abstract . . . one day. . .
public abstract class Device implements Serializable, Observable {
	private String name;
	private String location;
	private String serialNum;
	
	private InspectionUser inspection;
	
	private String note;
	
	private LocalDate lastInspection = LocalDate.now();
	private LocalDate nextInspection = LocalDate.now();
	
	private LocalDate lastAudition = LocalDate.now();
	private LocalDate nextAudition = LocalDate.now();
	
	private Notification inspectionNotification;
	private Notification auditionNotification;
	
	public abstract void calculateNextInspection();
	public abstract void calculateNextAudition ();
	
	public void checkForNotifications (User user) {
		checkForReminders(user);
		checkForWarnings(user);
		try {
			if (inspectionNotification.getNextReminder().isBefore(LocalDate.now().plusDays(1))) {
				notifyUser(user, inspectionNotification);
			}
		} catch (NullPointerException npe) {
			System.out.println("No notifications found!");
		}
		try {
			if (auditionNotification.getNextReminder().isBefore(LocalDate.now().plusDays(1))) {
				notifyUser(user, auditionNotification);
			}
		} catch (NullPointerException npe) {
			System.out.println("No notifications found!");
		}
	}
	
	public Device (String name, String location, String serialNum) {
		this.name = name;
		this.location = location;
		this.serialNum = serialNum;
	}
	
	public void notifyUser(User user, Notification notification) {
		if(!user.getNotifications().contains(notification))
		user.addNotification(notification);
	}
	
	private void checkForWarnings(User user) {
		if (auditionNotification == null || !auditionNotification.getClass().isInstance(new Warning("", this))) {
			if (getNextAudition().isBefore(LocalDate.now().plusDays(1))) {
				this.auditionNotification = new Warning(getName() + " requires Audition!", this);
			}
		}
		if (inspectionNotification == null || !inspectionNotification.getClass().isInstance(new Warning("", this))) {
			if (getNextInspection().isBefore(LocalDate.now().plusDays(1))) {
				this.inspectionNotification = new Warning(getName() + " requires Inspection!", this);
			}
		}
	}
	
	private void checkForReminders(User user) {
		if (this.auditionNotification == null) {
			if (getNextAudition().isBefore(LocalDate.now().plusMonths(1))) {
				this.auditionNotification = new Reminder(getName() + " requires Audition next Month.", this);
			}
		}
		
		if (this.inspectionNotification == null) {
			if (getNextInspection().isBefore(LocalDate.now().plusMonths(1))) {
				this.inspectionNotification = new Reminder(getName() + " requires Inspection next Month.", this);
			}
		}
	}
	
	
	//GETTERS N SETTERS
	public void setNextInspection (LocalDate nextInspection) {
		this.nextInspection = nextInspection;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getLocation () {
		return location;
	}
	
	public void setLocation (String location) {
		this.location = location;
	}
	
	public String getSerialNum () {
		return serialNum;
	}
	
	public void setSerialNum (String serialNum) {
		this.serialNum = serialNum;
	}
	
	
	public LocalDate getLastInspection () {
		return lastInspection;
	}
	
	public void setLastInspection (LocalDate lastInspection) {
		this.lastInspection = lastInspection;
	}
	
	public LocalDate getNextInspection () {
		return nextInspection;
	}
	
	public LocalDate getLastAudition () {
		return lastAudition;
	}
	
	public void setLastAudition (LocalDate lastAudition) {
		this.lastAudition = lastAudition;
	}
	
	public LocalDate getNextAudition () {
		return nextAudition;
	}
	
	public void setNextAudition (LocalDate nextAudition) {
		this.nextAudition = nextAudition;
	}
}
