package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	public SubjectMapper() {
		super();
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
					"\n1.Add New Classroom Information \n2.Update Classroom Information \n3.Search Classroom Information \n4.Show All Classrooms' Information \nPress N to go back to Managerial Console");
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
				searchSubject();
				break;
			case "4":
				showAllSubject();
				break;
			case "N":
				try {
					managementMapper.displayManagerialOperationConsoles();
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.err.println("invalid choice");
				displaySubjectsOption(managementMapper);
				break;
			}

		}
	}

	private void insertSubject() {
		// TODO Auto-generated method stub
		
	}

	private void updatedSubject() {
		// TODO Auto-generated method stub
		
	}

	private void searchSubject() {
		// TODO Auto-generated method stub
		
	}

	private void showAllSubject() {
		// TODO Auto-generated method stub
		
	}

	
	
}
