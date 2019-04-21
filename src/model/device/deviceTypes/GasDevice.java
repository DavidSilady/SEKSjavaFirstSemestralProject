package model.device.deviceTypes;

import model.device.Device;
import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class GasDevice extends Device implements Serializable {
	public GasDevice (String name, String location, String serialNum, User user) {
		super(name, location, serialNum);
		calculateNextAudition();
		calculateNextInspection();
	}
	
	public void calculateNextAudition () {
		//just illustrative for now
		setNextAudition(LocalDate.now().plusWeeks(3));
		
	}
	
	public void calculateNextInspection () {
		setLastAudition(LocalDate.now().plusMonths(3));
	}
}
