package fourth;

/**
 * @author Dima Zosimov
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AirlineMain {

	public static void main(String[] args) {
		List<Airline> list = new ArrayList<>();
		list.add(new Airline("Берлин", "197", "A", "17:15", "Пн, Чт, Пт"));
		list.add(new Airline("Мадрид", "163Б", "Б", "10:00", "Вт, Сб, Вс"));
		list.add(new Airline("Москва", "201", "A", "12:15", "ежедневно"));
		list.add(new Airline("Варшава", "154", "Б", "08:20", "Пн, Ср, Пт, Вс"));
		list.add(new Airline("Рим", "199", "A", "07:10", "Пн, Чт, Пт, Вс"));
		list.add(new Airline("Киев", "155", "A", "18:35", "ежедневно"));
		list.add(new Airline("Вашингтон", "121", "A", "05:35", "Пн"));
		list.add(new Airline("Лондон", "220", "A", "22:00", "Чт, Пт"));
		
		print(list);
		System.out.println("\nсписок рейсов для заданного пункта назначения");
		print(getTo(list, "Берлин"));
		System.out.println("\nсписок рейсов для заданного дня недели");
		print(getThisDay(list, "Чт"));
		System.out.println("\n список рейсов для заданного дня недели, время вылета для которых больше заданного");
		print(getThisDayAndTime(list, "Чт", 10, 00));
		
	}
	
	public static void print(List<Airline> list) {
		for(Airline a : list) {
			System.out.println(a);
		}
	}
	
	public static List<Airline> getTo(List<Airline> list, String city){
		List<Airline> newList = new ArrayList<Airline>();
		for(Airline a : list) {
			if(a.getTo().contains(city)) {
				newList.add(a);
			}
		}
		return newList;
	}
	
	public static List<Airline> getThisDay(List<Airline> list, String day){
		List<Airline> newList = new ArrayList<Airline>();
		Pattern pat = Pattern.compile(day);
		Matcher mat;
		for(Airline a : list) {
			mat = pat.matcher(a.getDaysOfWeek());
			if(mat.find() || a.getDaysOfWeek().contains("ежедневно")) {
				newList.add(a);
			}
		}
		return newList;
	}
	
	public static List<Airline> getThisDayAndTime(List<Airline> list, String day, int hour, int min){
		List<Airline> newList = new ArrayList<Airline>();
		Pattern pat = Pattern.compile(day);
		Matcher mat;
		for(Airline a : list) {
			mat = pat.matcher(a.getDaysOfWeek());
			if(mat.find() || a.getDaysOfWeek().contains("ежедневно")) {
				if(hour < a.getTime().getHours()) {
					newList.add(a);
				} else if(hour == a.getTime().getHours() && min <= a.getTime().getMinutes()){
					newList.add(a);
				}
			}
		}
		return newList;
	}

}
