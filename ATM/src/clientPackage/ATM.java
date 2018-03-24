package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ATM {
	private Socket socket;

	private PrintStream streamToServer;
	private BufferedReader streamFromServer;

	private String clientName;

	public ATM() {
		connectToServer();
		initialiseStreamVariable();

	}

	private void initialiseStreamVariable() {
		try {
			streamFromServer = new BufferedReader(new InputStreamReader((socket.getInputStream())));
			streamToServer = new PrintStream(socket.getOutputStream());
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	private void connectToServer() {
		try {
			socket = new Socket("127.0.0.1", 80);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/////////////////////////////////////////////

	public void login(String username, String password) {
		try {

			System.out.println(streamFromServer.readLine());
			streamToServer.println(username + " " + password);
			int index = Integer.parseInt(streamFromServer.readLine());

			if (index >= 0) {
				System.out.println("You logged in successfully");
				streamToServer.println(index);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getCashValue() {

		try {

			double curentValue = Double.parseDouble(streamFromServer.readLine());
			System.out.println("Yor current cash = " + curentValue);

		} catch (Exception e) {}

	}

	public void setCashValue(double cash) {
		streamToServer.println(cash);

		try {
			double curentValue = Double.parseDouble(streamFromServer.readLine());
			System.out.println("Yor current cash = " + curentValue);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	////////////////////////////////////////////
}
