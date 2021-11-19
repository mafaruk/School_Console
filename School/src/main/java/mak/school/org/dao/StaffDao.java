package mak.school.org.dao;

import java.util.List;

import mak.school.org.entities.Staff;

public interface StaffDao {

	public int insertStaff(Staff staff);
	public Staff getStaff(int tid);
	public List<Staff> getAllStaff(); 
	public int updateStaff(Staff staff, int tID);
	
}
