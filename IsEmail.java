import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsEmail {

	public static Boolean check (File file){
		Boolean bool = false;
	    String email = file.getName();
	    Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
	    Matcher mat = pattern.matcher(email);
	
	    if(mat.matches()) {
	       return true;
	    } 
	    return bool;
	}
}