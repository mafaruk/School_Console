package mak.school.org.entities;

public class Staff {
	private String tName;
	private int tID;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String tName, int tID) {
		super();
		this.tName = tName;
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
}
