package model.user.userTypes;

import javafx.event.Event;
import model.DataStorage;
import model.Device;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyUser extends User implements Serializable, IUser {
	private String ICO;
	private String phone;
	private ArrayList<Device> deviceList = new ArrayList<>();
	
	public CompanyUser () {
	}
	
	//Sign up method
	@Override
	@SuppressWarnings("unchecked")
	public User signUpUser(Event actionEvent,
	                       String companyName,
	                       String companyICO,
	                       String email,
	                       String phone,
	                       String password) throws Exception{
		ArrayList<CompanyUser> companyUserList = new ArrayList<>();
		if (DataStorage.getInstance().getCompanyUserList() != null) {
			companyUserList = (ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList();
		}
		CompanyUser company = new CompanyUser(
				companyName,
				companyICO,
				email,
				phone,
				password);
		try {
			companyUserList.add(company);
			DataStorage.getInstance().setCompanyUserList(companyUserList);
			return company;
		} catch (NullPointerException npe) {
			System.out.println("Empty List!");
			return null;
		}
	}
	
	//Login method
	@Override
	public User loginUser(Event actionEvent, String loginMail, String loginPassword) throws Exception {
		return super.isAuthenticated(DataStorage.getInstance().getCompanyUserList(), loginMail, loginPassword);
	}
	
	public ArrayList<Device> getDeviceList () {
		System.out.println(super.getName() + "'s device list:");
		for (Device temp:
		    deviceList ) {
			System.out.println(temp.getName());
		}
		return deviceList;
	}
	
	public void addDevice(String name, String location, String serialNum) {
		Device newDevice = new Device(name, location, serialNum);
		deviceList.add(newDevice);
		DataStorage.getInstance().serializeCurrentCompany();
		System.out.println("Device " + newDevice.getName() + " added!");
	}
	
	public void removeDevice(Device device) {
		System.out.println("Device " + device.getName() + " removed!");
		deviceList.remove(device);
		DataStorage.getInstance().serializeCurrentCompany();
	}
	
	public String getName () {
		return super.getName();
	}
	
	public void setName (String name) {
		super.setName(name);
	}
		
	public String getICO () {
		return ICO;
	}
		
	public void setICO (String ICO) {
		this.ICO = ICO;
	}
	
	public String getMail () {
		return super.getMail();
	}
		
	public void setMail (String mail) {
		super.setMail(mail);
	}
		
	public String getPhone () {
		return phone;
	}
		
	public void setPhone (String phone) {
		this.phone = phone;
	}
	
	public String getPassword () {
		return super.getPassword();
	}
	
	public void setPassword (String password) {
		super.setPassword(password);
	}
	
	public CompanyUser (String name, String ICO, String mail, String phone, String password) {
		super.setName(name);
		this.ICO = ICO;
		super.setMail(mail);
		this.phone = phone;
		super.setPassword(password);
	}
}
