package clientPackage;

import java.io.IOException;

public class Main {
	public static void main(String [] args) throws IOException{
		ATM atm = new ATM();
		atm.login("sabik", "abc123");
		atm.getCashValue();
		atm.setCashValue(1000.0);
	}
}
