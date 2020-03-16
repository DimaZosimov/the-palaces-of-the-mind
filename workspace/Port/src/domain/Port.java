package domain;
/**
 * Порт
 * @version 1.0
 * @author Dima Zosimov
 *
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import exception.ResourceException;

public class Port {

	private final static int PIERS = 3; //количество причалов (семафоров)
	private final Semaphore semaphore = new Semaphore(PIERS, true);
	private final Queue<Pier> piers = new LinkedList<Pier>();
	private Storage storage;
	
	public Port() {
		this(new Storage(), 3);
	}
	
	public Port(Storage storage, int numberOfPiers) {
		this.storage = storage;
		for(int i = 0; i < numberOfPiers; i++) {
			piers.add(new Pier(i+1));
		}
	}
	
	public Pier getPier() throws ResourceException {
		Pier pier = null;
		try {
			semaphore.acquire();
			pier = piers.poll();
		} catch (InterruptedException e) {
			throw new ResourceException(e);
		}
		return pier;
	}
	
	public void returnResource(Pier pier) {
		piers.add(pier);
		semaphore.release();
	}

	public Storage getStorage() {
		return storage;
	}
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
}
