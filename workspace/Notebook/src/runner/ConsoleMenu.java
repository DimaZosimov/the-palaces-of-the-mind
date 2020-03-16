package runner;
/**
 * Консольное меню
 * @author Dima Zosimov
 * @version 1.0 21.02.2020
 */

import java.util.InputMismatchException;
import java.util.Scanner;

import data.DataNotes;

public class ConsoleMenu {
	
	private Scanner scanner;
	
	public ConsoleMenu(Scanner scanner) {
		if(scanner != null) {
			this.scanner = scanner;
		}
	}
	
	public void start() {
		System.out.println("Блокнот");
		startMenu();
	}
	
	private void startMenu() {
		DataNotes dataNotes = new DataNotes(scanner);
		try {
			System.out.println("1. Просмотр заметок");
			System.out.println("2. Поиск");
			System.out.println("3. Добавить заметку");
			System.out.println("4. Удалить заметку");
			System.out.println("5. Выход");
			int key = scanner.nextInt();
			switch(key) {
			case 1 :	dataNotes.print();
						break;
			case 2 :	dataNotes.search();
						break;
			case 3 :	dataNotes.add();
						break;
			case 4 :	dataNotes.remove();
						break;
			case 5 :	dataNotes.write();
						return;
			default:	System.out.println("Неверно введено число");
			 			startMenu();
			}
		} catch (InputMismatchException e) {
			System.out.println("Неверно выбрано меню. Необходимо вводить число");
			scanner.nextLine();
		}
		startMenu();
	}

}
