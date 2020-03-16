package fifth.exercise5B.data;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 02.02.2020
 * 
 */

public class Caramel extends Chocolate{

	public Caramel(String name, String factory) {
		super(name, factory);
	}

	@Override
	public String toString() {
		return "Карамель " + super.toString();
	}

	

}
