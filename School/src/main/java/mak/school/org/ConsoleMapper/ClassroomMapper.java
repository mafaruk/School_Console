package mak.school.org.ConsoleMapper;

import java.util.List;

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
		System.out.println("Class");
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


	public void displayAllClassrooms() {
		List<Classroom> classroom = classroomServices.getAllClasses();
		System.out.println("Class ID\t\tClasroom");
		for (Classroom classroom2 : classroom) {
			System.out.println(classroom2.getClassID()+"\t\t"+classroom2.getClassroom());
		}
	}


	public String getClassroomName(int classID) {
		classroom = classroomServices.getClass(classID);
		return classroom.getClassroom();
		
	}


	public void displayClassroomOptions(ManagementMapper managementMapper) {
		System.out.println("in "+this.toString());
		
	}
	
}
