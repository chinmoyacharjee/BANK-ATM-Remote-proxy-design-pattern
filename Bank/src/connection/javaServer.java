package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import bank.Bank;
import bank.IBank;
import bank.User;

public class javaServer {
	ServerSocket serverSocket;
	PrintStream streamToClient;
	BufferedReader streamFromClient;
	Socket fromClient;

	private ArrayList<User> users;
	private IBank bank;

	public javaServer(ArrayList<User> users) {

		this.users = users;
		System.out.println("Welcome to XYZ Bank");
		init();
		createSocket();
		eastablishConnection();
		communication();

	}

	private void createSocket() {
		try {
			serverSocket = new ServerSocket(80);

		} catch (Exception e) {
			System.out.println("Socket could not be created" + e);
		}
	}

	private void eastablishConnection() {

		try {
			fromClient = serverSocket.accept();
			streamFromClient = new BufferedReader(new InputStreamReader((fromClient.getInputStream())));
			streamToClient = new PrintStream(fromClient.getOutputStream());
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	private void communication() {
		streamToClient.println("Welcome to XYZ Bank");
		String username = retreieveLoginInfo();
		int index = retrieveCashValueInfo();
		retrieveSetCashValueInfo(index, username);

	}

	private void retrieveSetCashValueInfo(int index, String username) {

		try {
			
			double cash = Double.parseDouble(streamFromClient.readLine());
			bank.setCashValue(cash, index);

			streamToClient.println(bank.getCashValue(index));

			System.out.println(username + " just withdrawed some money");
		
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private int retrieveCashValueInfo() {
		int index = -1;
		try {

			index = Integer.parseInt(streamFromClient.readLine());
			streamToClient.println(bank.getCashValue(index));

		} catch (Exception e) {

			e.printStackTrace();
		}
		return index;

	}

	private String retreieveLoginInfo() {

		try {

			String userInfo = streamFromClient.readLine();

			String username = userInfo.split("\\s+")[0];
			String password = userInfo.split("\\s+")[1];

			int index = bank.login(username, password);

			System.out.println(username + " Just logged in");

			streamToClient.println(index);

			return username;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "";

	}

	private void init() {
		bank = new Bank(users);
	}

}