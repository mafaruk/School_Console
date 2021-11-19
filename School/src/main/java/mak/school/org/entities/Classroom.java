package mak.school.org.entities;

public class Classroom {

	private int classID;
	private String classroom; 
	private int teacherID;
	
	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classroom(int classID, String classroom, int teacherID) {
		super();
		this.classID = classID;
		this.classroom = classroom;
		this.teacherID = teacherID;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	
}
