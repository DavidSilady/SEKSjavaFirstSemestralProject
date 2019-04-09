package model.device.deviceTypes;

import model.device.Device;
import model.notification.Notification;
import model.notification.notificationTypes.WarningNotification;
import model.user.User;
import model.user.userTypes.CompanyUser;

import java.util.Date;

public class ElectronicDevice extends Device {
	
	public ElectronicDevice (String name, String location, String serialNum, User user) {
		super(name, location, serialNum);
		calculateDates(user);
	}
	
	public void calculateDates (User user) {
		//just illustrative for now
		Date tmp = new Date();
		tmp.setTime(getLastAudition().getTime() + (86400000*365*2));
		setNextAudition(tmp);
		tmp.setTime(getLastInspection().getTime() + (86400000*365*2));
		setNextInspection(tmp);
		
		Date today = new Date();
		if (super.getNextAudition().before(today)) {
			Notification warning = new WarningNotification(super.getName() + " requires Audition!");
			notifyUser(warning, user);
		}
		
		if (super.getNextInspection().before(today)) {
			Notification warning = new WarningNotification(super.getName() + " requires Inspection!");
			notifyUser(warning, user);
		}
	}
}
