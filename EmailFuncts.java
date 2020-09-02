import java.io.File;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailFuncts {
	static  Message create(File d, Session session, String from) {
		String subjectText = Streams.get("emailSubject.txt");
		String emailText = Streams.get("emailText.txt");
		try {
			
			
			System.out.println("--------- Creating email to " + d.getName() + " ---------\n");
			String to = d.getName();
			//Compose Email
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setSubject(subjectText);
			//Create bodyPart
			BodyPart mbp = new MimeBodyPart();
			mbp.setText(emailText);
			//Create multiPart
			Multipart multi = new MimeMultipart();
			multi.addBodyPart(mbp);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			//add discount
			BodyPart discount = new MimeBodyPart();
			String discountPath = Directory.current() + "\\discount.jpg";
			DataSource dsrc = new FileDataSource(discountPath);
			discount.setDataHandler(new DataHandler(dsrc));
			discount.setFileName("discount.jpg");
			multi.addBodyPart(discount);
			message.setContent(multi);
			System.out.println("\tAdding files\n");
			System.out.println("\tAdded contact");
			File[] f = Directory.files(d);
			
			for (File i: f) {
				mbp = new MimeBodyPart();
				String fileName = i.getAbsolutePath();
				DataSource src = new FileDataSource(fileName);
				mbp.setDataHandler(new DataHandler(src));
				mbp.setFileName(i.getName());
				multi.addBodyPart(mbp);
				message.setContent(multi);
				System.out.println("\n\t" + i.getName());
			}
			return message;
			} catch (MessagingException e) {
				throw new RuntimeException(e);		
		}	
	}

}
