package fifth.exercise5A.data.packagings;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 29.01.2020
 * 
 */

public class Carton extends Packaging{

	public Carton() {
		super("Картонная коробка");
	}
	
	public Carton(boolean tape) {
		super("Картонная коробка", tape);
	}

}
