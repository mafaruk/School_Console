package mak.school.org.servicve;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import mak.school.org.dao.SubjectImpl;
import mak.school.org.entities.Subjects;

@Component("Subject")
public class SubjectService {
	
	@Autowired
	private SubjectImpl subjectImpl;
	
	public int insertSubjects(Subjects subject) {
		int i  = subjectImpl.insertSubjects(subject);
		return i;
	}

	
	public Subjects getSubjects(int subid) {
		Subjects sub  = subjectImpl.getSubjects(subid);
		return sub;
	}

	
	public List<Subjects> getAllSubjects() {
		List<Subjects> subjects = subjectImpl.getAllSubjects();
		return subjects;
	}

	
	public int updateSubjects(Subjects subject, int subID) {
		int res = subjectImpl.updateSubjects(subject, subID);
		return res;
	}
	
	public int delete(int subID) {
		int r = subjectImpl.delete(subID);
		return r;
		
	}
	
	public List<Subjects> getSubjectsfromClassID(int classID) {
		
		List<Subjects> subjects = subjectImpl.getSubjectsfromClassID(classID);
		return subjects;	
	}


	public List<Subjects> getSubjectsfromTeacherID(int tid) {
		List<Subjects> subjects = subjectImpl.getSubjectsfromTeacherID(tid);
		return subjects;	
	}


	public int getSubjectID() {
		return subjectImpl.getSubjectID();
	}
}
