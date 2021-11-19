 package mak.school.org.servicve;

import java.util.List;

import org.springframework.stereotype.Component;

import mak.school.org.dao.StaffImpl;
import mak.school.org.entities.Staff;

@Component
public class StaffServices {
	
	private StaffImpl staffImpl;
	
	public int insertStaff(Staff staff) {
		int i =  staffImpl.insertStaff(staff);
		return 0;
	}

	
	public Staff getStaff(int tid) {
		Staff staff = staffImpl.getStaff(tid);
		return staff;
	}

	public List<Staff> getAllStaff() {
		List<Staff>  staffs = staffImpl.getAllStaff();
		return staffs;
	}
	
	public int updateStaff(Staff staff, int tID) {
		int i = staffImpl.updateStaff(staff, tID); 
		return i;
	}
}
