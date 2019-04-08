package model.device;

import model.notification.Notification;
import model.Observable;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable, Observable {
	private CompanyUser company;
	private String name;
	private String location;
	private String serialNum;
	
	private InspectionUser inspection;
	
	private String note;
	
	private Date lastInspection = null;
	private Date nextInspection = new Date();
	
	private Date lastAudition = null;
	private Date nextAudition = new Date();
	
	private Notification notification;
	/*
	public abstract void calculateDates();
	*/
	public Device (String name, String location, String serialNum, CompanyUser company) {
		this.name = name;
		this.location = location;
		this.serialNum = serialNum;
		this.company = company;
	}
	public Device (String name, String location, String serialNum) {
		this.name = name;
		this.location = location;
		this.serialNum = serialNum;
	}
	
	public void notifyUser(Notification notification) {
		company.update(notification);
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
