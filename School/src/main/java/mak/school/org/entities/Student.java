package mak.school.org.entities;

public class Student {

	private String stName;
	private int stID;
	private int rollNo;
	private int classID;

	
	public Student(String stName, int stID, int rollNo, int classID) {
		super();
		this.stName = stName;
		this.stID = stID;
		this.rollNo = rollNo;
		this.classID = classID;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getStID() {
		return stID;
	}
	public void setStID(int stID) {
		this.stID = stID;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	} 

}
