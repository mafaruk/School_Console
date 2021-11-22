package mak.school.org.entities;

public class NonTeaching implements Staff {
	private String designation;
	private String tName;
	private int tID;


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
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public NonTeaching(String designation) {
		super();
		this.designation = designation;
	}

	public NonTeaching() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NonTeaching(String designation, String tName, int tID) {
		super();
		this.designation = designation;
		this.tName = tName;
		this.tID = tID;
	}

	
	
}
