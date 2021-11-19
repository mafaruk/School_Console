package mak.school.org.entities;

public class NonTeaching extends Staff {
	private String designation;

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

	public NonTeaching(String tName, int tID) {
		super(tName, tID);
		// TODO Auto-generated constructor stub
	} 
	
}
