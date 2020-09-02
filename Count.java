public class Count {
  public static void down(){
    for (int i = 10; i > 0; i--)
    try {
        Thread.currentThread();
	    if (i > 9){
	        System.out.print("\r\t\tProgram will shutdown in " + i + " seconds.");
			Thread.sleep(1000);
	      } else {
	        System.out.print("\r\t\tProgram will shutdown in 0" + i + " seconds.");
			Thread.sleep(1000);
	      }
	    } catch (Exception e){
	    System.out.println(e);
    }
  }
}
