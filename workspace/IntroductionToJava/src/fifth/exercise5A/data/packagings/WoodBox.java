package fifth.exercise5A.data.packagings;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 29.01.2020
 * 
 */

public class WoodBox extends Packaging{

	public WoodBox() {
		super("Деревянный ящик");
	}
	
	public WoodBox(boolean tape) {
		super("Деревянный ящик", tape);
	}

}
