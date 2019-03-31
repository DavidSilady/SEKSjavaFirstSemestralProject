package model.userTypes;

import controller.SceneController;
import javafx.event.Event;
import model.DataStorage;
import model.Device;
import model.Listable;
import model.User;

import java.util.ArrayList;

public class Company extends User implements java.io.Serializable, Listable {
	private String ICO;
	private String phone;
	private ArrayList<Device> deviceList;
	
	public Company() {
	}
	
	public void loginUser(Event actionEvent, String loginMail, String loginPassword) throws Exception {
		SceneController sceneController = new SceneController();
		if (super.isAuthenticated(DataStorage.getInstance().getCompanyUserList(), loginMail, loginPassword)) {
			sceneController.switchStage(actionEvent, "userInterface");
		}
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
	
	public Company (String name, String ICO, String mail, String phone, String password) {
		super.setName(name);
		this.ICO = ICO;
		super.setMail(mail);
		this.phone = phone;
		super.setPassword(password);
	}
}
