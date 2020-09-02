import java.io.File;
import java.util.ArrayList;

public class SendEmail {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<File> dirsList = Directory.dirLister();
		System.out.println("Email app v2.0\n");
		if (dirsList.size() == 0)
			System.out.println("\n\t\t\tNo emails to send!\n");
		else {
		Choices.list(dirsList);
		int choice = Choices.choice(dirsList);
		

		if (choice == -2) 
			System.out.println("Invalid entry. Quitting program.");
		else
			Email.paid(dirsList, choice);
		
		//Count.down();
		}
	}
}
