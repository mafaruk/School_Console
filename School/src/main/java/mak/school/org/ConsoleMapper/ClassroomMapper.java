package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Classroom;

import mak.school.org.servicve.ClassroomServices;

@Component
public class ClassroomMapper {

	@Autowired
	ClassroomServices classroomServices;

	@Autowired
	StaffMapper staffMapper;

	Classroom classroom;

	@Autowired
	ManagementMapper managementMapper;
	
	@Autowired
	BufferedReader reader;

	public ClassroomMapper() {
		super();
		classroom = new Classroom();
		// TODO Auto-generated constructor stub
	}

	public void displayClassroom(int classID) {
		classroom = classroomServices.getClass(classID);
		System.out.println("Classroom:- "+classroom.getClassroom());
	}

	public void displayTeacherFromClassroom(int classID) {
		classroom = classroomServices.getClass(classID);
		System.out.println("Classroom :- " + classroom.getClassroom());
		int tid = classroom.getTeacherID();
		System.out.print("Class Teacher :- ");
		staffMapper.dispalyTeacherName(tid,true);

	}

	public void displayClassrromFromTeacher(int tid) {
		classroom = classroomServices.getClassroomFromTeacher(tid);
		System.out.println("Classroom :- " + classroom.getClassroom());
	}

	public void displayAllClassrooms() {
		List<Classroom> classroomlist = classroomServices.getAllClasses();
		for (Classroom classroom : classroomlist) {
			System.out.println("\nClassroom :- " + classroom.getClassroom());
			int tid = classroom.getTeacherID();
			System.out.print("Class Teacher :- ");
			staffMapper.dispalyTeacherName(tid,true);
			
		}
	}

	public String getClassroomName(int classID) {
		classroom = classroomServices.getClass(classID);
		return classroom.getClassroom();

	}

	public void displayClassroomOptions(Object object) {
		if (object instanceof ManagementMapper) {
			managementMapper = (ManagementMapper) object;
			System.out.println(
					"\n1.Add New Classroom Information \n2.Update Classroom Information \n3.Search Classroom Information \n4.Show All Classrooms' Information \nPress N to go back to Managerial Console");
			String sch = null;
			try {
				sch = reader.readLine();
			} catch (Exception e) {
				System.err.println("Invalid input");
				displayClassroomOptions(managementMapper);
			}

			switch (sch) {
			case "1":
				insertClassroom();
				break;
			case "2":
				updatedClassroom();
				break;
			case "3":
				searchClassroom();
				break;
			case "4":
				showAllClassroom();
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
				displayClassroomOptions(managementMapper);
				break;
			}

		}
	}

	private void insertClassroom() {
		
		try {
			int id = classroomServices.getNewStafftID();
			System.out.println("New Classroom ID is " + id
					+ ",");
			classroom.setClassID(id);

			System.out.println("Enter Classroom");
			String Name;
			Name = reader.readLine();
			classroom.setClassroom(Name);
			
			System.out.println("Choose Teacher,");
			staffMapper.displayAllStaff(true);
			System.out.println("Enter Teacher ID not the Teacher's Name");
			int teacher = Integer.parseInt(reader.readLine());
			classroom.setTeacherID(teacher);
			classroomServices.insertClass(classroom);
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			insertClassroom();
		}
		finally {
			displayClassroomOptions(managementMapper);
		}
	}

	private void updatedClassroom() {
		try {
			System.out.println("Enter Classroom ID:- ");
			int i = Integer.parseInt(reader.readLine());
			classroom = classroomServices.getClass(i);
			
			System.out.println("Classroom :- " + classroom.getClassroom());
			int tid = classroom.getTeacherID();
			System.out.print("Class Teacher :- ");
			staffMapper.dispalyTeacherName(tid,true);
			
			System.out.println("Enter Updated Classroom");
			String Name;
			Name = reader.readLine();
			classroom.setClassroom(Name);
			
			System.out.println("Choose Updated Teacher,");
			staffMapper.displayAllStaff(true);
			System.out.println("Enter Teacher ID not the Teacher's Name");
			int teacher = Integer.parseInt(reader.readLine());
			classroom.setTeacherID(teacher);
			classroomServices.updateClass(classroom, i);
		}catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			updatedClassroom();
		}
		finally {
			displayClassroomOptions(managementMapper);
		}		
		
	}

	private void searchClassroom() {
		try {
			System.out.println("Enter Classroom ID:- ");
			int i = Integer.parseInt(reader.readLine());
			displayTeacherFromClassroom(i);
		}catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			searchClassroom();
		}
		finally {
			displayClassroomOptions(managementMapper);
		}	
		
	}

	private void showAllClassroom() {
		try {
			displayAllClassrooms();
		}catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			showAllClassroom();
		}
		finally {
			displayClassroomOptions(managementMapper);
		}
		
	}

}
