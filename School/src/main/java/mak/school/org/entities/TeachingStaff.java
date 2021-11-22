package mak.school.org.entities;

public class TeachingStaff implements Staff {
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

	public TeachingStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeachingStaff(int subjectID, String tName, int tID) {
		super();
		this.tName = tName;
		this.tID = tID;
	}

}
