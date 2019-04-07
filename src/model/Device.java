package model;

import model.user.userTypes.InspectionUser;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable {
	private enum type {
	};
	private String name;
	private String location;
	private String serialNum;
	
	private InspectionUser inspection;
	
	private String note;
	
	private int inspectionTimeLimit = 0;
	private Date lastInspection = new Date();
	private Date nextInspection = new Date();
	
	private int auditionTimeLimit = 0;
	private Date lastAudition = new Date();
	private Date nextAudition = new Date();
	
	public Device (String name, String location, String serialNum) {
		this.name = name;
		this.location = location;
		this.serialNum = serialNum;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getLocation () {
		return location;
	}
	
	public void setLocation (String location) {
		this.location = location;
	}
	
	public String getSerialNum () {
		return serialNum;
	}
	
	public void setSerialNum (String serialNum) {
		this.serialNum = serialNum;
	}
	
	public int getInspectionTimeLimit () {
		return inspectionTimeLimit;
	}
	
	public void setInspectionTimeLimit (int inspectionTimeLimit) {
		this.inspectionTimeLimit = inspectionTimeLimit;
	}
	
	public Date getLastInspection () {
		return lastInspection;
	}
	
	public void setLastInspection (Date lastInspection) {
		this.lastInspection = lastInspection;
	}
	
	public Date getNextInspection () {
		return nextInspection;
	}
	
	public void setNextInspection (Date nextInspection) {
		this.nextInspection = nextInspection;
	}
	
	public int getAuditionTimeLimit () {
		return auditionTimeLimit;
	}
	
	public void setAuditionTimeLimit (int auditionTimeLimit) {
		this.auditionTimeLimit = auditionTimeLimit;
	}
	
	public Date getLastAudition () {
		return lastAudition;
	}
	
	public void setLastAudition (Date lastAudition) {
		this.lastAudition = lastAudition;
	}
	
	public Date getNextAudition () {
		return nextAudition;
	}
	
	public void setNextAudition (Date nextAudition) {
		this.nextAudition = nextAudition;
	}
}
