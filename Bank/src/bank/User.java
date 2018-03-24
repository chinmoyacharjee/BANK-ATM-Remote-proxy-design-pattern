package bank;

public class User {
	public String username; 
	public String password;
	public double cashValue;
	public User(String username, String password, double cashValue){
		this.username = username;
		this.password = password;
		this.cashValue = cashValue; 
	}
}
