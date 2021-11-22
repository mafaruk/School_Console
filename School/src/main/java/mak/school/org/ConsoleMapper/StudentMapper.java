package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.App;
import mak.school.org.entities.Student;
import mak.school.org.servicve.StudentServices;

@Component
public class StudentMapper {

	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	ClassroomMapper classroomMapper;
	
	@Autowired
	SubjectMapper subjectMapper;
	
	@Autowired
	BufferedReader reader;
	
	
	public StudentMapper() {
		super();
		
	}
	
	public void displayStudent(int i) throws IOException {
		Student student  = studentServices.getStudent(i);
		System.out.println("Name :- " + student.getStName());
		System.out.println("Roll NO :- " + student.getRollNo());
		int cid = student.getClassID(); 
		classroomMapper.displayTeacherFromClassroom(cid);
		System.out.println("Do you want to know your subjects? Y/N");
		String choice = reader.readLine();
		if(choice.equalsIgnoreCase("Y")) {
			subjectMapper.displaySubjectsFromClassroom(cid);
		}
		else {
			App.main(null);
		}
		
	}
	
}
