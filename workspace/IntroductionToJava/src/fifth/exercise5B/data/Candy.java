package fifth.exercise5B.data;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 02.02.2020
 * 
 */
public class Candy extends Chocolate {

	public Candy(String name, String factory) {
		super(name, factory);
	}

	@Override
	public String toString() {
		return "Конфета " + super.toString();
	}
	
	

}
