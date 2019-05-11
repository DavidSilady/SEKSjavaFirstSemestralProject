package model.device.deviceTypes;

import model.device.Device;
import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;

import static java.lang.StrictMath.round;

public class GasDevice extends Device implements Serializable {
	private int volume;
	private double modifier = 1;
	
	private DeviceClassification calculateDeviceClass() {
		if (volume > 8000)
			return DeviceClassification.A;
		if (volume > 5000)
			return DeviceClassification.B;
		if (volume > 1250)
			return DeviceClassification.C;
		if (volume > 500)
			return DeviceClassification.D;
		if (volume > 50)
			return DeviceClassification.E;
		else
			return DeviceClassification.F;
	}
	
	public GasDevice (String name, String location, String serialNum, User user, int mod) {
		super(name, location, serialNum);
		this.volume = mod;
		super.setDeviceClassification(calculateDeviceClass());
		setLastAudition(LocalDate.now().minusYears(1));
		setNextAudition(LocalDate.now().minusYears(1));
		setLastInspection(LocalDate.now().minusYears(1));
		setNextInspection(LocalDate.now().minusYears(1));
	}
	
	/**
	 * Modifiers change based on previous modifiers and device class
	 */
	private void calculateModifier() {
		double newMod = this.modifier * 0.95;
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
		
		this.modifier = newMod * classMod;
	}
	
	/**
	 * Uses the devices modifier to calculate when the next audition will be needed
	 */
	public void calculateNextAudition () {
		calculateModifier();
		setLastAudition(LocalDate.now());
		int defaultTimeDistanceAudition = 100;
		setNextAudition(LocalDate.now().plusDays(round(defaultTimeDistanceAudition *modifier)));
	}
	
	/**
	 * Uses the devices modifier to calculate when the next inspection will be needed
	 */
	public void calculateNextInspection () {
		calculateModifier();
		setLastInspection(LocalDate.now());
		int defaultTimeDistanceInspection = 50;
		setNextInspection(LocalDate.now().plusDays(round(defaultTimeDistanceInspection *modifier)));
	}
}
