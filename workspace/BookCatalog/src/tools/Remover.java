package tools;

import java.util.ArrayList;
import java.util.Scanner;

import domain.Book;

/**
 * Удаление книг
 * @author Dima Zosimov
 * @version 1.0 15.02.2020
 *
 */

public class Remover {
	
	private Scanner scan;
	private ArrayList<Book> books;
	
	public Remover(ArrayList<Book> books, Scanner scanner) {
		this.scan = scanner;
		this.books = books;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	public void delete() {
		System.out.println("Введите название книги, которую необходимо удалить");
		String name = scan.nextLine();
		boolean isDel = false;
		int index = 0;
		while(!isDel) {
			Book book = find(name, index);
			if(book == null) {
				return;
			}
			System.out.println(book);
			System.out.println("Удалить?");
			System.out.println("1.Да\t2.Нет");
			int key = scan.nextInt();
			switch (key) {
			case 1 : 	books.remove(book);
						isDel = true;
						System.out.println("Успешно удалено");
						return;
			case 2 :	index = books.indexOf(book) + 1;
						break;
			default:	System.out.println("Неверно введено число");
			}
		}
	}
	
	private Book find(String name, int start) {
		for(int i = start; i < books.size(); i++) {
			Book book = books.get(i);
			if(book.getName().contains(name)) {
				return book;
			}
		}
		System.out.println("Ничего не найдено");
		return null;
	}

}
