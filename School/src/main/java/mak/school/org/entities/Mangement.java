package mak.school.org.entities;

public class Mangement {
	private int tID;
	private int ntID;
	public int getNtID() {
		return ntID;
	}
	public void setNtID(int ntID) {
		this.ntID = ntID;
	}
	private int mngtID;
	private String designation;
	public Mangement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mangement(int tID, int mngtID, String designation) {
		super();
		this.tID = tID;
		this.mngtID = mngtID;
		this.designation = designation;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public int getMngtID() {
		return mngtID;
	}
	public void setMngtID(int mngtID) {
		this.mngtID = mngtID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
