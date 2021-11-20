package mak.school.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



/**
 * Hello world!
 *
 */

public class App 
{
	@Autowired
	private static Consoles consoles;
	
	
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	consoles = new Consoles();
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     
    	System.out.println("welcome to School Portal");
        System.out.println("you are \n1.Student \n2.Staff \n3.Management Staff");
        int role = Integer.parseInt(reader.readLine());
        switch (role) {
		case 1:
			consoles.getStudentConsole(context);
			break;
		case 2:
			consoles.getStaffConsole(context);
			break;
		case 3:
			consoles.getManagementStaffConsole(context);
			break;

		default:
			System.out.println("Invalid Role");
			break;
		}
        
        
        
        
      
    }
}
