package model.device.deviceTypes;

import model.device.Device;
import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;

import static java.lang.StrictMath.round;

public class ElectronicDevice extends Device implements Serializable {
	private double modifier = 1;
	private int voltage;
	private int defaultTimeDistance = 365;
	
	/**
	 * Modifier changes depending on the classification of device
	 */
	private void calculateModifier() {
		double classMod;
		if (getDeviceClassification().equals(DeviceClassification.A))
			classMod = 0.3;
		else if (getDeviceClassification().equals(DeviceClassification.B))
			classMod = 0.5;
		else if (getDeviceClassification().equals(DeviceClassification.C))
			classMod = 0.7;
		else if (getDeviceClassification().equals(DeviceClassification.D))
			classMod = 0.85;
		else if (getDeviceClassification().equals(DeviceClassification.E))
			classMod = 0.95;
		else classMod = 1;
		
		this.modifier =  this.modifier * classMod;
	}
	
	public ElectronicDevice (String name, String location, String serialNum, User user, int mod) {
		super(name, location, serialNum);
		this.voltage = mod;
		super.setDeviceClassification(calculateDeviceClass());
		setLastAudition(LocalDate.now().minusYears(1));
		setNextAudition(LocalDate.now().minusYears(1));
		setLastInspection(LocalDate.now().minusYears(1));
		setNextInspection(LocalDate.now().minusYears(1));
	}
	
	private DeviceClassification calculateDeviceClass() {
		if (voltage > 800)
			return DeviceClassification.A;
		if (voltage > 450)
			return DeviceClassification.B;
		if (voltage > 300)
			return DeviceClassification.C;
		if (voltage > 150)
			return DeviceClassification.D;
		if (voltage > 100)
			return DeviceClassification.E;
		else
			return DeviceClassification.F;
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
