package fifth.exercise5A.runner;

/**
 * Консольное меню
 * 
 * @author Dima Zosimov
 * @version 1.0 29.01.2020
 * 
 */

import java.util.Scanner;

public class ConsoleMenu {

private Scanner scanner;
private FlowerComposition fc;
	
	public ConsoleMenu(Scanner scanner) {
		this.scanner = scanner;
	}
	
	private void printMenu() {
		System.out.println("1. Выбрать упаковку");
		System.out.println("2. Добавить цветок/цветы");
		System.out.println("3. Показать компазицию");
		System.out.println("4. Выход");
	}
	
	public void start() {
		if(this.scanner != null) {
			int key;
			System.out.println("Цветочная компазиция\nКак назовем?");
			String name = scanner.next();
			fc = new FlowerComposition(name, null);
			do {
				printMenu();
				System.out.println("Выбери чего хочешь, напиши номер меню: ");
				key = this.scanner.nextInt();
				switch(key){
					case 1: break;
					case 2: break;
					case 3: break;
					case 4: System.out.println("До скорых встреч");
							break;
					default:
						System.out.println("Ты ввел неверное значение меню. Попробуй ещё раз\n");
				}
			} while(key != 4);
		}
	}
	
}
