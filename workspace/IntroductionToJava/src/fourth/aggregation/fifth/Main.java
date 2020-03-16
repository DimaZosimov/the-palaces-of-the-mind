package fourth.aggregation.fifth;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Data data = new Data();
		//выберем путевки отдых и на самолете
		List<Tour> tours = Data.getTour("", "отдых", "Самолет", "", 100);
		data.sort(tours);
		Data.printTours(tours);
		

	}

}
