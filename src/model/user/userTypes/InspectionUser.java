package model.user.userTypes;

import javafx.event.Event;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;

public class InspectionUser extends User implements Serializable, IUser {
	private String organizationName;
	private String identificationNumber;
	private String phone;
	
	public InspectionUser (String organizationName, String identificationNumber, String phone, String mail, String name, String password) {
		super.setMail(mail);
		super.setName(name);
		super.setPassword(password);
		this.organizationName = organizationName;
		this.identificationNumber = identificationNumber;
		this.phone = phone;
	}
	
	@Override
	public User loginUser (Event actionEvent, String loginMail, String loginPassword) throws Exception {
		
		return null;
	}
	
	@Override
	public User signUpUser (Event actionEvent, String companyName, String companyICO, String email, String phone, String password) throws Exception {
		return null;
	}
	
	@Override
	public void updateNotifications () {
	
	}
	
	public String getOrganizationName () {
		return organizationName;
	}
	
	public void setOrganizationName (String organizationName) {
		this.organizationName = organizationName;
	}
	
	public String getIdentificationNumber () {
		return identificationNumber;
	}
	
	public void setIdentificationNumber (String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	
	public String getPhone () {
		return phone;
	}
	
	public void setPhone (String phone) {
		this.phone = phone;
	}
}
