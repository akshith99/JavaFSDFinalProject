package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {

	static final String projectFilesPath = "D:\\SimpliLearn\\PhaseOne\\FinalProject\\LockedMeFiles";
	
	/**
	 * This method will display the menu for end users
	 */
	public static void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("\tWelcome to LockedMe.com Secure App");
		System.out.println("\tDeveloped by: Akshith Krishnan");
		System.out.println("*******************************************");
		System.out.println("\t1. Display all files");
		System.out.println("\t2. Add a new file");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search File");
		System.out.println("\t5. Exit");
		System.out.println("*******************************************");
	}
	
	/**
	 * This method will retrieve all the files
	 */
	public static void getAllFiles() {
		
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length>0) {
			System.out.println("FILES LIST IS BELOW:\n");
			for(var l:listOfFiles) {
				System.out.println(l.getName());
			}
		}
		else {
			System.out.println("Folder is empty");
		}
		
	}
	
	/**
	 * This method will read file details from user and creates file
	 */
	public static void createFiles() {
		
		try {
			// Variable declaration
			Scanner obj = new Scanner(System.in);
			String fileName;
			
			//Read file name from user
			System.out.println("Enter the file name:");
			fileName = obj.nextLine();
			
			int linesCount;
			System.out.println("Enter how many lines in the file:");
			linesCount = Integer.parseInt(obj.nextLine());
			
			FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
			
				//Read line by line from user
			for(int i=1;i<=linesCount;i++) {
				System.out.println("Enter the file line:");
				fw.write(obj.nextLine()+"\n");
			}
				System.out.println("File created successfully");
				fw.close();
		}
		catch(Exception Ex){
			
		}
	}
	
	/**
	 * This method will take file name as parameters and checks if
	 * it is present in the project folder or not
	 * @param fileName String
	 * @return boolean
	 */
	public static boolean checkFileExists(String fileName) {
		//Get all files name into a list
		ArrayList<String> allFilesNames = new ArrayList<String>();
		
		File folder = new File(projectFilesPath);
		
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles.length>0)
		{
			for(var l:listOfFiles) {
				allFilesNames.add(l.getName());
			}
		}
		return allFilesNames.contains(fileName);
	}
	
	/**
	 * This method checks if the file exists and deletes the file from the folder
	 */
	public static void deleteFiles() {
		
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file to be deleted:");
			fileName = obj.nextLine();
			File f = new File(projectFilesPath+"\\"+fileName);
			
			if(checkFileExists(fileName))
			{
				f.delete();
				System.out.println("File deleted successfully");
			}
			else {
				System.out.println("File doesn't exist");
			}
		}
		catch(Exception Ex) {
			System.out.println("Unable to delete file. Please contact: admin@lockedme.com");
		}
	}
	
	/**
	 * This method is used to search the files in the folder
	 */
	public static void searchFiles() {
		
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name:");
			fileName = obj.nextLine();
			
				if(checkFileExists(fileName))
				{
					System.out.println("The file is available");
				}
				else {
					System.out.println("The file is not available");
				}
		}
		catch(Exception Ex) {
			
		}
	}
}