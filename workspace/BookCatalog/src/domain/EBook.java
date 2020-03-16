package domain;

/**
 * Электронная книга
 * @author Dima Zosimov
 * @version 1.0 04.02.2020
 *
 */

public class EBook extends Book {

	private static final long serialVersionUID = 1L;
	private String type;
	
	public EBook(String name, String author, String publishingOffice, int year, int pages) {
		super(name, author, publishingOffice, year, pages);
		this.type = "Электронная книга";
	}
	
	public EBook() {
		super(null, null, null, 0, 0);
		this.type = "Электронная книга";
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type + "\n" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		EBook other = (EBook) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}
