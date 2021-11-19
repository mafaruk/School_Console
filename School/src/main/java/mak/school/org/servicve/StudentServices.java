package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.StudentImpl;
import mak.school.org.entities.Student;

@Component
public class StudentServices{
	
	@Autowired
	private StudentImpl studentImpl;
	
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Student getStudent(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int updateStudent(Student student, int sID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
