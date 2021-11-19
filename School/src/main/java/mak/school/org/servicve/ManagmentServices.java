package mak.school.org.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.dao.ManagementImpl;
import mak.school.org.entities.Mangement;

@Component
public class ManagmentServices {

	@Autowired
	private ManagementImpl managementImpl;
	
	public int insertManagement(Mangement management) {
		int i = managementImpl.insertManagement(management);
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


	public int updateMangment(Mangement mangement, int tiD) {
		int i = managementImpl.updateMangment(mangement, tiD);
		return i;
	}

}
