import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import java.io.File;

public class Email {
	public static void paid(ArrayList<File> dirList, int choice) {
	choice--;
    //These values should be grabbed from a file instead of
    //being hard coded
	final String from = "****@gmail.com";
	final String user = "****";
	final String pass = "****";

	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.port", "587");

	//Get session object
	Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, pass);
		}
	});
	//Create and initialize transport
	System.out.print("\n\tCreating transport");
	try {
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", "42ndstphotos", "IL0vePhotos84");
		System.out.println("...........Success!\n");
		if (choice < 0 || choice > dirList.size()) {
			System.out.println("Invalid entry, quitting program");
		} else if (choice == dirList.size()) { //Send all
			for (File d : dirList) {
				Message message = EmailFuncts.create(d, session, from);
				//Send email
				transport.sendMessage(message, message.getAllRecipients());
				System.out.println("\nEmail successfully sent, deleting files from hard drive\n");
				Directory.delete(d);
			}

		} else { //Send selected
			Message message = EmailFuncts.create(dirList.get(choice), session, from);
			//Send email
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("\nEmail successfully sent, deleting files from hard drive\n");
			Directory.delete(dirList.get(choice));
			}
		transport.close();
	} catch (MessagingException e) {
		System.out.println(e);
	}
	}
}
