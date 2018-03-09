
public class FileMatchTest {
	public static void main(String[] args) {
		//create an instance of the file match
		FileMatch application= new FileMatch();
		
		application.openFiles();
		
		application.processFiles();
		
		application.closeFiles();
		
	}

}
