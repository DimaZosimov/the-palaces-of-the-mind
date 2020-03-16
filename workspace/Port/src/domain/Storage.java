package domain;
/**
 * @version 1.0
 * @author Dima Zosimov
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Storage {

	private final static int CAPACITY = 2000; //вместимость хранилища порта
	private BlockingQueue<Container> goods;
	
	public Storage() {
		goods = new ArrayBlockingQueue<Container>(CAPACITY);
	}
	
	public void put(Container cont) throws InterruptedException {
		goods.put(cont);
	}
	
	public Container poll(long timeout) throws InterruptedException {
		return goods.poll(timeout, TimeUnit.MILLISECONDS);
	}
	
	public int size() {
		return goods.size();
	}

}
