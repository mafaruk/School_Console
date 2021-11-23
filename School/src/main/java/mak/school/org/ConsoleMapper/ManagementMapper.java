package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.App;
import mak.school.org.entities.Mangement;
import mak.school.org.servicve.ManagmentServices;

@Component
public class ManagementMapper {

	@Autowired
	SubjectMapper subjectMapper;
	
	@Autowired
	ManagmentServices managmentServices;

	Mangement mangement;

	@Autowired
	ClassroomMapper classroomMapper;
	
	@Autowired
	StaffMapper staffMapper;

	@Autowired
	StudentMapper studentMapper;

	@Autowired
	BufferedReader reader;

	public ManagementMapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int sessionID;

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public void displayManagement(int i) throws NumberFormatException, IOException {
		mangement = managmentServices.getMangement(i);
		setSessionID(mangement.getMngtID());
		int tid = mangement.gettID();
		System.out.print("Name :-");
		staffMapper.dispalyTeacherName(tid);
		System.out.println("Designation :- " + mangement.getDesignation());
		displayManagerialOperationConsoles();
	}

	private void displayManagerialOperationConsoles() throws NumberFormatException, IOException {
		String ch;
		if (mangement.getDesignation().equalsIgnoreCase("Admissions Recruiter")
				|| mangement.getDesignation().equalsIgnoreCase("Assistant Principal")
				|| mangement.getDesignation().equalsIgnoreCase("Principal")
				|| mangement.getDesignation().equalsIgnoreCase("Vice Principal")) {
			System.out.println(
					"Which information do you want? \n1.Student \n2.Teaching Staff \n3.Non Taeching Staff \n4.Classroms \n5.Subject \nPress N to go back to Main Console");
			ch = reader.readLine();
			switch (ch) {
			case "1":
				studentMapper.displayStudentOptions(this);
				break;
			case "2":
				staffMapper.displaySudentOption(this,true);
				break;
			case "3":
				staffMapper.displaySudentOption(this, false);
				break;
			case "4":
				classroomMapper.displayClassroomOptions(this);
				break;
			case "5":
				subjectMapper.displaySubjectsOption(this);
				break;
			case "N":
				App.main(null);
				break;

			default:
				System.err.println("invalid choice");
				displayManagerialOperationConsoles();
				break;
			}
		} else if (mangement.getDesignation().equalsIgnoreCase("Academic Director")
				|| mangement.getDesignation().equalsIgnoreCase("Assessment and Curriculum Programs Coordinator")
				|| mangement.getDesignation().equalsIgnoreCase("Assistant Superintendent of Curriculum and Instruction")
				|| mangement.getDesignation().equalsIgnoreCase("Supervisor of STEM Programs")) {
			System.out.println(
					"Which information do you want?  \n1.Teaching Staff \n2.Classroms \n3.Subject \nPress N to go back to Main Console");
			ch = reader.readLine();
			switch (ch) {
			case "1":
				staffMapper.displaySudentOption(this,true);
				break;
			case "2":
				classroomMapper.displayClassroomOptions(this);
				break;
			case "3":
				subjectMapper.displaySubjectsOption(this);
				break;
			case "N":
				App.main(null);
				break;

			default:
				System.err.println("invalid choice");
				displayManagerialOperationConsoles();
				break;
			}
		} else if (mangement.getDesignation().equalsIgnoreCase("Resource Coordinator")
				|| mangement.getDesignation().equalsIgnoreCase("Human Resources Director")
				|| mangement.getDesignation().equalsIgnoreCase("Human Resources Assistant")) {
			System.out.println(
					"Which information do you want?\n1.Teaching Staff \n2.Non Taeching Staff \n3.Management Staff \nPress N to go back to Main Console");
			ch = reader.readLine();
			switch (ch) {
			case "1":
				staffMapper.displaySudentOption(this,true);
				break;
			case "2":
				staffMapper.displaySudentOption(this,false);
				break;
			case "3":
				displayManagementOptions(this);
				break;
			case "N":

				break;

			default:
				System.err.println("invalid choice");
				displayManagerialOperationConsoles();
				break;
			}
		}

	}

	private void displayManagementOptions(ManagementMapper managementMapper) {
		System.out.println("in "+this.toString());
		
	}

}
