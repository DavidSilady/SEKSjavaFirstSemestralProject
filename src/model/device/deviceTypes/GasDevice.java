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
	
	private void calculateDates() {
		//just illustrative for now
		super.getNextAudition().setYear(super.getLastAudition().getYear() + 1);
		super.getNextInspection().setYear(super.getLastInspection().getYear() + 1);
		Date today = new Date();
		if (super.getNextAudition().before(today)) {
			Notification warning = new WarningNotification();
			notifyUser(warning);
		}
		if (super.getNextInspection().before(today)) {
			Notification warning = new WarningNotification();
			notifyUser(warning);
		}
	}
}
