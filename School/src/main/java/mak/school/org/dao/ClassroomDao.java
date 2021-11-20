package mak.school.org.dao;

import java.util.List;

import mak.school.org.entities.Classroom;


public interface ClassroomDao {
	public int insertClass(Classroom classroom);
	public Classroom getClass(int classID);
	public List<Classroom> getAllClasses();
	public int updateClass(Classroom mangement, int classID);
	public int delete(int classID );
}
