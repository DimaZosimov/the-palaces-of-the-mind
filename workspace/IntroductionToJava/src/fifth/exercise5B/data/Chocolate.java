package fifth.exercise5B.data;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 02.02.2020
 * 
 */

public class Chocolate extends Sweets{

	public Chocolate(String name, String factory) {
		super(name, factory);
	}

	@Override
	public String toString() {
		return "Шоколад " + super.toString();
	}
	
	

}
