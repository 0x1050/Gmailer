import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Streams {
	public static String get(String text){
	String content = " ";
	try {
		content = new String (Files.readAllBytes(Paths.get(text)));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return content;
	}
}
