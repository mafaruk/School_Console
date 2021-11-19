package mak.school.org.entities;

public class TeachingStaff extends Staff {
	 String SubjectID;

	public TeachingStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeachingStaff(String tName, int tID) {
		super(tName, tID);
		// TODO Auto-generated constructor stub
	}

	public TeachingStaff(String subjectID) {
		super();
		SubjectID = subjectID;
	}

	public String getSubjectID() {
		return SubjectID;
	}

	public void setSubjectID(String subjectID) {
		SubjectID = subjectID;
	}
}
