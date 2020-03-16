package tools;
/**
 * Поисковик
 * @author Dima Zosimov
 * @version 1.0 11.02.2020
 */

import java.util.ArrayList;
import java.util.Scanner;

import domain.Book;
import domain.EBook;
import domain.PaperBook;

public class Searcher {
	
	private ArrayList<Book> books;
	private ArrayList<Book> searchedBooks;
	private Scanner scan;
	
	public Searcher(ArrayList<Book> books, Scanner scanner) {
		this.books = books;
		searchedBooks = new ArrayList<Book>();
		this.scan = scanner;
	}
	
	private void search(String name, String author, String publishingOffice, int year, boolean isEBook, boolean isPaper) {
		for(Book book : books) {
			String nameBook = book.getName().toLowerCase();
			if(nameBook.contains(name.toLowerCase()) || name == null) {
				String authorBook = book.getAuthor().toLowerCase();
				if(authorBook.contains(author.toLowerCase()) || author == null) {
					String publishingOfficeBook = book.getPublishingOffice().toLowerCase();
					if(publishingOfficeBook.contains(publishingOffice.toLowerCase()) || publishingOffice == null) {
						if(year == book.getYear() || year == 0) {
							if((isEBook && book instanceof EBook) || (isPaper && book instanceof PaperBook)) {
								searchedBooks.add(book);
							}
						}
					}
				}
			}
		}
	}
	
	public ArrayList<Book> getSearchedBooks(){
		return searchedBooks;
	}
	
	public void search() {
		scan.nextLine();
		System.out.println("Параметры поиска");
		System.out.println("Название книги");
		String name = scan.nextLine();
		System.out.println("Автор");
		String author =scan.nextLine();
		System.out.println("Издательство");
		String publishingOffice = scan.nextLine();
		System.out.println("Год издания");
		int year = scan.nextInt();
		System.out.println("Введите true, если ищем среди электронных книг");
		boolean isEBook = scan.nextBoolean();
		System.out.println("Введите true, если ищум среди книг бумажного варианта");
		boolean isPaper = scan.nextBoolean();
		search(name, author, publishingOffice, year, isEBook, isPaper);
	}

}
