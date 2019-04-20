package model.notification;

import model.user.User;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Notification implements Serializable {
	private String text;
	private String aggregatorName;
	private String aggregatorType;
	private LocalDate nextReminder;
	
	public String getText () {
		return text;
	}
	
	public void setText (String text) {
		this.text = text;
	}
	
	public abstract void dismiss(User user);
	
	public String getAggregatorName () {
		return aggregatorName;
	}
	
	public void setAggregatorName (String aggregatorName) {
		this.aggregatorName = aggregatorName;
	}
	
	public String getAggregatorType () {
		return aggregatorType;
	}
	
	public void setAggregatorType (String aggregatorType) {
		this.aggregatorType = aggregatorType;
	}
	
	public LocalDate getNextReminder () {
		return nextReminder;
	}
	
	public void setNextReminder (LocalDate nextReminder) {
		this.nextReminder = nextReminder;
	}
}
