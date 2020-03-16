package fifth.exercise4.runner;

/**
 * Класс исполнитель содержит методы
 * реализации консольного меню
 * 
 * @author Dima Zosimov
 * @version 1.0 26.01.2020
 *
 */

import fifth.exercise4.data.*;
import java.util.*;

public class Executor {
	
	private static List<Treasure> treasures = new Reader().getTreasures();
	
	public static void printAllTreasures() {
		System.out.printf("%-37s%s%n", "Сокровище", "Стоимость");
		for(Treasure treasure : treasures) {
			System.out.println(treasure);
		}
	}
	
	public static void printTreasuresThisCost(int cost) {
		System.out.printf("%-37s%s%n", "Сокровище", "Стоимость");
		boolean isFounded = false;
		for(Treasure treasure : treasures) {
			if(cost == treasure.getCost()) {
				System.out.println(treasure);
				isFounded = true;
			}
		}
		if(!isFounded) {
			System.out.println("Ничего не найдено");
		}
	}
	
	public static void printTheMostCost() {
		System.out.printf("%-37s%s%n", "Сокровище", "Стоимость");
		System.out.println(getTheMostCost());
	}
	
	private static Treasure getTheMostCost() {
		int max = 0;
		Treasure tre = null;
		for(Treasure treasure : treasures) {
			if(max < treasure.getCost()){
				tre = treasure;
				max = treasure.getCost();
			}
		}
		return tre;
	}

}
