package fifth.exercise3;
/**
 * 
 * @author Dima Zosimov
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Calendar cal = new Calendar("26.01.2020", "calendar");
		cal.addInfo("26.01.2020", "happy birthday");
		cal.addInfo("01.01.2020", "new year");
		cal.addInfo("07.03.2020", "holiday");
		cal.printCalendar();
		cal.deleteInfo("26.01.2020");
		System.out.println();
		cal.printCalendar();

	}

}
