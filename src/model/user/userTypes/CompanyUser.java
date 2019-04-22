package model.user.userTypes;

import model.DataStorage;
import model.device.Device;
import model.device.deviceTypes.ElectronicDevice;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyUser extends User implements Serializable, IUser {
	private String ICO;
	private String phone;
	private InspectionUser inspectorUser = new InspectionUser("Siko",
			"09487522001",
			"0918259255",
			"inspector@inspector.com",
			"Mr. Inspector",
			"password");
	private ArrayList<Device> deviceList = new ArrayList<>();
	
	public CompanyUser () {
	}
	
	//Sign up method
	@Override
	@SuppressWarnings("unchecked")
	public User signUpUser(String name,
	                       String companyICO,
	                       String email,
	                       String phone,
	                       String password) {
		ArrayList<CompanyUser> companyUserList = new ArrayList<>();
		if (DataStorage.getInstance().getCompanyUserList() != null) {
			companyUserList = (ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList();
		}
		CompanyUser company = new CompanyUser(
				name,
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
	public User loginUser(String loginMail, String loginPassword){
		User user = super.isAuthenticated(DataStorage.getInstance().getCompanyUserList(), loginMail, loginPassword);
		updateNotifications();
		return user;
	}
	
	public void updateNotifications () {
		for (Device device : getDeviceList()) {
			device.checkForNotifications(this);
		}
		super.printNotifications(this);
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
	
	public InspectionUser getInspectorUser () {
		return inspectorUser;
	}
	
	public void setInspectorUser (InspectionUser inspectorUser) {
		this.inspectorUser = inspectorUser;
	}
	
	public CompanyUser (String name, String ICO, String mail, String phone, String password) {
		super.setName(name);
		this.ICO = ICO;
		super.setMail(mail);
		this.phone = phone;
		super.setPassword(password);
	}
}
