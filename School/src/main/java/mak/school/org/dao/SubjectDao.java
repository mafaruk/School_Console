package mak.school.org.dao;

import java.util.List;

import mak.school.org.entities.Subjects;

public interface SubjectDao {
	public int insertSubjects(Subjects subject);
	public Subjects getSubjects(int subid);
	public List<Subjects> getAllSubjects(); 
	public int updateSubjects(Subjects subject, int subID);
}
