package mak.school.org.dao;

import java.util.List;

import mak.school.org.entities.Mangement;

public interface ManagementDao {

	public int insertManagement(Mangement management);
	public Mangement getMangement(int tid);
	public List<Mangement> getAllManagement();
	public int updateMangment(Mangement mangement, int tiD);
}
