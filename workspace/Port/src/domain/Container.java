package domain;
/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class Container {

	{
		++idGenerator;
	}
	private static int idGenerator = 0;
	private int containerId = idGenerator;
	private int weight;		// вес контейнера с грузом
	
	public Container(int weight) {
		// 2145 кг минимальный вес пустого контейнера; 34000 кг максимальный вес брутто
		if(weight < 2145 || weight > 34000) {    				
			throw new IllegalArgumentException("Неверно указан вес контейнера с грузом");
		} else {
			this.weight = weight;
		}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getContainerId() {
		return containerId;
	}

}
