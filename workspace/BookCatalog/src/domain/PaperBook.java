package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Книга в бумажном варианте
 * @author Dima Zosimov
 * @version 1.0 04.04.2020
 *
 */

public class PaperBook extends Book {
	
	private static final long serialVersionUID = 1L;
	private String type;
	private String cover;

	public PaperBook(String name, String author, String publishingOffice, int year, int pages, String cover) {
		super(name, author, publishingOffice, year, pages);
		if(cover != null) {
			Pattern pat = Pattern.compile("[A-Za-zА-Яа-я]");
			Matcher mat = pat.matcher(cover);
			if(!mat.matches()) {
				throw new IllegalArgumentException("Неверно задан переплет");
			}
		}
		
		this.cover = cover;
		this.type = "Книга в бумажном варианте";
	}
	
	public PaperBook() {
		this(null, null, null, 0, 0, null);		
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return String.format("%s%n%-15s%s%n", type, "Переплет", cover) + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaperBook other = (PaperBook) obj;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}
