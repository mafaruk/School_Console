package mak.school.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import mak.school.org.ConsoleMapper.Consoles;


@Configuration
@ComponentScan(basePackages = {"org.springframework.jdbc.datasource", "org.springframework.jdbc.core","mak.school.org"})
public class SpringConfig {

	@Bean(name = "DataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dm =  new DriverManagerDataSource("jdbc:sqlserver://localhost:1433;databaseName=SchoolSpringJDBC", "sa", "ok");
		dm.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		DataSource ds = dm;
		return ds;
	}
	
	@Bean(name = "JDBCTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public BufferedReader getBufferedReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
	
}
