package mak.school.org;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mak.school.org.ConsoleMapper.Consoles;


public class App {
	
	static ApplicationContext context;

	@Autowired
	private Consoles consoles;
	
	@Autowired
	private BufferedReader reader;
	
	 public App(ApplicationContext context) {
			super();
			this.reader = context.getBean(BufferedReader.class);
			this.consoles = context.getBean(Consoles.class);
			
		}
	 public App() {
			super();
			// TODO Auto-generated constructor stub
		}

	public void homeConsole() {
		System.out.println("\n\nwelcome to School Portal\n");
        System.out.println("you are ? \n1.Student \n2.Staff \n3.Management Staff \n\nEnter the Number:-");
        int role =0;
       try {
    	   role = Integer.parseInt(reader.readLine());  
       } 
       catch(NumberFormatException | IOException ex) {
			System.err.println("Invalid input");
			homeConsole();
		}
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
			System.out.println("Invalid Role, Try Again");
			homeConsole();
			break;
		}
        
		
	}
	
   

	public static void main( String[] args )
    {
		context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	new App(context).homeConsole();
    	
    }

	
	
}
