package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.StudentImpl;
import mak.school.org.entities.Student;

@Component("Student")
public class StudentServices{
	
	@Autowired
	private StudentImpl studentImpl;
	
	public int insertStudent(Student student) {
		int i = studentImpl.insertStudent(student);
		return i;
	}

	
	public Student getStudent(int sid) {
		Student student = studentImpl.getStudent(sid); 
		return student;
	}

	
	public List<Student> getAllStudent() {
		List<Student> students = studentImpl.getAllStudent();
		return students;
	}

	public int updateStudent(Student student, int sID) {
		int i = studentImpl.updateStudent(student, sID);
		return i;
	}
	
	public int delete(int sID) {
		int r = studentImpl.delete(sID);
		return r;
	}

}
