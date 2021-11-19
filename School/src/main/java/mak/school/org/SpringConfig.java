package mak.school.org;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"org.springframework.jdbc.datasource", "org.springframework.jdbc.core"})
public class SpringConfig {

	@Bean(name = "DataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dm =  new DriverManagerDataSource("jdbc:sqlserver://localhost:1433;databaseName=springTest", "sa", "ok");
		dm.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		DataSource ds = dm;
		return ds;
	}
	
	@Bean(name = "JDBCTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

	
}
