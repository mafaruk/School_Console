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
		// TODO Auto-generated method stub
		return 0;
	}


	public Mangement getMangement(int tid) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Mangement> getAllManagement() {
		// TODO Auto-generated method stub
		return null;
	}


	public int updateMangment(Mangement mangement, int tiD) {
		// TODO Auto-generated method stub
		return 0;
	}

}
