import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Choices { 
	//Create option list, display options list
	static void list(ArrayList<File> dirs) {
		int count = 1;
		System.out.println("Send which email(s)?\n");
		for (File f: dirs) {
			System.out.println("|" + count + "| " + f.getName());
			count++;
		}
		System.out.println("|" + count + "| send all");
	}
	
	//get user input, return choice
	static int choice (ArrayList<File> dirs) {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		return choice;
		}
	}


