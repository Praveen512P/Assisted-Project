package com;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Lockermepvt {
	public static void main(String[] args) throws IOException {
		Lockermepvt l=new Lockermepvt();
		BusinessOperation obj=l.new BusinessOperation();
		int ch=0, choice=0;
		Scanner sc =new Scanner(System.in);		
		System.out.println("\t Welcome to  Locker Pvt Ltd Company \n");
				
		while(true)
		{
			System.out.println("Please choose Generic Features of Operations :");
			System.out.println("1. List Current Files in Ascending Order");
			System.out.println("2. Business Operation Included");
			System.out.println("3. Close Application");
			try{    
				ch = sc.nextInt();
			}
			catch(Exception e)  
             {  
              System.out.println("Null Exception occurred");  
             }         
			
			switch(ch)
			{
			case 1: 
				obj.listFiles();
				    break;
			case 2:
				
					System.out.println("Please choose Business operation Included :");
					System.out.println("1. Add a File");
					System.out.println("2. Delete a File");
					System.out.println("3. Search for a File");
					try{    
						 choice = sc.nextInt();
					}
					catch(Exception e)  
	                  {  
	                   System.out.println("Null Exception occurred");  
	                  }          
					switch(choice)
					{
					case 1:						
						System.out.println("Enter the name of a file to be created: ");
						String fileCreate = sc.next();						
						obj.createFile(fileCreate);
						break;
						
					case 2:
						
						System.out.print("Enter the name of a file to be deleted: ");
						String fileDelete = sc.next();											
						obj.deleteFile(fileDelete);
						break;
					case 3:						
						System.out.println("Enter the name of a file to be searched: ");
						String fileSearch = sc.next();						
						obj.searchFile(fileSearch);
						break;
						
				default:
						System.out.println("\n OOPS,INVALID \n");
						break;
				}			
					break;
			case 3:				
				sc.close();
				System.out.println("\n\n Close Application, Thank you!!! See You Back \n");
				System.exit(1);
				break;
			
			default:
				System.out.println("\n Oops! Invalid Input \n");
				break;
			
			}
		}
		
	}
public class BusinessOperation {
		 public  String[] sort_sub(String array[], int size){
			 String temp = "";
			for(int i=0; i<size; i++){
				for(int j=1; j<(size-i); j++){
					if(array[j-1].compareToIgnoreCase(array[j])>0){
						temp = array[j-1];
						array[j-1]=array[j];
						array[j]=temp;
					}
				}
			}
			return array;
		}
				
public  void listFiles() 
{
			int fileCount = 0;
		    ArrayList<String> filenames = new ArrayList<String>();	
			File directoryPath = new File("D:\\fileproblem\\");
			File[] listOfFiles = directoryPath.listFiles();
			System.out.println("Files in ascending Order: ");
			for(File ff:listOfFiles)
			{
				System.out.println(ff.getName());
			}
			
			
			}
		
public  void deleteFile(String fileToBeDeleted) {
			
			File file = new File( "D:\\fileproblem"+ "\\" + fileToBeDeleted );
			
			if(file.exists()) {
				if ( file.delete() ) {
					System.out.println("File get deleted successfully!");
				}
			} else {
				System.out.println("Sorry, File not get deleted !! File Not Found");
			}
		}
		
public  void searchFile(String fileToBeSearched) {
		        
			File file = new File( "D:\\fileproblem"  + "\\" + fileToBeSearched );			
			if(file.exists()) {
				System.out.println("File found!");
			} else {
				System.out.println("Sorry, File is not here !! File Not Found");
			}	PrintWriter pw;  
	        try {  
	            pw = new PrintWriter(fileToBeSearched); 
	            pw.println("saved");  
	        }  
	        catch (FileNotFoundException e) {  
	              
	            System.out.println(e);  
	        } 
		}
public  void createFile (String fileToBeCreated) {
			File file = new File( "D:\\fileproblem" + "\\" + fileToBeCreated );
			
			try {
				if (file.createNewFile() ) {
					System.out.println("File get Created successfully !");
				} else {
					System.out.println("File already exists :(");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

}
}
