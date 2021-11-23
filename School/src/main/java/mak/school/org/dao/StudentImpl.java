package mak.school.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Student;

@Component
public class StudentImpl implements StudentDao{

	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int insertStudent(Student student) {
		String Query = "insert into student(studentID,studentName, rollNo,classID) values(?,?,?,?)";
		int i = jdbcTemplate.update(Query, student.getStID(),student.getStName(), student.getRollNo(), student.getClassID());
		return i;
	}

	
	@Override
	public Student getStudent(int sid) {
		String Query = "select * from student where studentID = ?";
		RowMapper<Student> rowMapper= new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setStName(rs.getString("studentName"));
				student.setRollNo(rs.getInt("rollNo"));
				student.setStID(rs.getInt("studentID"));
				student.setClassID(rs.getInt("classID"));
				return student;
			}
		};
		Student student = jdbcTemplate.queryForObject(Query,rowMapper, sid );
		return student;	
	}

	@Override
	public List<Student> getAllStudent() {
		String Query = "select * from student ";
		RowMapper<Student> rowMapper= new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setStName(rs.getString("studentName"));
				student.setRollNo(rs.getInt("rollNo"));
				student.setStID(rs.getInt("studentID"));
				student.setClassID(rs.getInt("classID"));
				return student;
			}
		};
		List<Student> students = jdbcTemplate.query(Query,rowMapper );
		return students;	
	}

	@Override
	public int updateStudent(Student student, int sID) {
		String Query = "update student set studentName=?, rollNo=?, classID=?, studentID=? where studentID = ?";
		int r = jdbcTemplate.update(Query,student.getStName(), student.getRollNo(), student.getClassID(), student.getStID(), sID);
		return r;
		
	}

	@Override
	public int delete(int sID) {
		String Query = "delete from student where studentID = ?";
		int r = jdbcTemplate.update(Query, sID);
		return r;
	}


	public int getNewStudentID() {
		String Query = "select max(studentID) as newID from student";
		Integer studentID = jdbcTemplate.queryForObject(Query, Integer.class );
		return studentID+1;
				
	}

}
