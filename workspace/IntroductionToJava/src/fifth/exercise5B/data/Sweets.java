package fifth.exercise5B.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Супер класс всех сладостей 
 * @author Dima Zosimov
 * @version 1.0 02.02.2020
 * 
 */

public abstract class Sweets {

	private String name;
	private String factory;
	public Sweets(String name, String factory) {
		Pattern pat = Pattern.compile("[\\w\\s]+");
		Matcher mat = pat.matcher(name);
		Matcher matfac = pat.matcher(factory);
		if(!mat.matches() || !matfac.matches()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.factory = factory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factory == null) ? 0 : factory.hashCode());
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
		Sweets other = (Sweets) obj;
		if (factory == null) {
			if (other.factory != null)
				return false;
		} else if (!factory.equals(other.factory))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return name + " " + factory;
	}
		
	
}
