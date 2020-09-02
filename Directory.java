import java.io.File;
import java.util.ArrayList;

public class Directory {
	
	public static File current () {
		String curDir = new File("Directory.class").getAbsolutePath();
		curDir = curDir.substring(0, curDir.length() - 15);
		File f = new File(curDir); //current directory
		return f;
	}
	public static ArrayList<File> dirLister () {
		ArrayList<File> output = new ArrayList<File>();
		File[] dir = current().listFiles();
		for (File file : dir)
				if (IsEmail.check(file) == true)
					output.add(file);
		return output;
	}
	public static File[] files (File dir) {
		File[] files = dir.listFiles();
		return files;
	}
	
	public static void delete(File f) {
		for (File i : f.listFiles()) {
			i.delete();
			System.out.println("\tDeleted: " + i.getName());
			f.delete();
			System.out.println("\n\tDeleted: " + f.getName() +"\n");
		}
	}
}