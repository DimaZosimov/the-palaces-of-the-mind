package sockets;
/**
 * @version 1.0
 * @author DimaZosimov
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import runner.ConsoleMenu;

public class MyClientSocket {
	
	private int key;
	private Socket socket = null;
	private BufferedReader br = null;
	private PrintStream ps = null;
	private Scanner scanner;
	private ConsoleMenu menu;
	
	public MyClientSocket(Scanner scanner) {
		this.scanner = scanner;
	}

	public void connect() {
		try {
			socket = new Socket(InetAddress.getLocalHost(), 8050);
			ps = new PrintStream(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			menu = new ConsoleMenu();
			while(true) {
				menu.start();
				key = scanner.nextInt();
				if(key == 4) {
					return;
				}
				ps.println(key);
				String ans;
				do {
					ans = br.readLine();
					System.out.println(ans);
					if(ans.equals("add")) {
						add();
					}
					if(ans.equals("edit")) {
						edit();
					}
				} while(br.ready());		
			}
		} catch (UnknownHostException e) {
			System.err.println("Адрес недоступен " + e);
		} catch (IOException e) {
			System.err.println("ошибка I/O потока " + e);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	private void add() throws IOException {
		scanner.nextLine();
		String inquiry;
		while(!(inquiry = br.readLine()).equals("stop")) {
			System.out.println(inquiry);
			String answer = scanner.nextLine();
			ps.println(answer);
		} 
		System.out.println("Успешно добавлено");
	}
	
	private void edit() throws IOException {
		scanner.nextLine();
		String inquiry;
		while(true) {
			 do {
				inquiry = br.readLine();
				if(inquiry.equals("stop")) {
					return;
				}
				System.out.println(inquiry);
			} while(br.ready());
			String answer = scanner.nextLine();
			ps.println(answer);
		} 
	}

	

}
