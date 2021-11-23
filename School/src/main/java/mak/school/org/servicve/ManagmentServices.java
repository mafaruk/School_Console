package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.ManagementImpl;
import mak.school.org.entities.Mangement;

@Component("Management")
public class ManagmentServices {

	@Autowired
	private ManagementImpl managementImpl;
	
	public int insertManagement(Mangement management, boolean isTeachingstaff) {
		int i = managementImpl.insertManagement(management,isTeachingstaff);
		return i;
	}


	public Mangement getMangement(int tid) {
		Mangement mangement = managementImpl.getMangement(tid);
		return mangement;
	}


	public List<Mangement> getAllManagement() {
		List<Mangement> mangements = managementImpl.getAllManagement();
		return mangements;
	}


	public int updateMangment(Mangement mangement, int tiD,boolean isTeachingstaff) {
		int i = managementImpl.updateMangment(mangement, tiD, isTeachingstaff);
		return i;
	}
	
	public int delete(int managementID ) {
		int i = managementImpl.delete(managementID);
		return i;
	}

}
