package model.notification;

import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Notification implements Serializable {
	private String text;
	private String generatorName;
	private String generatorType;
	private LocalDate nextReminder;
	
	public String getText () {
		return text;
	}
	
	public void setText (String text) {
		this.text = text;
	}
	
	public abstract void dismiss(User user);
	
	public String getGeneratorName () {
		return generatorName;
	}
	
	public void setGeneratorName (String generatorName) {
		this.generatorName = generatorName;
	}
	
	public String getGeneratorType () {
		return generatorType;
	}
	
	public void setGeneratorType (String generatorType) {
		this.generatorType = generatorType;
	}
	
	public LocalDate getNextReminder () {
		return nextReminder;
	}
	
	public void setNextReminder (LocalDate nextReminder) {
		this.nextReminder = nextReminder;
	}
}
