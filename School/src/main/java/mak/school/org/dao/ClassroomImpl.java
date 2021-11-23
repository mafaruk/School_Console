package mak.school.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Classroom;

@Component
public class ClassroomImpl implements ClassroomDao {

	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	//classID	className	classTeacherID
	@Override
	public int insertClass(Classroom classroom) {
		String Query = "insert into Classroom(classID,className	classTeacherID) values(?,?,?)";
		int i = jdbcTemplate.update(Query,classroom.getClassID(),classroom.getClassroom() ,classroom.getTeacherID());
		return i;
	}

	@Override
	public Classroom getClass(int classID) {
		String Query = "select * from Classroom where classID = ?";
		RowMapper<Classroom> rowMapper= new RowMapper<Classroom>() {
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
				Classroom classroom = new Classroom();
				classroom.setClassID(rs.getInt("classID"));
				classroom.setClassroom(rs.getString("className"));
				classroom.setTeacherID(rs.getInt("classTeacherID"));
				return classroom;
			}
		};
		Classroom classroom = jdbcTemplate.queryForObject(Query,rowMapper, classID );
		return classroom;
	}

	@Override
	public List<Classroom> getAllClasses() {
		String Query = "select * from Classroom";
		RowMapper<Classroom> rowMapper= new RowMapper<Classroom>() {
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
				Classroom classroom = new Classroom();
				classroom.setClassID(rs.getInt("classID"));
				classroom.setClassroom(rs.getString("className"));
				classroom.setTeacherID(rs.getInt("classTeacherID"));
				return classroom;
			}
		};
		List<Classroom> classrooms = jdbcTemplate.query(Query,rowMapper );
		return classrooms;
	}

	@Override
	public int updateClass(Classroom classroom, int classID) {
		String Query = "update Classroom set classID =?,	className=?,	classTeacherID=? where classID = ?";
		int r = jdbcTemplate.update(Query,classroom.getClassID(),classroom.getClassroom(), classroom.getTeacherID(), classID);
		return r;
	}

	@Override
	public int delete(int classID) {
		String Query = "delete from Classroom where classID = ?";
		int r = jdbcTemplate.update(Query, classID);
		return r;
	}

	public Classroom getClassroomFromTeacher(int tid) {
		String Query = "select * from Classroom where classTeacherID = ?";
		RowMapper<Classroom> rowMapper= new RowMapper<Classroom>() {
			public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
				Classroom classroom = new Classroom();
				classroom.setClassID(rs.getInt("classID"));
				classroom.setClassroom(rs.getString("className"));
				classroom.setTeacherID(rs.getInt("classTeacherID"));
				return classroom;
			}
		};
		Classroom classroom = jdbcTemplate.queryForObject(Query,rowMapper, tid );
		return classroom;
	}

}
