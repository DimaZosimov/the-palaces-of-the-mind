package domain;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 04.02.2020
 *
 */

public abstract class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static int idGenerator = 0;
	{
		++idGenerator;
	}
	private int id = idGenerator;
	private String name;
	private String author;
	private String publishingOffice;
	private int year;
	private int pages;
	private String description;
	
	public Book(String name, String author, String publishingOffice, int year, int pages) {
		if(year < 0 || pages < 0) {
			throw new IllegalArgumentException("Не верно заданы год или количество страниц");
		}
		if(author != null) {
			Pattern pat = Pattern.compile("([A-Za-zА-Яа-я,.-]|\\s)+");
			Matcher mat = pat.matcher(author);
			if(!mat.matches()) {
				throw new IllegalArgumentException("Не верно задан автор книги");
			}
		}
		
		this.name = name;
		this.author = author;
		this.publishingOffice = publishingOffice;
		this.year = year;
		this.pages = pages;
	}
	
	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s%s%n"			// name
						   + "%-15s%s%n"			// author
						   + "%-15s%s%n"			// publishingOffice
						   + "%-15s%d%n"			// year
						   + "%-15s%d%n"			// pages
						   + "%s%n%s%n", 			// description
						   "Название", name, "Автор", author, "Издательство", publishingOffice, 
						   "Год издания", year, "Страниц", pages, "Описание", description);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pages;
		result = prime * result + ((publishingOffice == null) ? 0 : publishingOffice.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pages != other.pages)
			return false;
		if (publishingOffice == null) {
			if (other.publishingOffice != null)
				return false;
		} else if (!publishingOffice.equals(other.publishingOffice))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
	
	

}
