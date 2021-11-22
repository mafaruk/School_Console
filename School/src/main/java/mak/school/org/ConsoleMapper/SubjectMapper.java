package mak.school.org.ConsoleMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Subjects;
import mak.school.org.servicve.SubjectService;

@Component
public class SubjectMapper {

	@Autowired
	SubjectService subjectService;
	
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

	
	
}
