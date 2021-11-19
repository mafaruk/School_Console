package mak.school.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Subjects;

@Component
public class SubjectImpl implements SubjectDao{

	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertSubjects(Subjects subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Subjects getSubjects(int subid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subjects> getAllSubjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSubjects(Subjects subject, int subID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
