package fourth;

/**
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
 * позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса
 * 
 * @author Dima Zosimov
 *
 */

public class DemicalCounter {
	
	private int start;
	private int finish;
	private int status;
	
	public DemicalCounter() {
		this.start = 0;
		this.finish = 10;
		this.status = 0;
		}

	public DemicalCounter(int start, int finish, int status) {
		int min = Math.min(start, finish);
		int max = Math.max(start, finish);
		this.start = min;
		this.finish = max;
		if(status < min) {
			this.status = min;
		} else if(status > max) {
			this.status = max;
		} else {
			this.status = status;
		}
	}
	
	public void Up() {
		this.status++;
		if(status > finish) {
			status = start;
		}
	}
	
	public void Down() {
		this.status--;
		if(status < start) {
			status = finish;
		}
	}
	
	public int getStatus() {
		return status;
	}

	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

}