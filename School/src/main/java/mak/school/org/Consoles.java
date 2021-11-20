package mak.school.org;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import mak.school.org.servicve.ClassroomServices;
import mak.school.org.servicve.ManagmentServices;
import mak.school.org.servicve.StaffServices;
import mak.school.org.servicve.StudentServices;
import mak.school.org.servicve.SubjectService;

@Component
public class Consoles {

	
	
	public void getStudentConsole(ApplicationContext context) {
		 StudentServices services = context.getBean("Student", StudentServices.class);
	}
	public void getStaffConsole(ApplicationContext context) {
		 StaffServices services = context.getBean("staff", StaffServices.class);
		
	}
	public void getManagementStaffConsole(ApplicationContext context) {
		ManagmentServices services = context.getBean("Management", ManagmentServices.class);
	}
	
	public void getSubjectCosole(ApplicationContext context) {
		SubjectService services = context.getBean("Subject", SubjectService.class);
	}
	
	public void getClassroomCosole(ApplicationContext context) {
		ClassroomServices services = context.getBean("Classroom", ClassroomServices.class);
	}
	
	
	
	
}
