package model.device.deviceTypes;

import model.device.Device;
import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import static java.lang.StrictMath.round;

public class GasDevice extends Device implements Serializable {
	private int volume;
	private double modifier = 1;
	private int defaultTimeDistance = 100;
	
	private DeviceClass calculateDeviceClass() {
		if (volume > 8000)
			return DeviceClass.A;
		if (volume > 5000)
			return DeviceClass.B;
		if (volume > 1250)
			return DeviceClass.C;
		if (volume > 500)
			return DeviceClass.D;
		if (volume > 50)
			return DeviceClass.E;
		else
			return DeviceClass.F;
	}
	
	
	public GasDevice (String name, String location, String serialNum, User user, int mod) {
		super(name, location, serialNum);
		this.volume = mod;
		super.setDeviceClass(calculateDeviceClass());
		calculateNextAudition();
		calculateNextInspection();
	}
	
	private void calculateModifier() {
		double newMod = this.modifier * 0.95;
		double classMod;
		if (getDeviceClass().equals(DeviceClass.A))
			classMod = 0.3;
		else if (getDeviceClass().equals(DeviceClass.B))
			classMod = 0.5;
		else if (getDeviceClass().equals(DeviceClass.C))
			classMod = 0.7;
		else if (getDeviceClass().equals(DeviceClass.D))
			classMod = 0.85;
		else if (getDeviceClass().equals(DeviceClass.E))
			classMod = 0.95;
		else classMod = 1;
		
		this.modifier = newMod * classMod;
	}
	
	public void calculateNextAudition () {
		calculateModifier();
		setLastAudition(LocalDate.now());
		setNextAudition(LocalDate.now().plusDays(round(defaultTimeDistance*modifier)));
	}
	
	public void calculateNextInspection () {
		calculateModifier();
		setLastInspection(LocalDate.now());
		setNextInspection(LocalDate.now().plusDays(round(defaultTimeDistance*modifier)));
	}
}
