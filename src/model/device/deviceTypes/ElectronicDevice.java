package model.device.deviceTypes;

import model.device.Device;

public class ElectronicDevice extends Device {
	
	public ElectronicDevice (String name, String location, String serialNum) {
		super(name, location, serialNum);
	}
	
	private void calculateDates() {
		//just illustrative for now
		super.getNextAudition().setYear(super.getLastAudition().getYear() + 2);
	}
}
