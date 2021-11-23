package mak.school.org.ConsoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Classroom;
import mak.school.org.entities.NonTeaching;
import mak.school.org.entities.Staff;
import mak.school.org.entities.TeachingStaff;
import mak.school.org.servicve.StaffServices;

@Component
public class StaffMapper {

	@Autowired
	StaffServices staffServices;
	
	@Autowired
	SubjectMapper subjectMapper;
	

	Staff staff;
	
	public StaffMapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void dispalyTeacher(int tid, boolean isTeaching) {
		if(isTeaching) {
			TeachingStaff teachingStaff = (TeachingStaff) staffServices.getStaff(tid, isTeaching);
			System.out.println("Name :- "+ teachingStaff.gettName());
			subjectMapper.displaySubjectsFromTeacher(tid);
			
		}else {
			NonTeaching nonTeaching = (NonTeaching)staffServices.getStaff(tid, isTeaching);
			System.out.println("Name :- "+ nonTeaching.gettName());
			System.out.println("Designation :- "+ nonTeaching.getDesignation());
			
		}
	}

	public void dispalyTeacherName(int tid) {
		staff = staffServices.getStaff(tid, true);
		System.out.println(staff.gettName());
		
	}

	public void displaySudentOption(ManagementMapper managementMapper, boolean isTeaching) {
		System.out.println("in "+this.toString());
		
	}

	
	
}
