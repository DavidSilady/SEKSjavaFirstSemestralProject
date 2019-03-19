package model;
import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;


public class DataStorage implements java.io.Serializable{
	private static ArrayList<? extends User> companyUserList = new ArrayList<>();
	private static ArrayList<? extends User> inspectionUserList = new ArrayList<>();
	private static ArrayList<? extends User> auditorUserList = new ArrayList<>();
	
	public static ArrayList<? extends User> getCompanyUserList () {
		return companyUserList;
	}
	
	public static void setCompanyUserList (ArrayList<? extends User> companyUserList) {
		DataStorage.companyUserList = companyUserList;
		DataStorage.save(companyUserList, "companyUserData");
	}
	
	public static ArrayList<? extends User> getInspectionUserList () {
		return inspectionUserList;
	}
	
	public static void setInspectionUserList (ArrayList<? extends User> inspectionUserList) {
		DataStorage.inspectionUserList = inspectionUserList;
		DataStorage.save(companyUserList, "companyUserData");
	}
	
	public static ArrayList<? extends User> getAuditorUserList () {
		return auditorUserList;
	}
	
	public static void setAuditorUserList (ArrayList<? extends User> auditorUserList) {
		DataStorage.auditorUserList = auditorUserList;
		DataStorage.save(auditorUserList, "auditorUserData");
	}
	
	
	
	public static void init () {
		companyUserList = load("companyUserData");
		inspectionUserList = load("inspectionUserData");
		auditorUserList = load("auditorUserData");
	}
	
	private static void save (ArrayList arrayList, String name) {
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
	private static ArrayList<? extends User> load (String name) {
		try
		{
			FileInputStream fis = new FileInputStream(name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<? extends User> arrayList = (ArrayList<? extends User>) ois.readObject();
			ois.close();
			fis.close();
			return arrayList;
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
			//fnfe.printStackTrace();
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
