package mak.school.org.entities;

public class Subjects {
	private String subName;
	private int subId;
	private int classID;
	private int tID;
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subjects(String subName, int subId, int classID, int tID) {
		super();
		this.subName = subName;
		this.subId = subId;
		this.classID = classID;
		this.tID = tID;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	} 
}
