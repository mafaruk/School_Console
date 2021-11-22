package mak.school.org;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import mak.school.org.ConsoleMapper.Consoles;


public class App {
	
	static ApplicationContext context;

	@Autowired
	private Consoles consoles;
	
	@Autowired
	private BufferedReader reader;// = new BufferedReader(new InputStreamReader(System.in));
	
	 public App(ApplicationContext context) {
			super();
			this.reader = context.getBean(BufferedReader.class);
			this.consoles = context.getBean(Consoles.class);
			
		}
	 public App() {
			super();
			// TODO Auto-generated constructor stub
		}

	public void homeConsole() throws NumberFormatException, IOException {
		System.out.println("\n\nwelcome to School Portal\n");
        System.out.println("you are ? \n1.Student \n2.Staff \n3.Management Staff \n\nEnter the Number:-");
        int role = Integer.parseInt(reader.readLine());
        switch (role) {
		case 1:
			consoles.getStudentConsole();
			break;
		case 2:
			consoles.getStaffConsole();
			break;
		case 3:
			consoles.getManagementStaffConsole();
			break;

		default:
			System.out.println("Invalid Role");
			break;
		}
        
		
	}
	
   

	public static void main( String[] args ) throws NumberFormatException, IOException
    {
		context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	new App(context).homeConsole();
    	
    }

	
	
}
