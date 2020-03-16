package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import domain.Book;
import tools.Adder;
import tools.Editor;
import tools.Loader;
import tools.Printer;
import tools.Remover;
import tools.Searcher;
import tools.Writer;

/**
 * Каталог книг
 * @author Dima Zosimov
 * @version 1.0 10.02.2020
 * 			1.1 15.02.2020 - добавлены delete()
 *
 */

public class DataBooks {

	private ArrayList<Book> books;
	private static final File FILE = new File("src\\data\\databook.txt");
	private Scanner scan;
		
	public DataBooks(Scanner scanner) {
		if(books == null) {
			Loader loader = new Loader(FILE);
			books = (ArrayList<Book>) loader.load();
			if(books == null) {
				books = new ArrayList<Book>();
			}
		}
		this.scan = scanner;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public void write() {
		Writer writer = new Writer(FILE);
		writer.write(books);
	}
	
	public void printKatalog(ArrayList<Book> books) {
		if(books.isEmpty()) {
			System.out.println("Ничего нет");
			return;
		}
		Printer printer = new Printer(books, scan);
		printer.printKatalog();		
	}
	
	public void printKatalog() {
		printKatalog(books);
	}
	
	public void search() {
		Searcher searcher = new Searcher(books, scan);
		searcher.search();
		ArrayList<Book> searchedBooks = searcher.getSearchedBooks();
		printKatalog(searchedBooks);
		
	}
	
	public void addBook() {
		Adder adder = new Adder(scan);
		books.add(adder.getBook());
		System.out.println("Успешно добавлено");
		write();
	}
	
	public void delete() {
		Remover remover = new Remover(books, scan);
		remover.delete();
		books = remover.getBooks();
		write();
	}
	
	public void edit() {
		Editor editor = new Editor(books, scan);
		editor.edit();
		books = editor.getBooks();
		write();
	}
	
}
