package runner;

/**
 * Консольное меню админа
 * @author Dima Zosimov
 * @version 1.0 15.02.2020
 */

import java.util.Scanner;

import data.DataBooks;

public class AdminMenu implements CatalogConsoleMenu{

	private Scanner scan;
		
	public AdminMenu(Scanner scanner) {
		this.scan = scanner;
	}
	
	@Override
	public void start() {
		System.out.println("Каталог. Меню администратора");
		if(scan != null) {
			startMenu();
		}
	}
	
	@Override
	public void startMenu() {
		System.out.println("Введите число");
		System.out.println("1. Просмотреть каталог книг");
		System.out.println("2. Поиск");
		System.out.println("3. Добавить книгу");
		System.out.println("4. Удалить книгу");
		System.out.println("5. Изменить книгу");
		System.out.println("6. Выход");
		int key = scan.nextInt();
		DataBooks dataBooks = new DataBooks(scan);
		switch (key) {
		case 1 : dataBooks.printKatalog();
				 break;
		case 2 : dataBooks.search();
				 break;
		case 3 : dataBooks.addBook();
				 break;
		case 4 : dataBooks.delete();
				 break;
		case 5 : dataBooks.edit();
				 break;
		case 6 : dataBooks.write();
				 return;
		default: System.out.println("Неверно введено число");
		  		 startMenu();
		}
		startMenu();
	}
	
}
