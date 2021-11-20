package mak.school.org.entities;

public class TeachingStaff extends Staff {
	 private int SubjectID;

	public TeachingStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeachingStaff(String tName, int tID) {
		super(tName, tID);
		// TODO Auto-generated constructor stub
	}

	public TeachingStaff(int subjectID) {
		super();
		SubjectID = subjectID;
	}

	public int getSubjectID() {
		return SubjectID;
	}

	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}
}
