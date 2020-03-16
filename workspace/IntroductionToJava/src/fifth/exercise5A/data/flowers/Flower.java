package fifth.exercise5A.data.flowers;

/**
 * Супер класс всех цветов
 * 
 * @author Dima Zosimov
 * @version 1.0 29.01.2020
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Flower {
	
	private String name;
	
	public Flower(String name) {
		Pattern pat = Pattern.compile("[\\w\\s]+");
		Matcher mat = pat.matcher(name);
		if(!mat.matches()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Flower other = (Flower) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
