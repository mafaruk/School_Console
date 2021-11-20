package mak.school.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mak.school.org.entities.NonTeaching;
import mak.school.org.entities.Staff;
import mak.school.org.entities.TeachingStaff;

@Component
public class StaffImpl implements StaffDao {

	
	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	//NonTeacherID	NonTeacherName	Designation
	//teacherID	teacherName	subjectID
	
	@Override
	public int insertStaff(Staff staff) {
		int i =0;
		if(staff.equals(new TeachingStaff())) {
			TeachingStaff teachingStaff = (TeachingStaff)staff;
			String Query = "insert into Teacher(teacherName, subjectID) values(?,?)";
			i = jdbcTemplate.update(Query, teachingStaff.gettName(), teachingStaff.getSubjectID());
			
		}
		else {
			NonTeaching nonTeaching = (NonTeaching)staff;
			String Query = "insert into NonTeacher(NonTeacherName, Designation) values(?,?)";
			i = jdbcTemplate.update(Query, nonTeaching.gettName(), nonTeaching.getDesignation());
		}
		return i;
	}

	@Override
	public Staff getStaff(int tid,boolean isTeachingStaff) {
		if(isTeachingStaff) {
			String Query = "select * from Teacher where teacherID = ?";
			RowMapper<TeachingStaff> rowMapper= new RowMapper<TeachingStaff>() {
				public TeachingStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
					TeachingStaff staff  = new TeachingStaff();
					staff.setSubjectID(rs.getInt("subjectID"));
					staff.settName(rs.getString("teacherName"));
					staff.settID(rs.getInt("teacherID"));
					
					return staff;
				}
			};
			TeachingStaff staff = (TeachingStaff) jdbcTemplate.queryForObject(Query,rowMapper, tid );
			return staff;	
			
		}
		else {
			String Query = "select * from NonTeacher where NonTeacherID = ?";
			RowMapper<NonTeaching> rowMapper= new RowMapper<NonTeaching>() {
				public NonTeaching mapRow(ResultSet rs, int rowNum) throws SQLException {
					NonTeaching staff  = new NonTeaching();
					staff.setDesignation("Designation");
					staff.settName(rs.getString("NonTeacherName"));
					staff.settID(rs.getInt("NonTeacherID"));
					
					return staff;
				}
			};
			NonTeaching staff = (NonTeaching) jdbcTemplate.queryForObject(Query,rowMapper, tid );
			return staff;	
		}
		
	} 

	@Override
	public int updateStaff(Staff staff, int tID) {
		int i =0;
		if(staff.equals(new TeachingStaff())) {
			TeachingStaff teachingStaff = (TeachingStaff)staff;
			String Query = "update Teacher set teacherID=?,	teacherName=?,	subjectID=? where teacherID = ?";
			i = jdbcTemplate.update(Query, teachingStaff.gettID(), teachingStaff.gettName(), teachingStaff.getSubjectID(), tID);
			
		}
		else {
			NonTeaching nonTeaching = (NonTeaching)staff;
			String Query = "update NonTeacher set NonTeacherID=?,	NonTeacherName=?,	Designation=? where NonTeacherID = ?";
			i = jdbcTemplate.update(Query, nonTeaching.gettID(),nonTeaching.gettName(), nonTeaching.getDesignation(), tID);
		}
		return i;
		
	}

	@Override
	public int delete(int tID, boolean isTeachingStaff) {
		if(isTeachingStaff) {
			String Query = "delete from Teacher where teacherID = ?";
			int r = jdbcTemplate.update(Query, tID);
			return r;
		}
		else {
			String Query = "delete from NonTeacher where NonTeacherID = ?";
			int r = jdbcTemplate.update(Query, tID);
			return r;
		}
		
	}

	@Override
	public List<TeachingStaff> getAllTecahingStaff() {
		String Query = "select * from Teacher ";
		RowMapper<TeachingStaff> rowMapper= new RowMapper<TeachingStaff>() {
			public TeachingStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
				TeachingStaff staff  = new TeachingStaff();
				staff.setSubjectID(rs.getInt("subjectID"));
				staff.settName(rs.getString("teacherName"));
				staff.settID(rs.getInt("teacherID"));
				
				return staff;
			}
		};
		List<TeachingStaff> staff = jdbcTemplate.query(Query,rowMapper );
		return staff;	
		
	}

	@Override
	public List<NonTeaching> getAllNonTecahingStaff() {
		String Query = "select * from NonTeacher";
		RowMapper<NonTeaching> rowMapper= new RowMapper<NonTeaching>() {
			public NonTeaching mapRow(ResultSet rs, int rowNum) throws SQLException {
				NonTeaching staff  = new NonTeaching();
				staff.setDesignation("Designation");
				staff.settName(rs.getString("NonTeacherName"));
				staff.settID(rs.getInt("NonTeacherID"));
				
				return staff;
			}
		};
		List<NonTeaching> staff = jdbcTemplate.query(Query,rowMapper);
		return staff;	
	}

	
}
