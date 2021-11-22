 package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.StaffImpl;
import mak.school.org.entities.NonTeaching;
import mak.school.org.entities.Staff;
import mak.school.org.entities.TeachingStaff;

@Component("staff")
public class StaffServices {
	
	@Autowired
	private StaffImpl staffImpl;
	
	public int insertStaff(Staff staff) {
		int i =  staffImpl.insertStaff(staff);
		return i;
	}

	
	public Staff getStaff(int tid, boolean  isTeachingStaff) {
		Staff staff = staffImpl.getStaff(tid, isTeachingStaff);
		return staff;
	}

	public List<TeachingStaff> getAllTecahingStaff() {
		List<TeachingStaff>  staffs = staffImpl.getAllTecahingStaff();
		return staffs;
	}
	
	public List<NonTeaching> getAllNonTecahingStaff() {
		List<NonTeaching>  staffs = staffImpl.getAllNonTecahingStaff();
		return staffs;
	}
	
	public int updateStaff(Staff staff, int tID) {
		int i = staffImpl.updateStaff(staff, tID); 
		return i;
	}
	
	public int delete(int tID, boolean isTeachingStaff) {
		int i = staffImpl.delete(tID, isTeachingStaff);
		return i;
	}
}
