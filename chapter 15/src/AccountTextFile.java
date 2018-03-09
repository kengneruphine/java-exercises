import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class AccountTextFile {
   private Formatter output;
   
   public void openFile() {
	   try {
		   output=new Formatter("oldmast.txt");
	   } catch(FileNotFoundException e) {
		   System.out.println(e.getMessage());
	   }
   }
   
   public void addRecord() {
	   Account account=new Account();
	   Scanner input = new Scanner(System.in);
	   
	   System.out.printf("%s","Enter account number,firstname,lastname,balance");
	   
	   while(input.hasNext()) {
		   account.setAccountOne(input.nextInt());
		   account.setFirstName(input.next());
		   account.setLastName(input.next());
		   account.setBalance(input.nextDouble());
		   
		   output.format("%d %s %s %.2f\r\n", account.getAccountOne(),account.getFirstName(),account.getLastName(),account.getBalance());
		   System.out.printf("%s","Enter account number,firstname,lastname,balance");
		   
	   }
   }
   
   public void closeFile() {
	   if(output!=null)
		   output.close();
   }
}
