package mak.school.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Mangement;

@Component
public class ManagementImpl implements ManagementDao {

	@Autowired
	@Qualifier("JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertManagement(Mangement management) {
		String Query = "insert into Management(teacherID, Designation) values(?,?)";
		int i = jdbcTemplate.update(Query, management.gettID(), management.getDesignation());
		return i;
	}

	@Override
	public Mangement getMangement(int managementID) {
		String Query = "select * from Management where managementID = ?";
		RowMapper<Mangement> rowMapper= new RowMapper<Mangement>() {
			public Mangement mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mangement mangement = new Mangement();
				mangement.setMngtID(rs.getInt("managementID"));
				mangement.settID(rs.getInt("teacherID"));
				mangement.setDesignation(rs.getString("Designation"));
				return mangement;
			}
		};
		Mangement mangement = jdbcTemplate.queryForObject(Query,rowMapper, managementID );
		return mangement;
	}

	@Override
	public List<Mangement> getAllManagement() {
		String Query = "select * from Management";
		RowMapper<Mangement> rowMapper= new RowMapper<Mangement>() {
			public Mangement mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mangement mangement = new Mangement();
				mangement.setMngtID(rs.getInt("managementID"));
				mangement.settID(rs.getInt("teacherID"));
				mangement.setDesignation(rs.getString("Designation"));
				return mangement;
			}
		};
		List<Mangement> mangements = jdbcTemplate.query(Query,rowMapper );
		return mangements ;
	}

	@Override
	public int updateMangment(Mangement mangement, int managementID) {
		String Query = "update Management set managementID=?, teacherID=?,  Designation=? where managementID = ?";
		int r = jdbcTemplate.update(Query,mangement.getMngtID(), mangement.gettID(), mangement.getDesignation(), managementID);
		return r;
	}

	@Override
	public int delete(int managementID ) {
		String Query = "delete from Management where managementID = ?";
		int r = jdbcTemplate.update(Query, managementID);
		return r;
	}
}
