package com.lockedme.operations;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.lockedme.ascending.Ascending;
import com.lockedme.userdetails.UserDetails;
import java.util.Arrays;



public class FileOperations {
	
	private static Scanner input;
	private static Scanner readDbFile;
	private static UserDetails details;
	private static PrintWriter collect;
	static String Directory;
	static File createFile;
	
	public static void welcomeMessage() throws InterruptedException {
		System.out.println("||-------------------------------------||");
		System.out.println("||	                               ||");
		System.out.println("||     WELOCOME TO LOCKEDME.COM        ||");
		System.out.println("|| A VIRTUAL KEY FOR YOUR REPOSITORIES ||");
		Thread.sleep(2000);
		System.out.println("||   DEVELOPED BY - HEMACHANDIRAN T    ||");
		System.out.println("||	                               ||");
		System.out.println("||-------------------------------------||");
	    }
	
	
	// Creating Directory
	public static void dirCreate() {
		Directory = System.getProperty("user.dir");
		createFile = new File(Directory+"/Database");
		if(!createFile.exists()) 
			createFile.mkdirs();
		System.out.println("File Path " + Directory);
	}
	
	//Sign Up
	public static void signUp() throws IOException {
			
			System.out.println("==========================================");
			System.out.println("*   WELCOME TO REGISTRATION PAGE	*");
			System.out.println("==========================================");
		try {	
			System.out.println("Please Enter the Required Credientials for Registration...");
			System.out.print("Enter your Username: ");
			String username = input.next();
			details.setUserName(username);
			
			System.out.print("Enter your Password : ");
			String password = input.next();
			details.setPassword(password);
			
			System.out.println("User registered successfully");
			
			collect.println(details.getUserName());
			collect.println(details.getPassword());
			
			collect.close();
			mainMenu();
		   }catch(Exception e) {
			   signUp();
		   }
		   }
	
	//Sign In
	public static void signIn() throws Exception {
			System.out.println("*============================================*");
			System.out.println("*            WELCOME TO LOGIN PAGE           *");
			System.out.println("=============================================*");
		try {	
			System.out.println("Please Enter the Required Credientials to Proceed Further...");
			System.out.print("\nEnter Username : ");
			String inname = input.next();
			//System.out.println("Enter the Password 2-Times below: ");
			boolean found = false;
			while(readDbFile.hasNext() && !found) {
				if(readDbFile.next().equals(inname)) {
					System.out.print("Enter Password : ");
					String inpassword = input.next();
					if(readDbFile.next().equals(inpassword)) {
						System.out.println("User Logged in Successfully!\n");
						found = true;
	                dirCreate();
	                showMenu();
					}
				}
				}if(!found) {
					System.out.println("User not Found");
					System.out.println("3.exit");
					Scanner sc = new Scanner(System.in);
					int chance = sc.nextInt();
					switch(chance) {
					case 3:{ break; }
					default:{ System.out.println("Invalid Input"); mainMenu(); }
					}
				}
		}catch (Exception e) {
			
			mainMenu();
		}
			}
	
	//Main menu
	public static void mainMenu() throws  Exception {
		System.out.println("Loading Main Menu..........");
		Thread.sleep(1000);
		System.out.println("==========================================");
		System.out.println("*         WELCOME TO MAIN MENU	        *");
		System.out.println("==========================================");
		
		System.out.println("\nSelect an option\n 1->Sign up\n 2->Sign in\n 3->Exit");
	try {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Choice : ");
		int Option = sc.nextInt();
		
		switch(Option) {
		case 1:{ signUp(); }
		
		case 2:{ signIn(); }
		
		case 3:{ exitScreen();
				System.exit(1);}
		
		default:{ System.out.println("Invalid Input, Try Again"); mainMenu(); }
		}
		}catch(Exception e) {
			System.out.println("Invalid Input, Try Again");
			mainMenu();
		}
		
	    }
	
	
	
	// Show Menu
	public static void showMenu() throws Exception {
		System.out.println(" ");
		System.out.println("Entering into Locker..........");
		Thread.sleep(1000);
		System.out.println("==========================================");
		System.out.println("*   ENTERED INTO LOCKER	*");
		System.out.println("==========================================");
		System.out.println(" ");
		System.out.println("\n1->List Files in Directory\n2->Add, Search or Delete File in the Directory\n3->Show files in Ascending order\n4->Exit");
		try {
		System.out.print("Enter your Choice : ");
		Scanner sc = new Scanner(System.in);
		int option1 = sc.nextInt();
		switch(option1) {
		case 1:{ listFiles(); }
		try {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("\n1->Return to Locker\n->Exit");
		System.out.print("Enter your Choice : ");
		int op = sc1.nextInt();
		switch(op) {
		case 1 :{ showMenu(); }
		case 2 :{ break; }
		default:{ System.out.println("Invalid Input"); showMenu();}
		}
		}catch(Exception e) {
			System.out.println("Invalid Input"); showMenu();
		}
		case 2:{ showOperations(); }
		
		case 4: { exitScreen();
			   System.exit(option1); }
		case 3 : {
			Ascending.ascendingOrder();
			showMenu();

		}
		
		default:{ System.out.println("Invalid Input"); showMenu();}
		}}catch(Exception e) {
			showMenu();
		}
		
	}
	public static void exitScreen() {
			
		System.out.println("*============================================*");
		System.out.println("*     THANK YOU FOR VISITING LOCKEDME.COM    *");
		System.out.println("=============================================*");
			System.out.println("\n\n");
			
			
		}

	
	//Listing Files
	public static void listFiles() {
	try {
		if(createFile.list().length==0) {
			System.out.println("Folder is empty");
		}else {
		System.out.println("\nThe Files Available in " + Directory + " are : ");
		String[] lists = createFile.list();
		Arrays.sort(lists);
		for(String view : lists) {
			System.out.println(view);
		}
		}
	}catch(Exception e) {
		e.getMessage();
	}
	}
	
	//Show operations - after login
	public static void showOperations() throws IOException {
		
		System.out.println("\n1.Add New File\n2.Delete Existing File\n3.Search File\n4.Return to Locker");
		try {	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Choice : ");
		int option3 = sc.nextInt();
		
		switch(option3) {
		
		case 1:{ System.out.println("Enter File Name : ");
		Scanner sc2 = new Scanner(System.in);
		String Name = sc2.next().trim().toLowerCase(); 
		addFile(Name);
		showMenu();
		break;
		}
			case 2:{ System.out.println("Enter File Name to Delete : ");
			Scanner sc4 = new Scanner(System.in);
			String name2 = sc4.next().trim();
			deleteFile(name2);
			showMenu();
			break;
			}
			case 3:{System.out.println("Enter the File Name to Check Status : ");
			Scanner sc5 = new Scanner(System.in);
			String sc7 = sc5.next().trim();
			searchFile(sc7);
			showMenu();
			break;
			}
			case 4:{ showMenu();}
			default:{ System.out.println("Invalid Input");	}
			showOperations();
			break;
		}
	}catch(Exception e) {
		System.out.println("Invalid Input");
		showOperations();
	}
	}
	
	
	// Adding file
	public static void addFile(String name) throws IOException {
		
		File filec = new File(createFile+"/"+name);
		String list1[] = createFile.list();
		for(String namecheck : list1) {
			if(name.equalsIgnoreCase(namecheck)) {
				System.out.println("File already exists in the folder");
			return;
			}
		}
		filec.createNewFile();
		boolean res = filec.createNewFile();
		if(!res) System.out.println("File Created Successfully");
		
	}
	
	
	//Delete file
	public static void deleteFile(String name) {
		File file = new File(createFile+"/"+name);
		String[] list = createFile.list();
		for(String view1 : list) {
			if(name.equals(view1) && file.delete()) {
				System.out.println("File Deleted Successfully");
				return;
			}
		}
		System.out.println("File Not Found");
	}
	
	
	//Search File
	public static void searchFile(String Name) {
		new File(createFile+"/"+Name); 
		String[] list = createFile.list();
		for(String str : list) {
			if(Name.equals(str)) {
				System.out.println("File Found");
				return;
			}
		}
		System.out.println("File Not Found");
	} 
	
	
	public static void tools() throws IOException{
		File file = new File("UsersCredientials.txt");
		file.createNewFile();
		try {	
			input = new Scanner(System.in);
			readDbFile = new Scanner(file);
			file.createNewFile();
			collect = new PrintWriter(new FileWriter(file,true));
			details = new UserDetails();
		}catch(Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	    }
        }

