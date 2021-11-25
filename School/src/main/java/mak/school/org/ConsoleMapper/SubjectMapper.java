package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Staff;
import mak.school.org.entities.Subjects;
import mak.school.org.servicve.SubjectService;

@Component
public class SubjectMapper {

	@Autowired
	SubjectService subjectService;

	@Autowired
	ManagementMapper managementMapper;

	@Autowired
	BufferedReader reader;

	@Autowired
	StaffMapper staffMapper;

	@Autowired
	ClassroomMapper classroomMapper;

	Subjects subjects;

	public SubjectMapper() {
		super();
		subjects = new Subjects();
		// TODO Auto-generated constructor stub
	}

	public void displaySubjectsFromClassroom(int cid) {
		List<Subjects> subjects = subjectService.getSubjectsfromClassID(cid);
		System.out.println("Your Subjects are");
		for (Subjects subjects2 : subjects) {
			System.out.println(subjects2.getSubName());
		}
	}

	public void displaySubjectsFromTeacher(int tid) {
		List<Subjects> subjects = subjectService.getSubjectsfromTeacherID(tid);
		System.out.println("Your Subjects are");
		for (Subjects subjects2 : subjects) {
			System.out.println(subjects2.getSubName());
		}
	}

	public void displaySubjectsOption(Object object) {

		if (object instanceof ManagementMapper) {
			managementMapper = (ManagementMapper) object;
			System.out.println(
					"\n1.Add New Subject's Information \n2.Update Subject's Information \n3.Delete Subject's Information \n4.Search Subject's Information \n5.Show All Subjects' Information \nPress N to go back to Managerial Console");
			String sch = null;
			try {
				sch = reader.readLine();
			} catch (Exception e) {
				System.err.println("Invalid input");
				displaySubjectsOption(managementMapper);
			}

			switch (sch) {
			case "1":
				insertSubject();
				break;
			case "2":
				updatedSubject();
				break;
			case "3":
				deleteSubject();
				break;
			case "4":
				searchSubject();
				break;
			case "5":
				showAllSubject();
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
				displaySubjectsOption(managementMapper);
				break;
			}

		}
	}

	private void deleteSubject() {
		try {

			System.out.println("Enter Subject ID:- ");
			int subid = Integer.parseInt(reader.readLine());
			Subjects subject2 = subjectService.getSubjects(subid);
			System.out.println("Name:- " + subject2.getSubName());
			System.out.print("Teacher");staffMapper.dispalyTeacher(subject2.gettID(), true);
			classroomMapper.displayClassroom(subject2.getClassID());
			System.out.println("Are You sure? you want to delete Subject Info. Y/N");
			String ch = reader.readLine();
			if (ch.equalsIgnoreCase("Y")) {
				subjectService.delete(subid);
			} else if (ch.equalsIgnoreCase("N")) {
				displaySubjectsOption(managementMapper);
			} else {
				System.out.println("Invalid Input, Considering This As NO");
				displaySubjectsOption(managementMapper);
			}
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			deleteSubject();
		} finally {
			displaySubjectsOption(managementMapper);
		}

	}

	private void insertSubject() {
		try {
			int subid = subjectService.getSubjectID();
			System.out.println("New Subject ID is " + subid + " ");
			subjects.setSubId(subid);

			System.out.println("Enter Subject Name: -");
			String name = reader.readLine();
			subjects.setSubName(name);

			System.out.println("Choose Teacher,");
			staffMapper.displayAllStaff(true);
			System.out.println("Enter Teacher ID not the Teacher's Name");
			int teacher = Integer.parseInt(reader.readLine());
			subjects.settID(teacher);


			classroomMapper.displayAllClassrooms();
			System.out.println("Choose Classroom, Enter ClassID not the Classroom");
			int classroom = Integer.parseInt(reader.readLine());
			subjects.setClassID(classroom);

			subjectService.insertSubjects(subjects);

		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			insertSubject();
		} finally {
			displaySubjectsOption(managementMapper);
		}

	}

	private void updatedSubject() {
		try {
			System.out.println("Enter Subject ID:- ");
			int subid = Integer.parseInt(reader.readLine());
			Subjects subject2 = subjectService.getSubjects(subid);
			System.out.println("Name:- " + subject2.getSubName());
			staffMapper.dispalyTeacher(subject2.gettID(), true);
			classroomMapper.displayClassroom(subject2.getClassID());

			subjects.setSubId(subid);

			System.out.println("Enter Subject Name: -");
			String name = reader.readLine();
			subjects.setSubName(name);

			System.out.println("Choose Teacher,");
			staffMapper.displayAllStaff(true);
			System.out.println("Enter Teacher ID not the Teacher's Name");
			int teacher = Integer.parseInt(reader.readLine());
			subjects.settID(teacher);

			
			classroomMapper.displayAllClassrooms();
			System.out.println("Choose Classroom, Enter ClassID not the Classroom");
			int classroom = Integer.parseInt(reader.readLine());
			subjects.setClassID(classroom);

			subjectService.updateSubjects(subjects, subid);

		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			updatedSubject();
		} finally {
			displaySubjectsOption(managementMapper);
		}
	}

	private void searchSubject() {
		try {
			System.out.println("Enter Subject ID:- ");
			int subid = Integer.parseInt(reader.readLine());
			Subjects subject2 = subjectService.getSubjects(subid);
			System.out.println("Name:- " + subject2.getSubName());
			System.out.print("Teacher");staffMapper.dispalyTeacher(subject2.gettID(), true);
			classroomMapper.displayClassroom(subject2.getClassID());
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			searchSubject();
		} finally {
			displaySubjectsOption(managementMapper);
		}
	}
	
	public void displayAllSubject() {
		List<Subjects> subjectlist = subjectService.getAllSubjects();
		for (Subjects subjects : subjectlist) {
			System.out.println("Name:- " + subjects.getSubName());
			System.out.print("Teacher");staffMapper.dispalyTeacher(subjects.gettID(), true);
			classroomMapper.displayClassroom(subjects.getClassID());
		}
	}

	private void showAllSubject() {
		try {
			displayAllSubject();
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			insertSubject();
		} finally {
			displaySubjectsOption(managementMapper);
		}
	}

}
