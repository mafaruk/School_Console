package mak.school.org.dao;

import java.util.List;

import mak.school.org.entities.Mangement;

public interface ManagementDao {

	public int insertManagement(Mangement management);
	public Mangement getMangement(int managementID);
	public List<Mangement> getAllManagement();
	public int updateMangment(Mangement mangement, int managementID);
	public int delete(int managementID );
}
