
public class TestAccount {
	public static void main(String[] args) {
		AccountTextFile accountFile = new AccountTextFile();
		
		accountFile.openFile();
		
		accountFile.addRecord();
		
		accountFile.closeFile();
	}

}
