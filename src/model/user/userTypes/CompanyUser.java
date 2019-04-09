package model.user.userTypes;

import javafx.event.Event;
import model.DataStorage;
import model.device.Device;
import model.device.deviceTypes.ElectronicDevice;
import model.notification.Notification;
import model.user.IUser;
import model.Observer;
import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyUser extends User implements Serializable, IUser {
	private String ICO;
	private String phone;
	private InspectionUser inspectionUser = new InspectionUser();
	private String inspectionName = "Mr. Inspector"; //inspectionUser.getName();
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
		User user = super.isAuthenticated(DataStorage.getInstance().getCompanyUserList(), loginMail, loginPassword);
		checkDevices((CompanyUser) user);
		return user;
	}
	
	private void checkDevices(CompanyUser companyUser) {
		for (Device device:
		     companyUser.getDeviceList()) {
			device.calculateDates();
		}
	}
	
	public ArrayList<Device> getDeviceList () {
		return deviceList;
	}
	
	public void addDevice(String name, String location, String serialNum) {
		Device newDevice = new ElectronicDevice(name, location, serialNum, this);
		deviceList.add(newDevice);
		DataStorage.getInstance().serializeCurrentCompany();
		System.out.println("Device " + newDevice.getName() + " added!");
	}
	
	public void removeDevice(Device device) {
		try {
			System.out.println("Device " + device.getName() + " removed!");
		}
		catch (NullPointerException noe) {
			System.out.println("Device not found!");
		}
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
