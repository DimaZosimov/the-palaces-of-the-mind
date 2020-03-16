package runner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import domain.Container;
import domain.Port;
import domain.Ship;
import domain.Storage;

public class Main {

	public static void main(String[] args) {
		
		try {
			Port port = new Port(createStorage(), 4);
			Queue<Ship> ships = createQueueShips(20, port);
			for(int i = 0; i < ships.size(); i++) {
				ships.poll().start();
				
			}
			Thread.sleep(20000);
			System.out.println("--- Емкость склада " + port.getStorage().size());
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
	
	public static Storage createStorage() throws InterruptedException {
		Storage storage = new Storage();
		int qty = new Random().nextInt(1000); //количество контейнеров на складе
		for(int i = 0; i < qty || i < storage.size(); i++) {
			storage.put(new Container((int) (Math.random() * (34000 - 2145) + 2145)));
		}
		System.out.println("На складе хранятся " + qty + " контейнеров");
		return storage;
	}
	
	public static Queue<Ship> createQueueShips(int numberOfShips, Port port){
		Queue<Ship> list = new LinkedList<Ship>();
		for(int i = 0; i < numberOfShips; i++) {
			//чтобы как-то добавить баланса к количеству порожних и груженых кораблей
			if((Math.random() * 10 * 2 - 10) >= 0) {
				list.add(new Ship(port, i));
			} else {
				Queue<Container> goods = new LinkedList<Container>();
				int capacity = new Random().nextInt(40);
				for(int j = 0; j < capacity; j++) {
					goods.add(new Container((int) (Math.random() * (34000 - 2145) + 2145)));
				}
				list.add(new Ship(port, goods, i));
			}
		}
		return list;
	}

}
