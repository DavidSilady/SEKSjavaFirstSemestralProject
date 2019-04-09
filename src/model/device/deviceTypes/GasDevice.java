package model.device.deviceTypes;

import model.device.Device;
import model.notification.Notification;
import model.notification.notificationTypes.WarningNotification;

import java.util.Date;

public class GasDevice extends Device {
	public GasDevice (String name, String location, String serialNum) {
		super(name, location, serialNum);
		calculateDates();
	}
	
	public void calculateDates () {
		//just illustrative for now
		Date tmp = new Date();
		tmp.setTime(getLastAudition().getTime() + (86400000*365));
		setNextAudition(tmp);
		tmp.setTime(getLastInspection().getTime() + (86400000*365));
		setNextInspection(tmp);
		
		Date today = new Date();
		if (super.getNextAudition().before(today)) {
			Notification warning = new WarningNotification(super.getName() + " requires Audition!");
			notifyUser(warning);
		}
		if (super.getNextInspection().before(today)) {
			Notification warning = new WarningNotification(super.getName() + " requires Inspection!");
			notifyUser(warning);
		}
	}
}
