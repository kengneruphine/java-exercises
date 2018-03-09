import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class CreateTextFile {
	
	private Formatter output; // object of the class formatter to output data to the transaction file
	
	//method use to open a text file called trans.text
	public void openFile() {
		try {
		output= new Formatter("trans.txt"); // open file
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//method to add data to the file
	
	public void addRecords() {
		//create an instance of the transaction class
		TransactionOrder transOrder= new TransactionOrder();
		Scanner input= new Scanner(System.in);
		
		System.out.printf("%s %s", "Enter account number","enter transaction amount");
		
		//read values still end of file
		while(input.hasNext()) {
			transOrder.setAccountNumber(input.nextInt());
			transOrder.setTransactionAmount(input.nextDouble());
			
			output.format("%d %.2f \r\n", transOrder.getAccountNumber(),transOrder.getTransactionAmount());
		
			System.out.printf("%s %s","Enter account number," ,"Enter transaction amount");
		}
	}
	public void closeFile() {
		if(output !=null)
			output.close();
	
	}

}
