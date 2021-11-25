package mak.school.org.ConsoleMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mak.school.org.entities.NonTeaching;
import mak.school.org.entities.Staff;

import mak.school.org.entities.TeachingStaff;
import mak.school.org.servicve.StaffServices;

@Component
public class StaffMapper {

	@Autowired
	StaffServices staffServices;

	@Autowired
	SubjectMapper subjectMapper;

	@Autowired
	ManagementMapper managementMapper;

	@Autowired
	BufferedReader reader;
	
	Staff staff;

	NonTeaching nonTeaching;
	
	TeachingStaff teachingStaff;

	public StaffMapper() {
		super();
		teachingStaff = new TeachingStaff();
		nonTeaching = new NonTeaching(); 
		
		// TODO Auto-generated constructor stub
	}

	public void dispalyTeacher(int tid, boolean isTeaching) {
		if (isTeaching) {
			TeachingStaff teachingStaff = (TeachingStaff) staffServices.getStaff(tid, isTeaching);
			System.out.println("Name :- " + teachingStaff.gettName());
			subjectMapper.displaySubjectsFromTeacher(tid);

		} else {
			NonTeaching nonTeaching = (NonTeaching) staffServices.getStaff(tid, isTeaching);
			System.out.println("Name :- " + nonTeaching.gettName());
			System.out.println("Designation :- " + nonTeaching.getDesignation());

		}
	}

	public void dispalyTeacherName(int tid, boolean isTeaching) {
		if (isTeaching) {
			staff = staffServices.getStaff(tid, true);
			System.out.println(staff.gettName());

		} else {
			staff = staffServices.getStaff(tid, true);
			System.out.println(staff.gettName());

		}

	}

	public void displayStaffOption(Object object, boolean isTeaching) {
		if (object instanceof ManagementMapper) {
			managementMapper = (ManagementMapper) object;
			System.out.println(
					"\n1.Add New Teacher's Information \n2.Update Teacher's Information \n3.Delete Teacher's Information \n4.Search Teacher's Information \n5.Show All Teachers' Information \nPress N to go back to Managerial Console ");
			String sch = null;
			try {
				sch = reader.readLine();
			} catch (Exception e) {
				System.err.println("Invalid input");
				displayStaffOption(managementMapper, isTeaching);
			}

			switch (sch) {
			case "1":
				insertStaff(isTeaching);
				break;
			case "2":
				updatedStaff(isTeaching);
				break;
			case "3":
				deleteStaff(isTeaching);
				break;
			case "4":
				searchStaff(isTeaching);
				break;
			case "5":
				showAllStaff(isTeaching);
				break;
			case "N":
				try {
					managementMapper.displayManagerialOperationConsoles();
				} catch (NumberFormatException | IOException e) {
					System.err.println("Invalid Input" + e.getMessage());
				}
				break;
			default:
				System.err.println("invalid choice");
				displayStaffOption(managementMapper, isTeaching);
				break;
			}

		}

	}

	private void insertStaff(boolean isTeaching) {
		try {
			if (isTeaching) {
				
				int id = staffServices.getNewStafftID(true);
				System.out.println("New Teacher ID is " + id
						+ ", Teacher ID is important, remember it & do not share it with anyone ");
				teachingStaff.settID(id);

				System.out.println("Enter Teacher Name");
				String Name = reader.readLine();
				teachingStaff.settName(Name);

				staffServices.insertStaff(teachingStaff);
			} else {
			
				int id = staffServices.getNewStafftID(false);
				System.out.println("New Teacher ID is " + id
						+ ", Teacher ID is important, remember it & do not share it with anyone ");
				nonTeaching.settID(id);

				System.out.println("Enter Teacher Name");
				String Name = reader.readLine();
				nonTeaching.settName(Name);

				System.out.println("Enter Designation");
				String designation = reader.readLine();
				nonTeaching.setDesignation(designation);

				staffServices.insertStaff(nonTeaching);
			}

		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			insertStaff(isTeaching);
		} finally {
			displayStaffOption(managementMapper, isTeaching);
		}
	}

	private void updatedStaff(boolean isTeaching) {
		try {
			if(isTeaching) {
				
				
				System.out.println("Enter Teacher ID:- ");
				int i = Integer.parseInt(reader.readLine());
				TeachingStaff teachingStaff2 = (TeachingStaff) staffServices.getStaff(i,isTeaching);
				
				System.out.println("Name :- " + teachingStaff2.gettName());
				teachingStaff.settID(teachingStaff2.gettID());
				
				System.out.println("Enter Updated Teacher Name");
				String Name = reader.readLine();
				teachingStaff.settName(Name);
				
				staffServices.updateStaff(teachingStaff, i);
			}else {
				
				
				System.out.println("Enter Teacher ID:- ");
				int i = Integer.parseInt(reader.readLine());
				NonTeaching nonTeaching2 = (NonTeaching) staffServices.getStaff(i,isTeaching);
				
				System.out.println("Name :- " + nonTeaching2.gettName());
				System.out.println("Designation :- " + nonTeaching2.gettName());
				nonTeaching.settID(nonTeaching2.gettID());
				
				System.out.println("Enter Updated Teacher Name");
				String Name = reader.readLine();
				nonTeaching.settName(Name);
				
				System.out.println("Enter Updated Designation");
				String designation = reader.readLine();
				nonTeaching.setDesignation(designation);
				staffServices.updateStaff(nonTeaching, i);
				
			}
			
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			updatedStaff(isTeaching);
		} finally {
			displayStaffOption(managementMapper, isTeaching);
		}

	}

	private void deleteStaff(boolean isTeaching) {
		try {
			int i = 0;
			if(isTeaching) {

				System.out.println("Enter Teacher ID:- ");
				 i = Integer.parseInt(reader.readLine());
				 dispalyTeacher(i, isTeaching);	
			}else {
				System.out.println("Enter Teacher ID:- ");
				 i = Integer.parseInt(reader.readLine());
				 dispalyTeacher(i, isTeaching);
			}
			System.out.println("Are You sure? you want to delete Teacher Info. Y/N");
			String ch = reader.readLine();
			if(ch.equalsIgnoreCase("Y")) {
				staffServices.delete(i, isTeaching);
			}
			else if(ch.equalsIgnoreCase("N")) {
				displayStaffOption(managementMapper, isTeaching);
			}
			else {
				System.out.println("Invalid Input, Considering This As NO");
				displayStaffOption(managementMapper, isTeaching);
			}
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			deleteStaff(isTeaching);
		}
		finally {
			displayStaffOption(managementMapper, isTeaching);
		}

	}

	private void searchStaff(boolean isTeaching) {
		try {
			int i = 0;
			if(isTeaching) {
				
				System.out.println("Enter Teacher ID:- ");
				 i = Integer.parseInt(reader.readLine());
				 dispalyTeacher(i, isTeaching);
				 
			}else {
				
				System.out.println("Enter Teacher ID:- ");
				 i = Integer.parseInt(reader.readLine());
				dispalyTeacher(i, isTeaching);
				
			}
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			searchStaff(isTeaching);
		}
		finally {
			displayStaffOption(managementMapper, isTeaching);
		}

	}
	
	public void displayAllStaff(boolean isTeaching) {
		if(isTeaching) {
			List<TeachingStaff> teachingList = staffServices.getAllTecahingStaff();
			
			for (TeachingStaff teachingStaff : teachingList) {
				System.out.println("\nTeacher ID: -"+ teachingStaff.gettID());
				System.out.println("Name: -"+ teachingStaff.gettName());
				subjectMapper.displaySubjectsFromTeacher(teachingStaff.gettID());
			}
		}
		else {
			List<NonTeaching> nonteachingList = staffServices.getAllNonTecahingStaff();
			
			for (NonTeaching nonteachingStaff : nonteachingList) {
				System.out.println("\nTeacher ID: -"+ nonteachingStaff.gettID());
				System.out.println("Name: -"+ nonteachingStaff.gettName());
				System.out.println("Designation: -"+ nonteachingStaff.getDesignation());
				
			}
			
		}
	}

	public void showAllStaff(boolean isTeaching) {
		try {
			displayAllStaff(isTeaching);
		} catch (Exception e) {
			System.err.println("Invalid Input" + e.getMessage());
			showAllStaff(isTeaching);
		}
		finally {
			displayStaffOption(managementMapper, isTeaching);
		}

	}

}
