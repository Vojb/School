package model;

import java.util.ArrayList;

public class Student {
	

	private String sName;
	private String sPnr;
	private String Address;
	ArrayList<Studied> studiedList;
	
	public ArrayList<Studied> getStudiedList() {
		return studiedList;
	}
	public void setStudiedList(ArrayList<Studied> studiedList) {
		this.studiedList = studiedList;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPnr() {
		return sPnr;
	}
	public void setsPnr(String sPnr) {
		this.sPnr = sPnr;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}
