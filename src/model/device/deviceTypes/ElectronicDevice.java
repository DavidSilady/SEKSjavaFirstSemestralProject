package model.device.deviceTypes;

import model.device.Device;
import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import static java.lang.StrictMath.round;

public class ElectronicDevice extends Device implements Serializable {
	private double modifier = 1;
	private int voltage;
	private int defaultTimeDistance = 365;
	
	private void calculateModifier() {
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
		
		this.modifier =  this.modifier * classMod;
	}
	
	public ElectronicDevice (String name, String location, String serialNum, User user, int mod) {
		super(name, location, serialNum);
		this.voltage = mod;
		super.setDeviceClass(calculateDeviceClass());
		calculateNextAudition();
		calculateNextInspection();
	}
	
	private DeviceClass calculateDeviceClass() {
		if (voltage > 800)
			return DeviceClass.A;
		if (voltage > 450)
			return DeviceClass.B;
		if (voltage > 300)
			return DeviceClass.C;
		if (voltage > 150)
			return DeviceClass.D;
		if (voltage > 100)
			return DeviceClass.E;
		else
			return DeviceClass.F;
	}
	
	public void calculateNextAudition () {
		//just illustrative for now
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
