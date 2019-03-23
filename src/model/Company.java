package model;

public class Company extends User implements java.io.Serializable, Listable{
	//private String name;
	private String ICO;
	
	
	//private String mail;
	private String phone;
	//private String password;
	private Device device;
	
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
