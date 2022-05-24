package ua.lviv.lgs;

import java.io.File;
import java.util.*;

public class Application {
	public static void main(String[] args) throws Exception {
		
		File f = new File("newFile.txt");
		
		Emploee emploee = new Emploee("Ivan", 1313, 2000);				// creating employees
		Emploee emploee2 = new Emploee("Steve", 1234, 2500);
		Emploee emploee3 = new Emploee("George", 5555, 1000);
		Emploee emploee4 = new Emploee("Andriy", 5635, 1200);
		
		ArrayList<Emploee> emploeeList = new ArrayList<>(); 			// creating List of employees
		
		
		emploeeList.add(emploee2);										// add employees to list
		emploeeList.add(emploee);
		emploeeList.add(emploee3);
		emploeeList.add(emploee4);
	
		Methods m = new Methods();										// call methods class
		
		m.serialize(f, emploee);
		System.out.println("Tasks 1,2,3" + " : " + m.deserialize(f));
		
		
		m.listSerialization(f, emploeeList);							// List serialize Task 4
		
		System.out.println("Task 4: " + m.listDeserialization(f));					 
	}
}
