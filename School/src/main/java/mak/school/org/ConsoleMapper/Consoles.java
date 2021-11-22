package mak.school.org.ConsoleMapper;


import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.App;

@Component
public class Consoles {

	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	SubjectMapper subjectMapper;
	
	@Autowired
	StaffMapper staffMapper;
	
	@Autowired
	ManagementMapper managementMapper;
	
	@Autowired
	ClassroomMapper classroomMapper;
	
	@Autowired
	BufferedReader reader;
	
	public Consoles() {
		super();
		
	}

	public void getStudentConsole() throws NumberFormatException, IOException {
		System.out.println("Enter You Student ID:- ");
		int i = Integer.parseInt(reader.readLine());
		studentMapper.displayStudent(i);
		App.main(null);
	}

	public void getStaffConsole() throws NumberFormatException, IOException {
		System.out.println("Enter You Teacher ID:- ");
		int i = Integer.parseInt(reader.readLine());
		System.out.println("Are You Teaching Staff ? Y/N");
		String choice = reader.readLine();
		if(choice.equalsIgnoreCase("Y")) {
			
			staffMapper.dispalyTeacher(i, true);
		}
		else{
			
			staffMapper.dispalyTeacher(i, false);
		}
		App.main(null);
		
	}

	public void getManagementStaffConsole() throws NumberFormatException, IOException {
		System.out.println("Enter You Management ID:- ");
		int i = Integer.parseInt(reader.readLine());
		managementMapper.displayManagement(i);
		App.main(null);
	}

}
