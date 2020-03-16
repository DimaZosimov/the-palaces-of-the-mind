package fourth.aggregation.second;

/**
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 * 
 * @author Dima Zosimov
 *
 */

public class Test {

	public static void main(String[] args) {
		Auto a = new Auto("audi", new Wheel(), new Wheel(), new Wheel(), new Wheel(), new Motor("dsg", "sdg", 2300, 156, "disel"), 80);
		System.out.println(a.changeWheel(new Wheel(), "frontLeft"));
		a.fill(25);
		System.out.println("Топливо в баке " + a.getFuel());
		a.drive();
		a.printModel();

	}

}
