package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import domain.Student;
import domain.Student.Address;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class Adder {

	private PrintStream os;
	private BufferedReader is;
	private Student st;
	
	public Adder(PrintStream os, BufferedReader is) {
		this.os = os;
		this.is = is;
	}
	
	public void run() throws IOException {
		os.println("login");
		String login = is.readLine();
		os.println("name");
		String name = is.readLine();
		os.println("telephone");
		int telephone = Integer.parseInt(is.readLine());
		os.println("country");
		String country = is.readLine();
		os.println("city");
		String city = is.readLine();
		os.println("street");
		String street = is.readLine();
		os.println("faculty");
		String faculty = is.readLine();
		
		this.st = new Student(login, name, faculty, telephone, new Address(country, city, street));
		os.println("stop");

	}
	
	public Student getStudent() {
		return st;
	}
	
	
	
}
