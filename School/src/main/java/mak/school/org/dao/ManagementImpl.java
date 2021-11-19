package mak.school.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Mangement;

@Component
public class ManagementImpl implements ManagementDao {

	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertManagement(Mangement management) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mangement getMangement(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mangement> getAllManagement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMangment(Mangement mangement, int tiD) {
		// TODO Auto-generated method stub
		return 0;
	}

}
