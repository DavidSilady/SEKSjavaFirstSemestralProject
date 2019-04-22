package model.user.userTypes;

import model.DataStorage;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class InspectionUser extends User implements Serializable, IUser {
	private String organizationICO;
	private String identificationNumber;
	private String phone;
	
	private ArrayList<CompanyUser> companyUsers;
	
	public InspectionUser() {
	}
	
	public String generateIdentificationNumber () {
		return UUID.randomUUID().toString();
	}
	
	public InspectionUser (String organizationICO, String identificationNumber, String phone, String mail, String name, String password) {
		super.setMail(mail);
		super.setName(name);
		super.setPassword("password"); // temporary simplification
		this.organizationICO = organizationICO;
		this.identificationNumber = identificationNumber;
		this.phone = phone;
	}
	
	@Override
	public User loginUser (String loginMail, String loginPassword) {
		User user = super.isAuthenticated(DataStorage.getInstance().getInspectionUserList(), loginMail, loginPassword);
		updateNotifications();
		return user;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User signUpUser (String name, String organizationID, String email, String phone, String password){
		ArrayList<InspectionUser> inspectionUsers = new ArrayList<>();
		if (DataStorage.getInstance().getCompanyUserList() != null) {
			inspectionUsers = (ArrayList<InspectionUser>) DataStorage.getInstance().getInspectionUserList();
		}
		InspectionUser inspectionUser = new InspectionUser(
				organizationID,
				password,
				phone,
				email,
				name,
				password
		);
		
		try {
			inspectionUsers.add(inspectionUser);
			DataStorage.getInstance().setInspectionUserList(inspectionUsers);
			//sendSignUpMail();
			return inspectionUser;
		} catch (NullPointerException npe) {
			System.out.println("Empty List!");
			return null;
		}
		
	
	}
	
	private void sendSignUpMail() {
		/*
		* Sends a mail containing the generated password, which will be recommended
		* to change.
		 */
	}
	
	@Override
	public void updateNotifications () {
	
	}
	
	public String getOrganizationICO () {
		return organizationICO;
	}
	
	public void setOrganizationICO (String organizationICO) {
		this.organizationICO = organizationICO;
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
	
	public ArrayList<CompanyUser> getCompanyUsers () {
		return companyUsers;
	}
	
	public void setCompanyUsers (ArrayList<CompanyUser> companyUsers) {
		this.companyUsers = companyUsers;
	}
}
