package org.java.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass {

	public static void main(String args[]){
		
		//set values to employee object
		Employee employeeObject=new Employee();
		employeeObject.setFirstName("FirstName");
		employeeObject.setLastName("LastName");
		
		Serialize(employeeObject);
		
		DeSerialize();
	}
	
	private static void Serialize(Employee employeeObject){

		try{
			
			FileOutputStream outputStream=new FileOutputStream("./test.txt");
			ObjectOutputStream out=new ObjectOutputStream(outputStream);
			out.writeObject(employeeObject);
			out.close();
			outputStream.close();
		}catch(IOException exc){
			System.out.println(exc.getMessage());
		}
	}
	
	
	private static void DeSerialize(){
		Employee emp = null;
		try {
		FileInputStream fileIn = new FileInputStream("./test.txt");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		emp = (Employee) in.readObject();
		in.close();
		fileIn.close();
		} catch (IOException i) {
		i.printStackTrace();
		return;
		} catch (ClassNotFoundException c) {
		System.out.println("Employee class not found");
		c.printStackTrace();
		return;
		}
		System.out.println("Deserializing Employee...");
		System.out.println("First Name of Employee: " + emp.getFirstName());
		System.out.println("Last Name of Employee: " + emp.getLastName());
		}
	
}
