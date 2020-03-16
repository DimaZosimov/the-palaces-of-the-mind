package fourth;

/**
 * @author Dima Zosimov
 */

import java.util.*;

public class BookMain {

	public static void main(String[] args) {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book("Ведьмак", "Анджей Сапсковский", "Издательство АСТ", 2010, 369, 16.17, "твёрдый"));
		list.add(new Book("Шестерка Воронов", "Ли Бардуго", "Издательство АСТ", 2018, 611, 24.10, "твёрдый"));
		list.add(new Book("Код да Винчи", "Дэн Браун", "Издательство АСТ", 2011, 333, 15.00, "твёрдый"));
		list.add(new Book("Безымянный раб", "Виталий Зыков", "Издательство Альфа-книга", 2008, 410, 18.50, "твёрдый"));
		list.add(new Book("Мартин Иден", "Джек Лондон", "Издательство Мастацкая-лiтаратура", 1985, 370, 11.20, "твёрдый"));
		
		print(list);
		System.out.println("\nсписок книг заданного автора");
		print(getAuthorBooks(list, "Дэн Браун"));
		System.out.println("\nсписок книг, выпущенных заданным издательством");
		print(getPublishingOfficeBooks(list, "Издательство АСТ"));
		System.out.println("\nсписок книг, выпущенных после заданного года");
		print(getYearBooks(list, 2008));
		

	}
	
	public static List<Book> getAuthorBooks(List<Book> list, String author){
		List<Book> newList = new ArrayList<>();
		for(Book b : list) {
			if(author.contains(b.getAuthors())) {
				newList.add(b);
			}
		}
		return newList;
	}
	
	public static List<Book> getPublishingOfficeBooks(List<Book> list, String po){
		List<Book> newList = new ArrayList<>();
		for(Book b : list) {
			if(po.contains(b.getPublishingOffice())) {
				newList.add(b);
			}
		}
		return newList;
	}
	
	public static List<Book> getYearBooks(List<Book> list, int year){
		if(year <= 0) throw new IllegalArgumentException();
		List<Book> newList = new ArrayList<>();
		for(Book b : list) {
			if(year <= b.getYear()) {
				newList.add(b);
			}
		}
		return newList;
	}
	
	public static void print(List<Book> list) {
		for(Book i : list) {
			System.out.println(i);
		}
	}

}
