package fifth.exercise5B.runner;

import java.util.Scanner;

/**
 * Консольное меню
 * 
 * @author Dima Zosimov
 * @version 1.0 02.02.2020
 * 
 */

public class ConsoleMenu {
	
	private Scanner scanner;
	private Present present;
	
	public ConsoleMenu(Scanner scanner) {
		this.scanner = scanner;
	}
	
	private void printMenu() {
		System.out.println("1. Выбрать упаковку");
		System.out.println("2. Добавить сладость");
		System.out.println("3. Показать подарок");
		System.out.println("4. Выход");
	}
	
	public void start() {
		System.out.println("Добро пожаловать");
		printMenu();
		if(scanner !=  null) {
			int key;
			System.out.println("Введите номер");
			key = scanner.nextInt();
			present = new Present();
		}
	}

}
