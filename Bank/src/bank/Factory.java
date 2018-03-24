package bank;

import java.util.ArrayList;

import connection.javaServer;

public class Factory {
	ArrayList<User> users;
	public Factory(){
		initUser();
		new javaServer(users);

		
	}
	private void initUser(){
		users =  new ArrayList<User>();
		users.add(new User("chinmoy", "abc123", 5000.00));
		users.add(new User("ratul", "abc123", 5020.00));
		users.add(new User("sabik", "abc123", 5040.00));
		users.add(new User("shaan", "abc123", 5060.00));
		users.add(new User("jwel", "abc123", 5080.00));
		
	}
}
