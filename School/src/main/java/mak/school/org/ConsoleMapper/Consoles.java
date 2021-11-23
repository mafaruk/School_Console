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

	public void getStudentConsole() {
		try {
			System.out.println("Enter Your Student ID:- ");
			int i = Integer.parseInt(reader.readLine());
			studentMapper.displayStudent(i);
		} catch (NumberFormatException | IOException ex) {
			System.err.println("Invalid input");
			getStudentConsole();
		} finally {
			App.main(null);
		}

	}

	public void getStaffConsole() {
		try {
			System.out.println("Enter Your Teacher ID:- ");
			int i = Integer.parseInt(reader.readLine());
			System.out.println("Are You Teaching Staff ? Y/N");
			String choice = reader.readLine();
			if (choice.equalsIgnoreCase("Y")) {

				staffMapper.dispalyTeacher(i, true);
			} else if (choice.equalsIgnoreCase("N")) {

				staffMapper.dispalyTeacher(i, false);
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException | IOException ex) {
			System.err.println("Invalid input");
			getStaffConsole();
		} finally {
			App.main(null);
		}

	}

	public void getManagementStaffConsole() {
		try {
			System.out.println("Enter You Management ID:- ");
			int i = Integer.parseInt(reader.readLine());
			managementMapper.displayManagement(i);
		} catch (NumberFormatException | IOException ex) {
			System.err.println("Invalid input");
			getManagementStaffConsole();
		} finally {
			App.main(null);
		}
	}

}
