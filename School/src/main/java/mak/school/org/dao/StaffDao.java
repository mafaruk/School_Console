package mak.school.org.dao;



import java.util.List;

import mak.school.org.entities.NonTeaching;
import mak.school.org.entities.Staff;
import mak.school.org.entities.TeachingStaff;

public interface StaffDao {

	public int insertStaff(Staff staff);
	public Staff getStaff(int tid, boolean isTeachingStaff);
	public List<TeachingStaff> getAllTecahingStaff();
	public List<NonTeaching> getAllNonTecahingStaff();
	public int updateStaff(Staff staff, int tID);
	public int delete(int tID, boolean isTeachingStaff);
}
