
public class Account {
	private int account;
	private String fistName;
	private String lastName;
	private double balance;
	private String firstName;

	public Account() {
		this(0,"","",0.0);
	}
	
	public Account(int account, String firstName, String lastName,double balance) {
		this.account=account;
		this.firstName=firstName;
		this.lastName=lastName;
		this.balance=balance;
	}
	public void setAccountOne(int account) {
		this.account=account;
	}
	public int getAccountOne() {
		return account;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	
	//combine method
	public void combine(TransactionOrder transObject) {
		balance = balance + transObject.getTransactionAmount();
		}


}




