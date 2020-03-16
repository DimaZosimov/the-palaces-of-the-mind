package fourth;

/**
 *  Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 * 
 * @author Dima Zosimov
 *
 */

public class Book {
	{
		++idGenerator;
	}
	
	private static int idGenerator = 0;
	private int id = idGenerator;
	private String name;
	private String authors;
	private String publishingOffice;
	private int year;
	private int pages;
	private double cost;
	private String type;
	public Book(String name, String authors, String publishingOffice, int year, int pages, double cost, String type) {
		this.name = name;
		this.authors = authors;
		this.publishingOffice = publishingOffice;
		if(year > 2021 && year < 0) {
			throw new IllegalArgumentException("year");
		}
		this.year = year;
		if(pages <= 0 || cost <= 0) {
			throw new IllegalArgumentException();
		}
		this.pages = pages;
		this.cost = cost;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublishingOffice() {
		return publishingOffice;
	}
	public void setPublishingOffice(String publishingOffice) {
		this.publishingOffice = publishingOffice;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format("ID %d %-17s %-20s %-34s %d\t%d\t%.2f\t%s", 
				+ id, name, authors, publishingOffice, year, pages, cost, type);
	}
	
	

}
