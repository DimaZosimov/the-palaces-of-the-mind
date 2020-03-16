package tools;
/**
 * Добавляет заметки
 * @author Dima Zosimov
 * @version 1.0 20.02.2020
 *
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.Note;

public class Adder {
	
	private Scanner scanner;
	private Note note;
	
	public Adder(Scanner scanner) {
		this.scanner = scanner;
		this.note = null;
	}
	
	public Note getNote() {
		this.note = createNote();
		return note;
	}
	
	private Note createNote() {
		Note note = null;
		scanner.nextLine();
		System.out.println("Введите тему");
		String topic = scanner.nextLine();
		System.out.println("Введите email");
		String mail = scanner.nextLine();
		while(!cheackMail(mail)) {
			System.out.println("Неверно введен e-mail");
			mail = scanner.nextLine();
		}
		System.out.println("Введите сообщение");
		String message = scanner.nextLine();
		note = new Note(topic, mail, message);
		return note;
	}
	
	private boolean cheackMail(String mail) {
		Pattern pattern = Pattern.compile("(\\w{6,})@(\\w+\\.)([a-z]{2,4})");
		Matcher matcher = pattern.matcher(mail);
		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
