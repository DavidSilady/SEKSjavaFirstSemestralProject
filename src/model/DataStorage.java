package model;
import model.user.Listable;

import java.io.*;
import java.util.ArrayList;


public class DataStorage implements java.io.Serializable{
	private static DataStorage thisInstance = new DataStorage();
	private ArrayList<? extends Listable> companyUserList = new ArrayList<>();
	private ArrayList<? extends Listable> inspectionUserList = new ArrayList<>();
	private ArrayList<? extends Listable> auditorUserList = new ArrayList<>();
	
	private DataStorage(){
	}
	
	public static DataStorage getInstance () {
		return thisInstance;
	}
	
	public ArrayList<? extends Listable> getCompanyUserList () {
		return companyUserList;
	}
	
	public void setCompanyUserList (ArrayList<? extends Listable> companyUserList) {
		thisInstance.companyUserList = companyUserList;
		thisInstance.save(companyUserList, "companyUserData");
	}
	
	public ArrayList<? extends Listable> getInspectionUserList () {
		return inspectionUserList;
	}
	
	public void setInspectionUserList (ArrayList<? extends Listable> inspectionUserList) {
		thisInstance.inspectionUserList = inspectionUserList;
		thisInstance.save(companyUserList, "companyUserData");
	}
	
	public ArrayList<? extends Listable> getAuditorUserList () {
		return auditorUserList;
	}
	
	public void setAuditorUserList (ArrayList<? extends Listable> auditorUserList) {
		thisInstance.auditorUserList = auditorUserList;
		thisInstance.save(auditorUserList, "auditorUserData");
	}
	
	public void init () {
		companyUserList = load("companyUserData");
		inspectionUserList = load("inspectionUserData");
		auditorUserList = load("auditorUserData");
	}
	
	private void save (ArrayList arrayList, String name) {
		try
		{
			FileOutputStream fos = new FileOutputStream(name + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arrayList);
			oos.close();
			fos.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<? extends Listable> load (String name) {
		try
		{
			FileInputStream fis = new FileInputStream(name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<? extends Listable> arrayList = (ArrayList<? extends Listable>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(arrayList);
			for (Listable temp : arrayList
			     ) {
				System.out.println(temp.getMail() + temp.getPassword());
			}
			return  arrayList;
		} catch (FileNotFoundException f) {
			System.out.println("File not found");
			//f.printStackTrace();
			return null;
		} catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		}catch(ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
	}
}
