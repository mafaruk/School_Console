package mak.school.org.dao;

import java.util.List;

import mak.school.org.entities.Student;

public interface StudentDao {

	public int insertStudent(Student student);
	public Student getStudent(int sid);
	public List<Student> getAllStudent(); 
	public int updateStudent(Student student, int sID);
}
