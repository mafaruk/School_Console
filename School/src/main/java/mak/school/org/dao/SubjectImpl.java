package mak.school.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Subjects;

@Component
public class SubjectImpl implements SubjectDao{

	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int insertSubjects(Subjects subject) {
		String Query = "insert into Subject(subjectID,subjectName,	teacherID,	classID) values(?,?,?,?)";
		int i = jdbcTemplate.update(Query, subject.getSubId(),subject.getSubName(), subject.gettID(), subject.getClassID());
		return i;
	}

	@Override
	public Subjects getSubjects(int subid) {
		String Query = "select * from Subject where subjectID = ?";
		RowMapper<Subjects> rowMapper= new RowMapper<Subjects>() {
			public Subjects mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subjects subject = new Subjects();
				subject.setSubName(rs.getString("subjectName"));
				subject.setSubId(rs.getInt("subjectID"));
				subject.settID(rs.getInt("teacherID"));
				subject.setClassID(rs.getInt("classID"));
				return subject;
			}
		};
		Subjects subject = jdbcTemplate.queryForObject(Query,rowMapper, subid );
		return subject;	
	}

	@Override
	public List<Subjects> getAllSubjects() {
		String Query = "select * from Subject";
		RowMapper<Subjects> rowMapper= new RowMapper<Subjects>() {
			public Subjects mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subjects subject = new Subjects();
				subject.setSubName(rs.getString("subjectName"));
				subject.setSubId(rs.getInt("subjectID"));
				subject.settID(rs.getInt("teacherID"));
				subject.setClassID(rs.getInt("classID"));
				return subject;
			}
		};
		List<Subjects> subjects = jdbcTemplate.query(Query,rowMapper );
		return subjects;	
	}
	
	@Override
	public int updateSubjects(Subjects subject, int subID) {
		String Query = "update subject set subjectID=?,	subjectName=?,	teacherID=?,	classID=? where subjectID = ?";
		int r = jdbcTemplate.update(Query,subject.getSubId(), subject.getSubName(), subject.gettID(), subject.getClassID(), subID);
		return r;
	}

	@Override
	public int delete(int subID) {
		String Query = "delete from subject where subjectID = ?";
		int r = jdbcTemplate.update(Query, subID);
		return r;
		
	}

	@Override
	public List<Subjects> getSubjectsfromClassID(int classID) {
		String Query = "select * from Subject where classID =?";
		RowMapper<Subjects> rowMapper= new RowMapper<Subjects>() {
			public Subjects mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subjects subject = new Subjects();
				subject.setSubName(rs.getString("subjectName"));
				subject.setSubId(rs.getInt("subjectID"));
				subject.settID(rs.getInt("teacherID"));
				subject.setClassID(rs.getInt("classID"));
				return subject;
			}
		};
		List<Subjects> subjects = jdbcTemplate.query(Query,rowMapper, classID );
		return subjects;	
	}

	public List<Subjects> getSubjectsfromTeacherID(int tid) {
		String Query = "select * from Subject where teacherID =?";
		RowMapper<Subjects> rowMapper= new RowMapper<Subjects>() {
			public Subjects mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subjects subject = new Subjects();
				subject.setSubName(rs.getString("subjectName"));
				subject.setSubId(rs.getInt("subjectID"));
				subject.settID(rs.getInt("teacherID"));
				subject.setClassID(rs.getInt("classID"));
				return subject;
			}
		};
		List<Subjects> subjects = jdbcTemplate.query(Query,rowMapper, tid );
		return subjects;	
	}

}
