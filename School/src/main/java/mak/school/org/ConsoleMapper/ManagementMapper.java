package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.entities.Mangement;
import mak.school.org.servicve.ManagmentServices;

@Component
public class ManagementMapper {

	@Autowired
	ManagmentServices managmentServices;

	Mangement mangement;

	@Autowired
	StaffMapper staffMapper;

	@Autowired
	BufferedReader reader;

	public ManagementMapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void displayManagement(int i) throws NumberFormatException, IOException {
		mangement = managmentServices.getMangement(i);
		int tid = mangement.gettID();
		System.out.println("Name :-");
		staffMapper.dispalyTeacherName(tid);
		System.out.println("Designation :- " + mangement.getDesignation());
		
		displayManagerialOperationConsoles();
	}

	private void displayManagerialOperationConsoles() throws NumberFormatException, IOException {
		System.out.println(
				"Which information do you want? \n1.Student \n2.Teaching Staff \n3.Non Taeching Staff \n4.Classroms \n5.Subject");
		int ch = Integer.parseInt(reader.readLine());
		switch (ch) {
		case 1:

			break;

		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;

		default:
			System.out.println("invalid choice");
			displayManagerialOperationConsoles();
			break;
		}
	}

}
