package runner;

import java.util.Scanner;

import data.DataBooks;
import domain.Book;
import mail.MailSender;
import tools.Adder;

/**
 * Консольное меню пользователей
 * @author Dima Zosimov
 * @version 1.0 17.02.2020
 *
 */

public class UserMenu implements CatalogConsoleMenu {
	
	private Scanner scan;
		
	public UserMenu(Scanner scanner) {
		this.scan = scanner;
	}
	
	@Override
	public void start() {
		System.out.println("Катагол. Меню пользователя");
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
		System.out.println("4. Выход");
		int key = scan.nextInt();
		DataBooks dataBooks = new DataBooks(scan);
		switch (key) {
		case 1 : dataBooks.printKatalog();
				 break;
		case 2 : dataBooks.search();
				 break;
		case 3 : Adder adder = new Adder(scan);
				 Book book = adder.getBook();
				 MailSender mailSender = new MailSender();
				 mailSender.sendMailToAdmin(Session.person, "Добавить книгу", book);
				 break;
		case 4 : dataBooks.write();
				 return;
		default: System.out.println("Неверно введено число");
		  		 startMenu();
		}
		startMenu();
	}

}
