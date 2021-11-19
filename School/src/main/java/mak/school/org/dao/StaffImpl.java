package mak.school.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Staff;

@Component
public class StaffImpl implements StaffDao {

	
	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertStaff(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Staff getStaff(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStaff(Staff staff, int tID) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
