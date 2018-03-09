import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TransactionOrder {
	private int accountNumber;
	private double transactionAmount;
	
    public TransactionOrder() {
    	this(0,0);
    }	
	
   public TransactionOrder(int accountNumber,double transactionNumber) {
	   this.accountNumber=accountNumber;
	   this.transactionAmount=transactionAmount;
   }
   
   public void setAccountNumber(int accountNumber) {
	   this.accountNumber=accountNumber;
   }
   public int getAccountNumber() {
	   return accountNumber;
   }
	
   public void setTransactionAmount(double transactionAmount) {
	   this.transactionAmount=transactionAmount;
   } 
   public double getTransactionAmount() {
	   return transactionAmount;
   }
}
