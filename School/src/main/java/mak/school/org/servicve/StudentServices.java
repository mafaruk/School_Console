package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mak.school.org.dao.StudentImpl;
import mak.school.org.entities.Student;

@Component
@Service
public class StudentServices{
	
	@Autowired
	private StudentImpl studentImpl;
	
	public StudentServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void displaStudentService() {
		System.out.println("in student service");
	}
	
	public StudentImpl getStudentImpl() {
		return studentImpl;
	}


	public void setStudentImpl(StudentImpl studentImpl) {
		this.studentImpl = studentImpl;
	}


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
