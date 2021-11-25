package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

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
	 
	Student studentinfo;
	
	@Autowired
	ManagementMapper managementMapper;

	public StudentMapper() {
		super();
		studentinfo = new Student();

	}

	public void displayStudent(int i)  {
		Student student = studentServices.getStudent(i);
		System.out.println("Name :- " + student.getStName());
		System.out.println("Roll NO :- " + student.getRollNo());
		try {
			int cid = student.getClassID();
			classroomMapper.displayTeacherFromClassroom(cid);
			System.out.println("Do you want to know subjects? Y/N");
			String choice = reader.readLine();
			if (choice.equalsIgnoreCase("Y")) {
				subjectMapper.displaySubjectsFromClassroom(cid);
			} else if(choice.equalsIgnoreCase("N")){
				App.main(null);
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e) {
			System.err.println("Invalid Input, Considering this As NO");
		}
		finally {
			App.main(null);
		}
		

	}

	public void displayStudentOptions(Object object) {

		if (object instanceof ManagementMapper) {
			managementMapper = (ManagementMapper) object;
			System.out.println(
					"\n1.Add New Student's Information \n2.Update Student's Information \n3.Delete Student's Information \n4.Search Student's Information \n5.Show All Students' Information \nPress N to go back to Managerial Console ");
			String sch = null;
			try {
				sch = reader.readLine();
			} catch (Exception e) {
				System.err.println("Invalid input");
				displayStudentOptions(managementMapper);
			}
			
			switch (sch.toUpperCase()) {
			case "1":
				insertStudent();
				break;
			case "2":
				updatedStudent();
				break;
			case "3":
				deleteStudent();
				break;
			case "4":
				searchStudent();
				break;
			case "5":
				showAllStudent();
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
				displayStudentOptions(managementMapper);
				break;
			}

		}
	}
	
	private void displayAllStudent() {
		List<Student> studentList = studentServices.getAllStudent();
		System.out.println("Roll No \t Student Name\t\t\t\t Classroom");
		for (Student student : studentList) {
			System.out.println(student.getRollNo()+"\t"+student.getStName()+ "\t\t"+classroomMapper.getClassroomName(student.getClassID()));
		}
	}

	private void showAllStudent() {
		displayAllStudent();
		displayStudentOptions(managementMapper);
	}

	private void searchStudent() {
		try {
			System.out.println("Enter Student ID:- ");
			int i = Integer.parseInt(reader.readLine());
			displayStudent(i);
			
		}
		catch(Exception ex){
			System.err.println("Invalid Input"+ex.getMessage());
			searchStudent();
		}
		finally {
			displayStudentOptions(managementMapper);
		}
		
	
		
	}

	private void deleteStudent() {
		try {
			System.out.println("Enter Student ID:- ");
			int i = Integer.parseInt(reader.readLine());
			Student student = studentServices.getStudent(i);
			System.out.println("Name :- " + student.getStName());
			System.out.println("Roll NO :- " + student.getRollNo());
			System.out.println("Are You sure? you want to delete student Info. Y/N");
			String ch = reader.readLine();
			if(ch.equalsIgnoreCase("Y")) {
				studentServices.delete(i);
			}
			else if(ch.equalsIgnoreCase("N")) {
				displayStudentOptions(managementMapper);
			}
			else {
				System.out.println("Invalid Input, Considering This As NO");
				displayStudentOptions(managementMapper);
			}
		} 
		catch(Exception ex){
			System.err.println("Invalid Input"+ex.getMessage());
			deleteStudent();
		}
		finally {
			displayStudentOptions(managementMapper);
		}
		
		
	}

	private void updatedStudent() {
		
		
		try {
			System.out.println("Enter Student ID:- ");
			int i = Integer.parseInt(reader.readLine());
			Student student = studentServices.getStudent(i);
			System.out.println("Name :- " + student.getStName());
			System.out.println("Roll NO :- " + student.getRollNo());
			studentinfo.setStID(student.getStID());
			System.out.println("Enter Updated Student Roll no");
			int Roll = Integer.parseInt(reader.readLine());
			studentinfo.setRollNo(Roll);
			System.out.println("Enter Updated Student Name");
			String Name = reader.readLine();
			studentinfo.setStName(Name);
			System.out.println("Choose Updated Classroom");
			classroomMapper.displayAllClassrooms();
			System.out.println(" Enter ClassID not the Classroom");
			int classroom = Integer.parseInt(reader.readLine());
			studentinfo.setClassID(classroom);
			studentServices.updateStudent(studentinfo, i);
		} catch (Exception e) {
			System.err.println("Invalid Input"+e.getMessage());
			updatedStudent();
		}
		finally {
			displayStudentOptions(managementMapper);
		}
		
		
	}

	private void insertStudent() {
		try {
			int id = studentServices.getNewStudentID();
			System.out.println("New Student ID is "+ id +", Student ID is important, remember it & do not share it with anyone ");
			studentinfo.setStID(id);
			
			System.out.println("Enter Student Roll No");
			int Roll = Integer.parseInt(reader.readLine());
			studentinfo.setRollNo(Roll);
			
			System.out.println("Enter Student Name");
			String Name = reader.readLine();
			studentinfo.setStName(Name);
			
			System.out.println("Choose Classroom, Enter ClassID not the Classroom");
			classroomMapper.displayAllClassrooms();
			int classroom = Integer.parseInt(reader.readLine());
			studentinfo.setClassID(classroom);
			studentServices.insertStudent(studentinfo);
		}catch (Exception e) {
			System.err.println("Invalid Input"+e.getMessage());
			insertStudent();
		}
		finally {
			displayStudentOptions(managementMapper);
		}
		
		
		
		
		
	}

}
