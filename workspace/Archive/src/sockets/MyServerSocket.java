package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import domain.Students;
import tools.Adder;
import tools.Editer;
import tools.ReaderXML;
import tools.WriterXML;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class MyServerSocket {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			ServerSocket server = new ServerSocket(8050);
			System.out.println("initializated");
			socket = server.accept();
			System.out.println(socket.getInetAddress().getHostName() + " connected");
			ServerThread thread = new ServerThread(socket);
			thread.start();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

}

class ServerThread extends Thread {
	
	private PrintStream os;
	private BufferedReader is;
	private InetAddress addr;
	public ServerThread(Socket socket) throws IOException {
		os = new PrintStream(socket.getOutputStream());
		is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		addr = socket.getInetAddress();
	}
	
	@Override
	public void run() {
		String key;
		Students students = null;
		try {
			ReaderXML reader = new ReaderXML();
			students = reader.read();
			if(students == null) {
				System.out.println("Students are not founded");
				students = new Students();
			}
			while((key = is.readLine()) != null){
				switch (Integer.parseInt(key)) {
				case 1 : 	os.println("show\n" + students);
							break;
				case 2 :	os.println("edit");
							Editer editer = new Editer(os, is, students);
							editer.run();
				 			break;
				case 3 : 	os.println("add");
							Adder adder = new Adder(os, is);
							adder.run();
							students.add(adder.getStudent());
				 			break;
				default:	os.println("Неверно введено число " + key);
				 			
				}
			}
		} catch (NumberFormatException e) {
			System.err.println("Number Format is not correct");
		} catch (IOException e) {
			System.err.println("Disconnect");
		} finally {
			WriterXML writer = new WriterXML();
			writer.write(students);
			disconnect();
		}
	}
	
	public void disconnect() {
		try {
			if(os != null) {
				os.close();
			}
			if(is != null) {
				is.close();
			}
			System.out.println(addr.getHostName() + " disconnecting");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.interrupt();
		}
	}
}
