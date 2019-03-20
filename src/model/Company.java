package model;

public class Company implements java.io.Serializable, Listable {
	private String name;
	private String ICO;
	private String mail;
	private String phone;
	private String password;
	private Device device;
	
		public String getName () {
		return name;
	}
		
		public void setName (String name) {
		this.name = name;
	}
		
		public String getICO () {
		return ICO;
	}
		
		public void setICO (String ICO) {
		this.ICO = ICO;
	}
		
		public String getMail () {
		return mail;
	}
		
		public void setMail (String mail) {
		this.mail = mail;
	}
		
		public String getPhone () {
		return phone;
	}
		
		public void setPhone (String phone) {
		this.phone = phone;
	}
		
		public String getPassword () {
		return password;
	}
		
		public void setPassword (String password) {
		this.password = password;
	}
	
	public Company (String name, String ICO, String mail, String phone, String password) {
		this.name = name;
		this.ICO = ICO;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
	}
	
	
}
