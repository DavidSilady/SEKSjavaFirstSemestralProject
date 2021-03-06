package model.user.userTypes;

import model.DataStorage;
import model.device.Device;
import model.device.deviceTypes.ElectronicDevice;
import model.device.deviceTypes.GasDevice;
import model.notification.notificationTypes.Request;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Commercial user - owns devices, which are audited and inspected.
 */
public class CompanyUser extends User implements Serializable, IUser {
	private String ICO;
	private String phone;
	private String inspectorID;
	private ArrayList<Device> deviceList = new ArrayList<>();
	
	/**
	 * Iterates through whole inspector list and returns the inspector with matching ID
	 * @return the found inspector.
	 */
	@SuppressWarnings("unchecked")
	public InspectionUser getInspectorUser() {
		for (InspectionUser tmp : (ArrayList<InspectionUser>) DataStorage.getInstance().getInspectionUserList()) {
			if (tmp.getIdentificationNumber().equals(this.inspectorID)) {
				return tmp;
			}
		}
		return null;
	}
	
	/**
	 * Adds the inspectorID of the inspectionUser (from param) to the current company
	 * @param inspectionUser - the concrete user to whose array list the current company is added
	 */
	public void assignInspector(InspectionUser inspectionUser) {
		if (this.inspectorID == null) {
			this.inspectorID = inspectionUser.getIdentificationNumber();
			return;
		}
		System.out.println("This company already has an inspector!");
	}
	
	/**
	 * Sends a notification to the inspectionUser, asking for assignment
	 * @param inspectionUser requested inspector
	 */
	public void requestInspectorAssignment(InspectionUser inspectionUser) {
		if (this.inspectorID == null) {
			inspectionUser.addNotification(new Request(this));
			return;
		}
		System.out.println("This company already has an inspector!");
	}
	
	public CompanyUser () {
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public User signUpUser(String name,
	                       String organizationID,
	                       String email,
	                       String phone,
	                       String password) {
		ArrayList<CompanyUser> companyUserList = new ArrayList<>();
		if (DataStorage.getInstance().getCompanyUserList() != null) {
			companyUserList = (ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList();
		}
		CompanyUser company = new CompanyUser(
				name,
				organizationID,
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
	
	@Override
	public User loginUser(String loginMail, String loginPassword){
		User user = super.isAuthenticated(DataStorage.getInstance().getCompanyUserList(), loginMail, loginPassword);
		updateNotifications();
		return user;
	}
	
	/**
	 * Empty - can't update devices as of now
	 * Might remove and move the method to separate interface in the future
	 */
	@Override
	public void updateDevice (Device device) {
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
	
	public void addElectronicDevice(String name, String location, String serialNum, int mod) {
		Device newDevice = new ElectronicDevice(name, location, serialNum, this, mod);
		deviceList.add(newDevice);
		DataStorage.getInstance().serializeAll();
		System.out.println("Device " + newDevice.getName() + " added!");
	}
	
	public void addGasDevice(String name, String location, String serialNum, int mod) {
		Device newDevice = new GasDevice(name, location, serialNum, this, mod);
		deviceList.add(newDevice);
		DataStorage.getInstance().serializeAll();
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
		DataStorage.getInstance().serializeAll();
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
	
	public void revokeAssignment () {
		getInspectorUser().getCompanyUsers().remove(this);
		this.inspectorID = null;
	}
}
