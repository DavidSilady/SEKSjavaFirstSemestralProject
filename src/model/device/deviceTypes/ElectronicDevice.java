package model.device.deviceTypes;

import model.device.Device;
import model.notification.Notification;
import model.notification.notificationTypes.WarningNotification;
import model.user.userTypes.CompanyUser;

import java.util.Date;

public class ElectronicDevice extends Device {
	
	public ElectronicDevice (String name, String location, String serialNum, CompanyUser companyUser) {
		super(name, location, serialNum, companyUser);
		calculateDates();
	}
	
	public void calculateDates () {
		//just illustrative for now
		Date tmp = new Date();
		tmp.setTime(getLastAudition().getTime() + (86400000*365*2));
		setNextAudition(tmp);
		tmp.setTime(getLastInspection().getTime() + (86400000*365*2));
		setNextInspection(tmp);
		
		Date today = new Date();
		if (super.getNextAudition().before(today)) {
			Notification warning = new WarningNotification(super.getName() + " out of date!");
			notifyUser(warning);
		}
		
		if (super.getNextInspection().before(today)) {
			Notification warning = new WarningNotification(super.getName() + " out of date!");
			notifyUser(warning);
		}
	}
}
