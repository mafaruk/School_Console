package mak.school.org.ConsoleMapper;

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
	
	public ClassroomMapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void displayClassroom(int classID) {
		classroom = classroomServices.getClass(classID);
	}
	
	public void displayTeacherFromClassroom(int classID) {
		classroom = classroomServices.getClass(classID);
		System.out.println("Classroom :- "+classroom.getClassroom());
		int tid = classroom.getTeacherID();
		System.out.print("Class Teacher :- ");
		staffMapper.dispalyTeacherName(tid);
		
	}
	
	public void displayClassrromFromTeacher(int tid) {
		   classroom = classroomServices.getClassroomFromTeacher(tid);
		   System.out.println("Classroom :- "+classroom.getClassroom());
	}
	
}
