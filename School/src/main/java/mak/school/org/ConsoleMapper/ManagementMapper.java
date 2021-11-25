package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;

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
		mangement = new Mangement();
		// TODO Auto-generated constructor stub
	}

	private int sessionID;

	public int getSessionID() {
		return sessionID;
		
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public Mangement displayManagement(int i) throws NumberFormatException, IOException {
		mangement = managmentServices.getMangement(i);
		int tid = 0;
		boolean isTeaching = false;
		if((mangement.gettID()==0) && !(mangement.getDesignation().equalsIgnoreCase("Not assigned"))) {
			tid = mangement.getnTID();
			isTeaching = false;
		}
		else if((mangement.getnTID()==0) && !(mangement.getDesignation().equalsIgnoreCase("Not assigned"))){
			tid = mangement.gettID();
			isTeaching = true;
		}
		
		System.out.print("Name :-");
		staffMapper.dispalyTeacherName(tid, isTeaching);
		System.out.println("Designation :- " + mangement.getDesignation());
		return mangement;
	}

	public void displayManagerialOperationConsoles() throws NumberFormatException, IOException {
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
				staffMapper.displayStaffOption(this,true);
				break;
			case "3":
				staffMapper.displayStaffOption(this, false);
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
				staffMapper.displayStaffOption(this,true);
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
				staffMapper.displayStaffOption(this,true);
				break;
			case "2":
				staffMapper.displayStaffOption(this,false);
				break;
			case "3":
				displayManagementOptions(this);
				break;
			case "N":
				App.main(null);
				break;

			default:
				System.err.println("invalid choice");
				displayManagerialOperationConsoles();
				break;
			}
		}

	}

	private void displayManagementOptions(ManagementMapper managementMapper) {
		
			System.out.println(
					"\n1.Add New Management's Information \n2.Update Management's  Information \n3.Delete Management's  Information \n4.Search Management's  Information \n5.Show All Managements' Information \nPress N to go back to Managerial Console ");
			String sch = null;
			try {
				sch = reader.readLine();
			} catch (Exception e) {
				System.err.println("Invalid input");
				displayManagementOptions(managementMapper);
			}

			switch (sch) {
			case "1":
				insertManagement();
				break;
			case "2":
				updatedManagement();
				break;
			case "3":
				deleteManagement();
				break;
			case "4":
				searchManagement();
				break;
			case "5":
				showAllManagement();
				break;
			case "N":
				try {
					managementMapper.displayManagerialOperationConsoles();
				} catch (NumberFormatException | IOException e) {
					System.err.println("Invalid Input" + e.getMessage());
				}
				break;
			default:
				System.err.println("invalid choice");
				displayManagementOptions(managementMapper);
				break;
			}

		}

	private void insertManagement() {
		try {

			int id = 0;
			id = managmentServices.getMgmtID();
			System.out.println("New Management ID is " + id
					+ ", Management ID is important, remember it & do not share it with anyone ");
			mangement.setMngtID(id);
			System.out.println("Will New Management Person be Teaching ? Y/N");
			String ch = reader.readLine();
			boolean isTeaching = false;
			int tid = 0;
			if (ch.equals("Y")) {
				isTeaching = true;
				staffMapper.displayAllStaff(isTeaching);

				System.out.println("Enter Teacher ID:- ");
				tid = Integer.parseInt(reader.readLine());
				mangement.settID(tid);

			} else if (ch.equals("N")) {
				isTeaching = false;
				staffMapper.displayAllStaff(isTeaching);
				System.out.println("Enter Teacher ID:- ");
				tid = Integer.parseInt(reader.readLine());
				mangement.setnTID(tid);
			} else {
				throw new IOException();

			}

			System.out.println("Enter Designation");
			String designation = reader.readLine();
			mangement.setDesignation(designation);
			managmentServices.insertManagement(mangement, isTeaching);

		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			insertManagement();
		} finally {
			displayManagementOptions(this);
		}
		
	}

	private void updatedManagement() {
		try {
			System.out.println("Enter Management ID:- ");
			int id = Integer.parseInt(reader.readLine());
			Mangement mangement2 = displayManagement(id);
			mangement.setMngtID(mangement2.getMngtID());
			System.out.println("Will updated Management Person be Teaching ? Y/N");
			String ch = reader.readLine();
			boolean isTeaching = false;
			int tid = 0;
			if (ch.equalsIgnoreCase("Y")) {
				isTeaching = true;
				staffMapper.displayAllStaff(isTeaching);

				System.out.println("Enter Teacher ID:- ");
				tid = Integer.parseInt(reader.readLine());
				mangement.settID(tid);

			} else if (ch.equalsIgnoreCase("N")) {
				isTeaching = false;
				staffMapper.displayAllStaff(isTeaching);
				System.out.println("Enter Teacher ID:- ");
				tid = Integer.parseInt(reader.readLine());
				mangement.setnTID(tid);
			} else {
				throw new IOException();

			}
			
			System.out.println("\nNote:-You Cannot change the Designation");
			managmentServices.updateMangment(mangement,id, isTeaching);
			
		} catch (NumberFormatException | IOException e) {  
			System.err.println("Invalid Input" + e.getMessage());
			updatedManagement();
		}
		finally {
			displayManagementOptions(this);
		}
		
	}

	private void deleteManagement() {
		try {
			System.out.println("Enter Management ID:- ");
			int id = Integer.parseInt(reader.readLine());
			displayManagement(id);
			System.out.println("Are You sure? you want to delete Management Info. Y/N");
			String ch = reader.readLine();
			if(ch.equalsIgnoreCase("Y")) {
				managmentServices.delete(id);
			}
			else if(ch.equalsIgnoreCase("N")) {
				displayManagementOptions(this);
			}
			else {
				System.out.println("Invalid Input, Considering This As NO");
				displayManagementOptions(this);
			}
			
		} catch ( Exception e) {  
			System.err.println("Invalid Input" + e.getMessage());
			deleteManagement();
		}
		finally {
			displayManagementOptions(this);
		}
		
	}

	private void searchManagement() {
		System.out.println("Enter Management ID:- ");
		int id = 0;
		try {
			
			id = Integer.parseInt(reader.readLine());
			displayManagement(id);
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			searchManagement();
		}
		finally {
			displayManagementOptions(this);
		}
		
	}
	
	public void displayAllManagement(){
		List<Mangement> managementList = managmentServices.getAllManagement();
		for (Mangement mangement : managementList) {
			int tid = 0;
			boolean isTeaching = false;
			if((mangement.gettID()==0) && !(mangement.getDesignation().equalsIgnoreCase("Not assigned"))) {
				tid = mangement.getnTID();
				isTeaching = false;
			}
			else if((mangement.getnTID()==0) && !(mangement.getDesignation().equalsIgnoreCase("Not assigned"))){
				tid = mangement.gettID();
				isTeaching = true;
			}
			
			System.out.print("Name :-");
			staffMapper.dispalyTeacherName(tid, isTeaching);
			System.out.println("Designation :- " + mangement.getDesignation());
		}
	}

	private void showAllManagement() {
		try{
			displayAllManagement();
		}
		finally {
			displayManagementOptions(this);
		}
		
	}

	public void displayManagementWithConsole(int i) {
		try {
		mangement = managmentServices.getMangement(i);
		int tid = 0;
		boolean isTeaching = false;
		if((mangement.gettID()==0) && !(mangement.getDesignation().equalsIgnoreCase("Not assigned"))) {
			tid = mangement.getnTID();
			isTeaching = false;
		}
		else if((mangement.getnTID()==0) && !(mangement.getDesignation().equalsIgnoreCase("Not assigned"))){
			tid = mangement.gettID();
			isTeaching = true;
		}
		
		System.out.print("Name :-");
		staffMapper.dispalyTeacherName(tid, isTeaching);
		System.out.println("Designation :- " + mangement.getDesignation());
		
			displayManagerialOperationConsoles();
		} catch (NumberFormatException | IOException e) {
			System.err.println("Invalid Input" + e.getMessage());
		}
		
	}
		
	

}
