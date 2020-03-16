package domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import exception.ResourceException;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class Ship extends Thread{

	private int shipId;
	private Port port;
	private final static int SHIP_CAPACITY = 40; // максимальная вместимость кораблей
	private final static int SHIP_WEIGHT = 1_200_000; //грузоподъемность в кг
	private Queue<Container> goods;
	private int weight;
	private int size;

	public Ship(Port port, Queue<Container> goods, int id) {
		this.shipId = id;
		this.port = port;
		if(goods != null) {
			this.size = goods.size();
			if(size > SHIP_CAPACITY) {
				throw new IllegalArgumentException("Превышена вместимость корабля: " + size);
			}
			this.goods = goods;
			for(Container cont : goods) {
				this.weight += cont.getWeight();
			}
			if(weight > SHIP_WEIGHT) {
				throw new IllegalArgumentException("Превышена грузоподъемность корабля: " + weight + " кг");
			}
		} else {
			this.goods = new LinkedList<Container>();
			this.size = 0;
			this.weight = 0;
		}
	}
	
	public Ship(Port port, int id) {
		this(port, null, id);
	}
	
	@Override
	public void run() {
		Pier pier = null;
		try {
			int startSize = goods.size();
			pier = port.getPier();
			System.out.println("Ship #" + shipId +
					" занял причал#" + pier.getPierId() +
					"\ncapacity: " + goods.size() + " контейнеров\n");
			
			Storage storage = port.getStorage();
			boolean canNext = true; 
			//если корабль пустой, загружаем, если загружен, разгружаем
			if(goods.isEmpty()) {
				System.out.println("Ship #" + shipId + " готов к загрузке\ncapacity: " + size + "; weight " + weight + "\n");
				while(canNext) {
					canNext = loading(storage.poll(1000));
				}
				System.out.println("Ship #" + shipId + " загружен");
			} else {
				System.out.println("Ship #" + shipId + " готов к разгрузке\ncapacity: " + size + "; weight " + weight + "\n");
				while(!goods.isEmpty()) {
					storage.put(unloading());
				}
				System.out.println("Ship #" + shipId + " разгружен");
				weight = 0;
			}
			size = goods.size();
			System.out.println("capacity: до " + startSize + " после " + size + " контейнеров\n");
			
		} catch (ResourceException | InterruptedException e) {
			System.out.println("Ship #" + shipId + 
					" got an exception -> " + e.getMessage());
		} finally {
			if(pier != null) {
				System.out.println("Ship #" + shipId + 
						" : #" + pier.getPierId() + " pier released\ncapacity: " + goods.size() + "; weigth: " + weight + "\n");
				port.returnResource(pier);
			}
		}
	}
	
	private boolean loading(Container cont) {
		weight += cont.getWeight();
		if(weight > SHIP_WEIGHT || goods.size() >= SHIP_CAPACITY) {
			weight -= cont.getWeight();
			return false;
		} else {
			try {
				Thread.sleep(new Random().nextInt(500)); //на выполнение загрузки
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return goods.offer(cont);
		}
	}
	
	private Container unloading() {
			try {
				Thread.sleep(new Random().nextInt(500)); //на выполнение разгрузки
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return goods.poll();
	}
		
	public int getCapacity() {
		return size;
	}
	

}
