
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	
	static String DIRECTORY;
	File folder_name;
	
	public Menu() {
		DIRECTORY = System.getProperty("user.dir");
		folder_name = new File(DIRECTORY + "/files");
		if (!folder_name.exists()) {
		    folder_name.mkdirs();
		}
		System.out.println("DIRECTORY :" + folder_name.getAbsolutePath() + "\n\n");
		}

	
	void primaryMenu() { 
		
		System.out.println("\t\t Main Menu\n");
		System.out.println("\t 1. Show the list of Files");
		System.out.println("\t 2. Perform Business Level Operation");
		System.out.println("\t 3. Close");
		
		String option = sc.nextLine();
		
		try {
			switch (option) {
			case "1":{
				showfiles();
				primaryMenu();
			}
			case "2":{
				secondaryMenu();
				break;
			}
			case "3":{
				System.out.println("\t\t Thank You");
				break;
				}
			default:{
				primaryMenu();
			}
		}
			
		} catch (Exception e) {
			System.out.println("Please enter 1, 2 or 3");
            primaryMenu();
		}
		
	}
	

    void showfiles() {
	try {
		if(folder_name.list().length==0) {
			System.out.println("\t\t Folder is empty \n\n");
		}
		else {
			String[] list = folder_name.list();
			System.out.println("The Files in" + folder_name + " are listed below : ");
			Arrays.sort(list);
			for (String str: list) {
				System.out.println(str);
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	void secondaryMenu() {
		
		System.out.println("\t\t Select any of the following option\n");
		System.out.println("\t a. Add a File");
		System.out.println("\t b. Delete a File");
		System.out.println("\t c. Search the file");
		System.out.println("\t d. Go back to Main Menu");		
		     
		        try{
		            @SuppressWarnings("resource")
					Scanner scanner = new Scanner(System.in);
		            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
		            char option = input[0];

		            switch (option){
		                case 'a' : {
		                    System.out.print("↳ Adding a file...Please Enter a File Name : ");
		                    String filename = scanner.next().trim().toLowerCase();
		                    addFile(filename);
		                    break;
		                }
		                case 'b' : {
		                    System.out.print("↳ Deleting a file...Please Enter a File Name : ");
		                    String filename = scanner.next().trim();
		                    deleteFile(filename);
		                    break;
		                }
		                case 'c' : {
		                    System.out.print("↳ Searching a file...Please Enter a File Name : ");
		                    String filename = scanner.next().trim();
		                    searchFile(filename);
		                    break;
		                }
		                case 'd' : {
		                    System.out.println("Going Back to MAIN menu");
		                    primaryMenu();
		                    break;
		                }
		                default : System.out.println("Please enter a, b, c or d");
		            }
		            secondaryMenu();
		        }
		        catch (Exception e){
		            System.out.println("Please enter a, b, c or d");
		            secondaryMenu();
		        }
		    }

       void addFile(String filename) throws IOException {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equalsIgnoreCase(file)) {
                System.out.println("File " + filename + " already exists at " + folder_name);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+filename+" added to "+ folder_name);
    }

    void deleteFile(String filename) {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file) && filepath.delete()) {
                System.out.println("File " + filename + " deleted from " + folder_name);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String filename) {
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file)) {
                System.out.println("FOUND : File " + filename + " exists at " + folder_name);
                return;
            }
        }
        System.out.println("File Not found (FNF)");
    }
		
	
	
public static void main(String[] args) {
	
		
	System.out.println("******** Welcome to LockedMe.com ********");
	System.out.println("****** Developer : Md Afzal Haroon ******\n\n");
	
	Menu mainmenu = new Menu();
	mainmenu.primaryMenu();
}
	
}

