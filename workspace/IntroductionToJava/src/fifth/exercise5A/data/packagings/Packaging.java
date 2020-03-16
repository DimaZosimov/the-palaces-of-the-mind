package fifth.exercise5A.data.packagings;

/**
 * Супер класс всех упаковок
 * 
 * @author Dima Zosimov
 * @version 1.0 29.01.2020
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Packaging {
	
	private String type;
	private boolean tape = false;
	
	public Packaging(String type) {
		Pattern pat = Pattern.compile("[\\w\\s]+");
		Matcher mat = pat.matcher(type);
		if(!mat.matches()) {
			throw new IllegalArgumentException();
		}
		this.type = type;
	}
	
	public Packaging(String type, boolean tape) {
		this(type);
		this.tape = tape;
	}
	
	public void setTape(boolean tape) {
		this.tape = tape;
	}
	
	public boolean getTape() {
		return tape;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (tape ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Packaging other = (Packaging) obj;
		if (tape != other.tape)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return type;
	}
	
	

}
