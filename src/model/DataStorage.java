package model;
import model.user.IUser;

import java.io.*;
import java.util.ArrayList;


public class DataStorage implements Serializable{
	private static DataStorage thisInstance = new DataStorage();
	private ArrayList<? extends IUser> companyUserList = new ArrayList<>();
	private ArrayList<? extends IUser> inspectionUserList = new ArrayList<>();
	private ArrayList<? extends IUser> auditorUserList = new ArrayList<>();
	
	private DataStorage(){}
	
	public static DataStorage getInstance () {
		return thisInstance;
	}
	
	public ArrayList<? extends IUser> getCompanyUserList () {
		return companyUserList;
	}
	
	public void setCompanyUserList (ArrayList<? extends IUser> companyUserList) {
		thisInstance.companyUserList = companyUserList;
		thisInstance.serialize(companyUserList, "companyUserData");
	}
	
	public ArrayList<? extends IUser> getInspectionUserList () {
		return inspectionUserList;
	}
	
	public void setInspectionUserList (ArrayList<? extends IUser> inspectionUserList) {
		thisInstance.inspectionUserList = inspectionUserList;
		thisInstance.serialize(companyUserList, "companyUserData");
	}
	
	public ArrayList<? extends IUser> getAuditorUserList () {
		return auditorUserList;
	}
	
	public void setAuditorUserList (ArrayList<? extends IUser> auditorUserList) {
		thisInstance.auditorUserList = auditorUserList;
		thisInstance.serialize(auditorUserList, "auditorUserData");
	}
	
	public void init () {
		class Thread1 extends Thread {
			public void run() {
				companyUserList = deserializeUsers("companyUserData");
			}
		}
		class Thread2 extends Thread {
			public void run() {
				inspectionUserList = deserializeUsers("inspectionUserData");
			}
		}
		class Thread3 extends Thread {
			public void run() {
				auditorUserList = deserializeUsers("auditorUserData");
			}
		}
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread3 thread3 = new Thread3();
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	private void serialize (ArrayList arrayList, String fileName) {
		class SThread extends Thread{
			public void run(){
				try
				{
					FileOutputStream fos = new FileOutputStream(fileName + ".ser");
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
		}
		SThread sThread = new SThread();
		sThread.start();
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<? extends IUser> deserializeUsers (String fileName) {
		try
		{
			FileInputStream fis = new FileInputStream(fileName + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<? extends IUser> arrayList = (ArrayList<? extends IUser>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(arrayList);
			try {
				for (IUser temp : arrayList) {
					System.out.println(temp.getMail() + " " + temp.getPassword());
				}
			} catch (NullPointerException npe) {
				System.out.println("Empty user list!");
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
	
	public void serializeCurrentCompany () {
		serialize(companyUserList, "companyUserData");
	}
	
	public void serializeAll () {
		serialize(companyUserList, "companyUserData");
		serialize(auditorUserList, "auditorUserData");
		serialize(inspectionUserList, "inspectionUserData");
	}
}
