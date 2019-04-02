package model.user.userTypes;

import controller.SceneController;
import controller.SignUpController;
import javafx.event.Event;
import model.DataStorage;
import model.Device;
import model.user.Listable;
import model.user.User;

import java.util.ArrayList;

public class CompanyUser extends User implements java.io.Serializable, Listable {
	private String ICO;
	private String phone;
	private ArrayList<Device> deviceList;
	
	public CompanyUser () {
	}
	
	//Sign up method
	@Override
	@SuppressWarnings("unchecked")
	public void signUpUser(Event actionEvent,
	                       String companyName,
	                       String companyICO,
	                       String email,
	                       String phone,
	                       String password) throws Exception{
		ArrayList<CompanyUser> companyUserList = new ArrayList<>();
		if (DataStorage.getInstance().getCompanyUserList() != null) {
			companyUserList = (ArrayList<CompanyUser>) DataStorage.getInstance().getCompanyUserList();
		}
		SignUpController signUpController = new SignUpController();
		CompanyUser company = new CompanyUser(
				companyName,
				companyICO,
				email,
				phone,
				password);
		try {
			companyUserList.add(company);
			DataStorage.getInstance().setCompanyUserList(companyUserList);
		} catch (NullPointerException npe) {
			System.out.println("Empty List!");
			return;
		}
		
		System.out.println("Signed up!");
		SceneController sceneController = new SceneController();
		sceneController.switchStage(actionEvent, "userInterface");
	}
	
	//Login method
	@Override
	public void loginUser(Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		if (super.isAuthenticated(DataStorage.getInstance().getCompanyUserList(), loginMail, loginPassword)) {
			sceneController.switchStage(actionEvent, "userInterface");
		}
	}
	
	public ArrayList<Device> getDeviceList () {
		return deviceList;
	}
	
	public void addDevice(String name, String location, String serialNum) {
		Device newDevice = new Device(name, location, serialNum);
		deviceList.add(newDevice);
	}
	
	public void removeDevice(Device device) {
		deviceList.remove(device);
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
