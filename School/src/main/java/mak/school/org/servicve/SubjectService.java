package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.SubjectImpl;
import mak.school.org.entities.Subjects;

@Component
public class SubjectService {
	
	@Autowired
	private SubjectImpl subjectImpl;
	
	public int insertSubjects(Subjects subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Subjects getSubjects(int subid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Subjects> getAllSubjects() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int updateSubjects(Subjects subject, int subID) {
		// TODO Auto-generated method stub
		return 0;
	}
}
