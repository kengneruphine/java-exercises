import java.io.File;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch {
	private static Scanner oldMaster;
	private static Scanner transactionFile;
	private static Formatter newMaster;
	private static Formatter logFile;
	private static TransactionOrder transaction;
	private static Account account;
	
	//this method create an instance of the class transactionorder and account
	public FileMatch() {    
		transaction = new TransactionOrder();
		account = new Account();
	}
	
	// this method is to open the file for writing and reading
	public void openFiles() {
		try {
			//create an input stream object for the textfile oldmast.text
			oldMaster= new Scanner (new File("oldmast.txt"));
			transactionFile = new Scanner(new File("trans.txt"));
			
			//create an instance formatter object to write to a master file
			newMaster= new Formatter ("newmast.txt");
			logFile = new Formatter("log.txt");
		}catch(Exception exception) {
			System.err.println(exception.getMessage());
		}
	}

	// this method read the data from the file trans.txt,oldmast.txt ,process the data and write the two file newmast.txt and logfile.txt
	public void processFiles() {
		int transactionAccountNumber;
		int accountNumber;
		
		try {
			//get a transaction record and its account number
			transaction = getTransactionOrder();
			 if(transaction ==null)
				 return;
			 transactionAccountNumber=transaction.getAccountNumber();
			
			 //get an account record and its account number
			     account=getAccount();
			     if(account ==null)
			    	 return;
			        accountNumber=account.getAccountOne();
		      
			   // case-1:if account number is not null
			        while(accountNumber != 0) {
			        	while (accountNumber < transactionAccountNumber) {
			        		//there is no transaction for this account
			        		newMaster.format("%d %s %s %.2f\r\n", account.getAccountOne(),
			        				account.getFirstName(),account.getLastName(),account.getBalance());
			        		// get a new account
			        		account= getAccount();
			        		
			        		  if(account !=null)
			        			  return;
			        		  accountNumber=account.getAccountOne();
			        		  }
			        	
			  // case 2:if there is a transaction for the account
			      if(accountNumber==transactionAccountNumber) {  	
			    	  //combine transaction record and account record
			    	   account.combine(transaction);
			      //write to the newmaster file
			      newMaster.format("%d %s %s %.2f \r\n",account.getAccountOne(),account.getFirstName()
			    		  ,account.getLastName(),account.getBalance());
			      
			      //get a new transaction
			      transaction= getTransactionOrder();
			        if(transaction != null)
			        	return;
			        transactionAccountNumber=transaction.getAccountNumber();
			        
			        //get a new account
			        account=getAccount();
			        
			        if(account !=null)
			        	return;
			        	
			         accountNumber= account.getAccountOne(); 	
			      }
			      
		// case 3: if transaction account number is less than account number then there is no account in the oldmast.txt
			      
			      while(transactionAccountNumber<accountNumber) {
			    	  //there is no account for this transaction
			    	  logFile.format("%s %d\n","unmatched transaction for account number",transactionAccountNumber);
			    	  
			    	  //get a new transaction
			    	  transaction=new TransactionOrder();
			    	  if(transaction !=null)
			    		  return;
			    	  transactionAccountNumber= transaction.getAccountNumber();
			      }
			    }
               }
		catch(IllegalFormatException formatException) {
			System.err.println(formatException.getMessage());
			System.exit(1);
		}
		}  // end of processfile method
	
	public void closeFiles() {
		try {
			if(transactionFile!=null)
				transactionFile.close();
			if(newMaster !=null)
				newMaster.close();
			if(oldMaster !=null)
				oldMaster.close();
			if(logFile !=null)
				logFile.close();
		}catch(Exception exception) {
			System.err.println("Error closing the files");
			System.exit(1);
		}
	}
	// get a transaction record
	private TransactionOrder getTransactionOrder() {
		try {
			if (transactionFile.hasNext()) {
				transaction.setAccountNumber(transactionFile.nextInt());
				transaction.setTransactionAmount(transactionFile.nextDouble());
			}
			else
			{ 
				 while(oldMaster.hasNext()) {
					 account.setAccountOne(oldMaster.nextInt());
					 account.setFirstName(oldMaster.next());
					 account.setLastName(oldMaster.next());
					 account.setBalance(oldMaster.nextDouble());
					 
					 //store in new master
					  
					 newMaster.format("%d %s %s %.2f",account.getAccountOne(),account.getFirstName()
							 ,account.getLastName(),account.getBalance());
				 }	
			}
		} catch(IllegalFormatException formatException) {
			System.err.println(formatException.getMessage());
			System.exit(1);
		}
		return null;
	}
	
	//get a account record
	 private Account getAccount() {
		 try {
			 if(oldMaster.hasNext()) {
				 // read data from oldmast.txt
				 account.setAccountOne(oldMaster.nextInt());
				 account.setFirstName(oldMaster.next());
				 account.setLastName(oldMaster.next());
				 account.setBalance(oldMaster.nextDouble());
				   return account;
				 
			 }
			 else {
				 logFile.format("%s %d\n","Unmatched transaction record for account number",transaction.getAccountNumber());
			 
				 while(transactionFile.hasNext()) {
					 transaction.setAccountNumber(transactionFile.nextInt());
					 transaction.setTransactionAmount(transactionFile.nextDouble());
				 }
			 }
		 }catch(IllegalFormatException formatException) {
			 System.err.println(formatException.getMessage());
			 System.exit(1);
		 }
		 return null;
	 }
	}
