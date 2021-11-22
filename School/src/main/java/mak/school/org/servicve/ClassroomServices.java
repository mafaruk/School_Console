package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.ClassroomImpl;
import mak.school.org.entities.Classroom;

@Component("Classroom")
public class ClassroomServices {

	@Autowired
	private ClassroomImpl classroomimple;
	
	public int insertClass(Classroom classroom) {
		int i = classroomimple.insertClass(classroom);
		return i;
	}

	
	public Classroom getClass(int classID) {
		Classroom classroom = classroomimple.getClass(classID);
		return classroom;
	}

	
	public List<Classroom> getAllClasses() {
		List<Classroom> classrooms = classroomimple.getAllClasses(); 
		return classrooms;
	}

	
	public int updateClass(Classroom mangement, int classID) {
		int i = classroomimple.updateClass(mangement, classID);
		return i;
	}

	
	public int delete(int classID) {
		int i = classroomimple.delete(classID);
		return i;
	}

	public Classroom getClassroomFromTeacher(int tid) {
		Classroom classroom = classroomimple.getClassroomFromTeacher(tid); 
		return classroom;
	}
	
}
