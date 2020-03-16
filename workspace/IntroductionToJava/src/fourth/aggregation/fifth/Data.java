package fourth.aggregation.fifth;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.*;

public class Data {
	
	public static List<Tour> tours = new ArrayList<Tour>();
	
	public Data() {
		tours.add(new Tour("Турция", "отдых", "Самолет", "завтрак", 7));
		tours.add(new Tour("Турция", "отдых", "Самолет", "завтрак", 10));
		tours.add(new Tour("Турция", "отдых", "Самолет", "завтрак", 14));
		tours.add(new Tour("Турция", "круиз", "Самолет", "полное", 7));
		tours.add(new Tour("Турция", "отдых", "Самолет", "полное", 14));
		tours.add(new Tour("Греция", "круиз", "Автобус", "завтрак и ужин", 14));
		tours.add(new Tour("Польша", "шопинг", "Автобус", "завтрак и ужин", 5));
		tours.add(new Tour("Италия", "экскурсия", "Самолет", "полное", 6));
		tours.add(new Tour("Италия", "экскурсия", "Автобус", "завтрак", 11));
		tours.add(new Tour("Италия", "отдых", "Самолет", "полное", 14));
		tours.add(new Tour("Англия", "лечение", "Самолет", "полное", 14));
		tours.add(new Tour("Англия", "экскурсия", "Самолет", "завтрак", 8));
		tours.add(new Tour("Россия", "экскурсия", "Автобус", "завтрак", 5));
		tours.add(new Tour("Россия", "экскурсия", "Автобус", "полное", 3));
		tours.add(new Tour("Россия", "лечение", "Нет", "полное", 14));
		tours.add(new Tour("Беларусь", "лечение", "Нет", "полное", 15));
		tours.add(new Tour("Германия", "шопинг", "Автобус", "завтрак и ужин", 4));
		tours.add(new Tour("Германия", "экскурсия", "Автобус", "завтрак и ужин", 7));
		tours.add(new Tour("Грузия", "экскурсия", "Самолет", "завтрак", 7));
		tours.add(new Tour("Грузия", "лечение", "Автобус", "полное", 21));
		tours.add(new Tour("Испания", "круиз", "Самолет", "завтрак", 12));
		tours.add(new Tour("Испания", "отдых", "Самолет", "полное", 7));
		tours.add(new Tour("Испания", "отдых", "отдых", "полное", 14));
		tours.add(new Tour("Чехия", "экскурсия", "Автобус", "полное", 5));
		tours.add(new Tour("Чехия", "шопинг", "Автобус", "завтрак", 5));
		tours.add(new Tour("Литва", "лечение", "Автобус", "полное", 14));
		tours.add(new Tour("Литва", "экскурсия", "Автобус", "полное", 3));
		tours.add( new Tour("Швеция", "отдых", "Самолет", "полное", 10));
		tours.add(new Tour("Швеция", "отдых", "Автобус", "завтрак и ужин", 7));
		tours.add(new Tour("Китай", "лечение", "Самолет", "полное", 14));
		tours.add(new Tour("Китай", "экскурсия", "Самолет", "полное", 21));
		tours.add(new Tour("Китай", "отдых", "Самолет", "полное", 15));
		
	}
	
	public static List<Tour> getTour(String country, String type, String transport, String nutrition, int days){
		List<Tour> list = new ArrayList<Tour>();
		for(Tour tour : tours) {
			if((tour.equalsCountry(country) || country.isBlank()) && 
					(tour.equalsNutrition(nutrition) || nutrition.isBlank()) &&
					(tour.equalsTransport(transport) || transport.isBlank()) &&
					(tour.equalsType(type) || type.isBlank()) &&
					(tour.getDays() <= days)) {
				list.add(tour);
			}
		}
		if(list.isEmpty()) {
			System.out.println("Список не найден");
		}
		return list;		
	}
	
	public static void sort(List<Tour> tours) {
		Collections.sort(tours, new Comparator<Tour>() {
			@Override
			public int compare(Tour o1, Tour o2) {
				return o1.getCountry().compareTo(o2.getCountry());
			}
			
		});
	}
	
	public static void printTours(List<Tour> tours) {
		for(Tour t : tours) {
			System.out.println(t);
		}
	}
	
	
	
	 
	
}
