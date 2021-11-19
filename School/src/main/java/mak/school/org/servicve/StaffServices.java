package mak.school.org.servicve;

import java.util.List;

import org.springframework.stereotype.Component;

import mak.school.org.dao.StaffImpl;
import mak.school.org.entities.Staff;

@Component
public class StaffServices {
	
	private StaffImpl staffImpl;
	
	public int insertStaff(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Staff getStaff(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int updateStaff(Staff staff, int tID) {
		// TODO Auto-generated method stub
		return 0;
	}
}
