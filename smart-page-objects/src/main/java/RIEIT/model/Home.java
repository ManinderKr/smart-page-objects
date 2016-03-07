package RIEIT.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Scanner;

public class Home {

	private static String uid;
	private static String pass;
	
	public static void main(String[] args) {

		
		Scanner scr= new Scanner(System.in);
		System.out.println("enter username");
		uid=scr.nextLine();
		System.out.println("enter password");
		pass=scr.nextLine();
		
		
		login();
		signup();
		
		
		Info info= new Info();
		
		System.out.println("Enter name");
		String name= scr.nextLine();

		System.out.println("Enter emailid");
		String s=scr.nextLine();
		EmailID emailId= new EmailID();
		boolean b= emailId. isValid(s);
		
			if(b)
			{
				System.out.println(s);
			}
			else
			{
				System.out.println("Not a valid email id!!");
			}	
				
		System.out.println("Enter pass");
		String pass= scr.nextLine();
		System.out.println("Enter date");
		String date= scr.nextLine();
		System.out.println("Enter country");
		String country= scr.nextLine();
		System.out.println("Enter state");
		String state= scr.nextLine();
		
		Info info1= new Info();
		info1.setName(name);
		info1.setPass(pass);
		info1.setDate(date);
		info1.setCountry(country);
		info1.setState(state);	
			
		register();
		

		System.out.println("Enter name");
		String name1=scr.nextLine();
		System.out.println("Enter pass1");
		String pass1= scr.nextLine();
		System.out.println("Enter opendate");
		String date1= scr.nextLine();
		System.out.println("Enter country");
		String country1= scr.nextLine();
		System.out.println("Enter state");
		String state1= scr.nextLine();
		System.out.println("Enter id");
		int id= scr.nextInt();
		System.out.println("Enter amount");
		float amount= scr.nextInt();
		System.out.println("Enter mobile no.");
		int mobile= scr.nextInt();
		
		Entry entry= new Entry();
		entry.setName1(name1);
		entry.setPass(pass1);
		entry.setOpendate(date1);
		entry.setCountry(country1);
		entry.setState(state1);
		entry.setId(id);
		entry.setAmount(amount);
		entry.setMobile(mobile);
		
		entry();
	}
	
	

	private static void login() {
		
		ActionListener a= new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(uid)  && e.getSource()==pass){
						// go to welcome page
				}
				else
				{
					System.out.println("Incorrect username or password");
				}
				
			}

		};
	}

	private static void signup() {
		
			// go to info page
	}


	public static void register(){
			
			// go to welcome page
	}

	public static void entry(){
		
		//add new entry
	}
	
	public static void search(){
		
		// search for the entry
	}
	
	public static void delete(){
		
		//delete existing entry
	}
	
	public static void update(){
		
		// update existing entry
	}
}



