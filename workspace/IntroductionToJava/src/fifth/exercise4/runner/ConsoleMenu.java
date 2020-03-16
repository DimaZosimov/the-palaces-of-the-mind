package fifth.exercise4.runner;

import java.util.Scanner;

/**
 * Консольное меню
 * 
 * @author Dima Zosimov
 * @version 1.0 26.01.2020
 */

public class ConsoleMenu {
	
	private final Scanner scanner;
	
	public ConsoleMenu(Scanner scanner) {
		this.scanner = scanner;
	}
	
	private void printMenu() {
		System.out.println("1. Какие сокровища спрятаны в этой пещере");
		System.out.println("2. Самое ценное сокровище");
		System.out.println("3. Сокровища определенной стоимости");
		System.out.println("4. Покинуть пещеру");
	}
	
	public void start() {
		if(this.scanner != null) {
			int key;
			System.out.println("Добро пожаловать в пещеру дракона");
			do {
				printMenu();
				System.out.println("Выбери чего хочешь, напиши номер меню: ");
				key = this.scanner.nextInt();
				switch(key){
					case 1: Executor.printAllTreasures();
							break;
					case 2: Executor.printTheMostCost();
							break;
					case 3: System.out.println("На какую сумму ищем сокровища?");
							Executor.printTreasuresThisCost(scanner.nextInt());
							break;
					case 4: System.out.println("До скорых встреч");
							break;
					default:
						System.out.println("Ты ввел неверное значение меню. Попробуй ещё раз\n");
				}
			} while(key != 4);
		}
	}

}
