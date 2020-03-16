package tools;

import java.util.ArrayList;
import java.util.Scanner;

import domain.Book;

/**
 * Инструмент, который выводит каталог
 * @author Dima Zosimov
 * @version 1.0 17.02.2020
 *
 */

public class Printer {
	
	private Scanner scan;
	private ArrayList<Book> books;
	
	public Printer(ArrayList<Book> books, Scanner scanner) {
		this.books = books;
		this.scan = scanner;
	}
	
	public void printKatalog() {
		int page = 1;
		while(page != -1) {
			for(int i = (page - 1) * 5; i < (page - 1) * 5 + 5 && i < books.size(); i++) {
				System.out.println(books.get(i));
			}
			page = getPage(page);
		}
	}
	
	private int getPage(int page) {
		int pageMax = (int) Math.ceil((double) books.size()/5);
		System.out.println("Введите число");
		System.out.println("1.Назад\t2.Далее\t3.Ввести номер страницы\t4.Выход");
		int key = scan.nextInt();
		switch (key) {
		case 1 : 	if(page <= 1) {
						return 1;
					} else {
						return page - 1;
					}
		case 2 :	if(page >= pageMax) {
						return pageMax;
					} else {
						return page + 1;
					}
		case 3 :	while(true) {
						System.out.println("Введите номер страницы от 1 до " + pageMax);
						page = scan.nextInt();
						if(page < 1 || page > pageMax) {
							System.out.println("Неверно введена страница");
						} else {
							return page;
						}
					}
		case 4 :	return -1;
		default:	System.out.println("Неверно введено число");
					getPage(page);
		}
		return page;
	}

}
