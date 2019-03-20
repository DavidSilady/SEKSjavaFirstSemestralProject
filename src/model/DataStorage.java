package model;
import java.io.*;
import java.util.ArrayList;


public class DataStorage implements java.io.Serializable{
	private static ArrayList<? extends Listable> companyUserList = new ArrayList<>();
	private static ArrayList<? extends Listable> inspectionUserList = new ArrayList<>();
	private static ArrayList<? extends Listable> auditorUserList = new ArrayList<>();
	
	public static ArrayList<? extends Listable> getCompanyUserList () {
		return companyUserList;
	}
	
	public static void setCompanyUserList (ArrayList<? extends Listable> companyUserList) {
		DataStorage.companyUserList = companyUserList;
		DataStorage.save(companyUserList, "companyUserData");
	}
	
	public static ArrayList<? extends Listable> getInspectionUserList () {
		return inspectionUserList;
	}
	
	public static void setInspectionUserList (ArrayList<? extends Listable> inspectionUserList) {
		DataStorage.inspectionUserList = inspectionUserList;
		DataStorage.save(companyUserList, "companyUserData");
	}
	
	public static ArrayList<? extends Listable> getAuditorUserList () {
		return auditorUserList;
	}
	
	public static void setAuditorUserList (ArrayList<? extends Listable> auditorUserList) {
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
	private static ArrayList<? extends Listable> load (String name) {
		try
		{
			FileInputStream fis = new FileInputStream(name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<? extends Listable> arrayList = (ArrayList<? extends Listable>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(arrayList);
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
