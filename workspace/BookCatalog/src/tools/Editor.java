package tools;

import java.util.ArrayList;
import java.util.Scanner;

import domain.Book;
import domain.PaperBook;
import mail.MailSender;
import runner.Session;

/**
 * Редактор
 * @author Dima Zosimov
 * @version 1.0 15.02.2020
 *
 */

public class Editor {

	private Scanner scan;
	private ArrayList<Book> searchedBooks;
	private ArrayList<Book> books;
	
	public Editor(ArrayList<Book> books, Scanner scanner) {
		this.scan = scanner;
		Searcher searcher = new Searcher(books, scanner);
		searcher.search();
		this.searchedBooks = searcher.getSearchedBooks();
		this.books = books;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	public void edit() {
		if(searchedBooks.isEmpty()) {
			System.out.println("Ничего не найдено");
			return;
		}
		for(Book book : searchedBooks) {
			boolean isEdit = false;
			while(!isEdit) {
				System.out.println(book);
				System.out.println("Изменить?\n1.Да\t2.Нет");
				int key = scan.nextInt();
				switch (key) {
				case 1 :	int index = books.indexOf(book);
							change(index);
							System.out.println("Успешно изменено");
							return;
				case 2 :	isEdit = true;
							break;
				default:	System.out.println("Неверное введено число");		
				}
			}
		}
	}
	
	private void change(int index) {
		Book book = books.get(index);
		System.out.println("Введите число");
		System.out.println("1.Название");
		System.out.println("2.Авторы");
		System.out.println("3.Издательство");
		System.out.println("4.Год издания");
		System.out.println("5.Страницы");
		System.out.println("6.Описание");
		if(book instanceof PaperBook) {
			System.out.println("7.Переплет");
		}
		System.out.println("0.Выход");
		int key = scan.nextInt();
		scan.nextLine();
		switch (key) {
		case 1 : 	System.out.println(book.getName());
					book.setName(scan.nextLine());
					break;
		case 2 :	System.out.println(book.getAuthor());
					book.setAuthor(scan.nextLine());
					break;
		case 3 :	System.out.println(book.getPublishingOffice());
					book.setPublishingOffice(scan.nextLine());
					break;
		case 4 :	System.out.println(book.getYear());
					book.setYear(scan.nextInt());
					break;
		case 5 :	System.out.println(book.getPages());
					book.setPages(scan.nextInt());
					break;
		case 6 :	System.out.println(book.getDescription());
					book.setDescription(scan.nextLine());
					MailSender mailSender = new MailSender();
					mailSender.sendMailAllUsers(Session.person, "Изменено описание", book);
					break;
		case 7 :	if(book instanceof PaperBook) {
						System.out.println(((PaperBook) book).getCover());
						((PaperBook) book).setCover(scan.nextLine());
						break;
					} else {
						System.out.println("Неверно введено число");
						break;
					}
		case 0 : 	return;
		default:	System.out.println("Неверно введено число");
		}
		change(index);
	}
}
