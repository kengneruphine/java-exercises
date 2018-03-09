
public class TestProgram {
	public static void main(String[] args) {
		CreateTextFile transFile = new CreateTextFile();
		
		
		transFile.openFile();
		
		transFile.addRecords();
		
		transFile.closeFile();
	}

}
