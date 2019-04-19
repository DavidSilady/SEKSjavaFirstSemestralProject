package model.device.deviceTypes;

import model.device.Device;
import model.notification.Notification;
import model.notification.notificationTypes.WarningNotification;
import model.user.User;

import java.util.Date;

public class GasDevice extends Device {
	public GasDevice (String name, String location, String serialNum, User user) {
		super(name, location, serialNum);
		calculateNextAudition();
		calculateNextInspection();
	}
	
	public void calculateNextAudition () {
		//just illustrative for now
		Date tmp = new Date();
		tmp.setTime(getLastAudition().getTime() + (86400000*365));
		setNextAudition(tmp);
		
	}
	
	public void calculateNextInspection () {
		Date tmp = new Date();
		tmp.setTime(getLastInspection().getTime() + (86400000*365));
		setNextInspection(tmp);
	}
}
