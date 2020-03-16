package fourth;
/**
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 * 
 * @author Dima Zosimov
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TrainMain {

	public static void main(String[] args) {
		
		Train[] trains = new Train[5];
		trains[0] = new Train("Minsk", "606Б", "17:15");
		trains[1] = new Train("Gomel", "678", "15:36");
		trains[2] = new Train("Brest", "378", "10:20");
		trains[3] = new Train("Brest", "100", "09:10");
		trains[4] = new Train("Minsk", "201А", "13:10");
//		Train train = getTrain(trains);
//		printTrain(train);
		sortTo(trains);
		printTrains(trains);
		

	}
	
	public static Train[] sortNumTrain(Train[] trains) {
		Arrays.sort(trains, new Comparator<Train>() {
			@Override
			public int compare(Train o1, Train o2) {
				return o1.getNumber().compareTo(o2.getNumber());
			}
		});
		return trains;
	}
	
	public static Train getTrain(Train[] trains) {
		String number;
		System.out.println("Введите номер поезда");
		try(Scanner scan = new Scanner(System.in)){
			number = scan.next();
		}
		for(Train tr : trains) {
			if(tr.getNumber().equals(number)) {
				return tr;
			}
		}
		return null;
	}
	
	public static void sortTo(Train[] trains) {
		Arrays.sort(trains, new Comparator<Train>() {
			@Override
			public int compare(Train o1, Train o2) {
				if(o1.getTo().compareTo(o2.getTo()) == 0) {
					return o1.getDate().compareTo(o2.getDate());
				} else {
					return o1.getTo().compareTo(o2.getTo());
				}
			}
		});
	}
	
	public static void printTrain(Train train) {
		System.out.println(train);
	}
	
	public static void printTrains(Train[] trains) {
		for(Train tr : trains) {
			System.out.println(tr);
		}
	}

}
