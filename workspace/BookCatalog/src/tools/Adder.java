package tools;
/**
 * Добавляет книги
 * @author Dima Zosimov
 * @version 1.0 15.02.2020
 */

import java.util.Scanner;

import domain.Book;
import domain.EBook;
import domain.PaperBook;

public class Adder {
	
	private Scanner scan;
	private Book book;
	
	public Adder(Scanner scanner) {
		this.scan = scanner;
		this.book = null;
	}
	
	public Book getBook() {
		System.out.println("Введите число");
		System.out.println("1. Электронная книга");
		System.out.println("2. Книга в бумажном варианте");
		int key = scan.nextInt();
		switch (key) {
		case 1 : book = createBook(new EBook());
				 break;
		case 2 : book = createBook(new PaperBook());
				 break;
		default: System.out.println("Неверно введено число");
				 getBook();
		}
		return book;
	}
	
	private Book createBook(Book book) {
		scan.nextLine();
		/*
		 * так как предыдущий метод не читает newLine, а только int, 
		 * последующий вызов nextLine() прочитает оставшийся элемент в введенной ранее строке,
		 * а именно "\n"
		 */
		System.out.println("Введите название");
		String name = scan.nextLine();
		System.out.println("Введите автора");
		String author = scan.nextLine();
		System.out.println("Введите издательство");
		String publishingOffice = scan.nextLine();
		System.out.println("Введите год издания");
		int year = scan.nextInt();
		System.out.println("Введите количство страниц");
		int pages = scan.nextInt();
		scan.nextLine();
		System.out.println("Добавте описание");
		String description = scan.nextLine();
		if(book instanceof PaperBook) {
			System.out.println("Введите переплет");
			String cover = scan.nextLine();
			((PaperBook) book).setCover(cover);
		}
		book.setName(name);
		book.setAuthor(author);
		book.setPublishingOffice(publishingOffice);
		book.setYear(year);
		book.setPages(pages);
		book.setDescription(description);
		return book;
	}

}
