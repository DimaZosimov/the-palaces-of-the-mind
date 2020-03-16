package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import domain.Student;
import domain.Students;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class Editer {

	private PrintStream os;
	private BufferedReader is;
	private Students students;
	
	public Editer(PrintStream os, BufferedReader is, Students students) {
		this.os = os;
		this.is = is;
		this.students = students;
	}
	
	public void run() throws IOException {
		if(students.size() == 0) {
			os.println("Список пуст");
			os.println("stop");
			return;
		}
		Student st = findStudent();
		if(st == null) {
			os.println("Студент с таким именем не найден");
			os.println("stop");
			return;
		}
		edit(st);
	}
	
	private Student findStudent() throws IOException {
		os.println("Имя студента, дело которого необходимо изменить");
		String name = is.readLine();
		for(Student st : students.getList()) {
			if(st.getName().contains(name)) {
				return st;
			}
		}
		return null;
	}
	
	private void edit(Student st) throws NumberFormatException, IOException {
		while(true) {
			os.println("Введите число, где необходимо изменить");
			os.println("1. логин\n2. имя\n3. телефон\n4. страна\n5. город\n6. улица\n7. факультет\n8. выход");
			int key = Integer.parseInt(is.readLine());
			switch (key) {
			case 1 :	os.println(st.getLogin());
						st.setLogin(is.readLine());
						break;
			case 2 :	os.println(st.getName());
						st.setName(is.readLine());
						break;
			case 3 :	os.println(st.getTelephone());
						st.setTelephone(Integer.parseInt(is.readLine()));
						break;
			case 4 :	os.println(st.getAddress().getCountry());
						st.getAddress().setCountry(is.readLine());
						break;
			case 5 :	os.println(st.getAddress().getCity());
						st.getAddress().setCity(is.readLine());
						break;
			case 6 :	os.println(st.getAddress().getStreet());
						st.getAddress().setStreet(is.readLine());
						break;
			case 7 :	os.println(st.getFaculty());
						st.setFaculty(is.readLine());
						break;
			case 8 :	os.println("stop");
						return;
			default:	os.println("Неверно введено число " + key);
			}
		}
	}
}
