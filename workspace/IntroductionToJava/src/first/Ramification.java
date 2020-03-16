package first;

/**
 * Ветвления
 * @author Dima Zosimov
 *
 */

public class Ramification {

	public static void main(String[] args) {
		System.out.println("Ветвление");
		first(35, 120);
		second(1,2,3,4);
		third(1, 2, 3, 4, 5, 6);
		fourth(66, 251, 65, 120, 250);
		fifth(1);
		
	}
	
	//упражнение 1
	static void first(int angle1, int angle2) {
		/**
		 * Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник,
		 *  и если да, то будет ли он прямоугольным. 
		 */
		int angle3 = 180 - angle1 - angle2;
		System.out.println("Первое упражнение. Ответ при angle1 = " + angle1 +
				" и angle2 = " + angle2);
		if(angle3 <= 0) {
			System.out.println("не существует такой треугольник");
		} else if(angle1 == 90 || angle2 == 90 || angle3 == 90) {
			System.out.println("существует. треугольник прямоугольный");
		} else { 
			System.out.println("существует. треугольник не прямоугольный");
		}
	}
	
	//упражнение 2
	static void second(int a, int b, int c, int d) {
		/**
		 * Найти max{min(a, b), min(c, d)}. 
		 */
		int ans = Math.max(Math.min(a, b), Math.min(c, d));
		System.out.printf("Второе упражнение. Ответ при а=%d, b=%d, c=%d, d=%d:%n%d%n",
				a, b, c, d, ans);
	}
	
	//упражнение 3
	static void third(double x1, double y1, double x2, double y2, double x3, double y3) {
		/**
		 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.  
		 */
		double a = (y1 - y2)/(x1 - x2);
		double b = y2 - a * x2;
		double y = a * x3 + b;
		System.out.printf("Третье упражнение. Ответ при А(%.2f;%.2f), B(%.2f;%.2f), C(%.2f;%.2f):%n", 
				x1, y1, x2, y2, x3, y3);
		if(y == y3) {
			System.out.println("все точки лежат на одной прямой");
		} else {
			System.out.println("точки не лежат на прямой");
		}
	}
	
	//упражнение 4
	static void fourth(double a,double b, double x, double y, double z) {
		/**
		 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. 
		 * Определить, пройдет ли кирпич через отверстие. 
		 */
		double min = Math.min(a, b);
		double max = Math.max(a, b);
		boolean is = false;
		System.out.printf("Четвертое упражнение. Ответ при размерах отверстия A=%.2f, B=%.2f и "
				+ "размерах кирпича x=%.2f, y=%.2f, z=%.2f:%n", a, b, x, y, z);
		if(min > Math.min(x, y) && max > Math.max(x, y)) {
			System.out.println("кирпич проходит стороной х,у");
			is = true;
		}
		if(min > Math.min(x, z) && max > Math.max(x, z)) {
			System.out.println("кирпич проходит стороной х,z");
			is = true;
		}
		if(min > Math.min(z, y) && max > Math.max(z, y)) {
			System.out.println("кирпич проходит стороной у,z");
			is = true;
		}
		if(!is) {
			System.out.println("кирпич не проходит");
		}
	}
	
	//упражнение 5
	static void fifth(double x) {
		/**
		 * Вычислить значение функции
		 */
		double y;
		if(x <= 3) {
			y = Math.pow(x, 2) - 3 * x + 9;
		} else { 
			y = 1/(Math.pow(x, 3) + 6);
		}
		System.out.println("Пятое упражнение. Ответ при х=" + x + ":\n" + y);
	}

}
