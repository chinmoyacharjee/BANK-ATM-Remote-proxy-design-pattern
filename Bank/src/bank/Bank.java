package bank;

import java.util.ArrayList;

public class Bank implements IBank {
	private ArrayList<User> users;

	public Bank(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public int login(String username, String password) {
		int index = -1;
		for(int i = 0; i< users.size();i++){
			if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
				index =  i;
			}
		}return index;
	}

	@Override
	public double getCashValue(int index) {

		return users.get(index).cashValue;
	}

	@Override
	public void setCashValue(double cash, int index) {

		users.get(index).cashValue -= cash;

	}

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void f1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void f2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void f3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void f4() {
		// TODO Auto-generated method stub

	}

	@Override
	public void f5() {
		// TODO Auto-generated method stub

	}

}
