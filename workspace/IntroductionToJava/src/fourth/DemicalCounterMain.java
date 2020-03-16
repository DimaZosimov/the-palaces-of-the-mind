package fourth;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class DemicalCounterMain {
	
	public static void main(String[] args) {
		DemicalCounter dc = new DemicalCounter();
		System.out.println("Счётчик 1");
		do {
			System.out.println(dc.getStatus());
			dc.Up();
		} while(dc.getStatus() != dc.getFinish());
		System.out.println("Счётчик 2");
		DemicalCounter dc2 = new DemicalCounter(10, 20, 18);
		do {
			System.out.println(dc2.getStatus());
			dc2.Down();
		} while(dc2.getStatus() != dc2.getStart());
	}

}
