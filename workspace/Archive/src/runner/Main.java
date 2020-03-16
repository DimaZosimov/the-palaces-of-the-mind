package runner;

import java.util.Scanner;

import sockets.MyClientSocket;

public class Main {

	public static void main(String[] args) {

		MyClientSocket client = new MyClientSocket(new Scanner(System.in));
		client.connect();

	}

}
