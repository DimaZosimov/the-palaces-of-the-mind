package first;

/**
 * Линейные программы
 * 
 * @author Dima Zosimov
 *
 */

public class LinearPrograms {

	public static void main(String[] args) {
		System.out.println("Линейные программы");
		first(3,4,5);
		second(3,4,5);
		third(3,6);
		fourth(333.666);
		fifth(3599);
		sixth(-3, -2);

	}
	
	//упражнение 1
	static void first(int a, int b, int c) {
		/**
		 * Найдите значение функции: z = ((a-3) * b/2) + c
		 */
		int z = ((a - 3) * b/2) + c;
		System.out.println("Первое упражнение. Ответ при a=" + a + 
				", b=" + b + ", c=" + c + ": \nz=" + z);
	}
	
	//упражение 2
	static void second(int a, int b, int c) {
		/**
		 * Вычислить значение выражения по формуле
		 * (все переменные принимают действительные значения):
		 */
		double z = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c))/(2 * a) 
				- Math.pow(a, 3) * c + Math.pow(b, -2);
		System.out.println("Второе упражнение. Ответ при a=" + a + 
				", b=" + b + ", c=" + c + ": \nz=" + z);
	}
	
	//упражнение 3
	static void third(int x, int y) {
		/**
		 * Вычислить значение выражения по формуле
		 * (все переменные принимают действительные значения):
		 */
		double z = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))
				* Math.tan(x*y);
		System.out.println("Тертье упражнение. Ответ при x=" + x + 
				", y=" + y + ": \nz=" + z);
	}
	
	//упражнение 4
	static void fourth(double a) {
		/**
		 * Дано действительное число R вида nnn.ddd(три цифровых разряда в дробной и
		 * целой частях). Поменять местами дробную и целую части числа и 
		 * вывести полученное значение числа
		 */
		double z = Math.floor(a);
		double b = (a - z) * 1000 + (z/1000);
		System.out.printf("Четвертое упражнение. Ответ при a=%.3f:%n %.3f%n", a, b);
	}
	
	//упражнение 5
	static void fifth(int t) {
		/**
		 * Дано  натуральное  число  Т,  которое  представляет  длительность  прошедшего  
		 * времени  в  секундах.  Вывести  данное значение длительности в часах, минутах 
		 * и секундах в следующей форме: ННч ММмин SSc. 
		 */
		int sec = t%60;
		int min = (int) t/60;
		int hours = (int) min/60;
		min = min%60;
		System.out.printf("Пятое упражнение. Ответ при T=%d сек: %n"
				+ "%02dч %02dмин %02dс %n", t, hours, min, sec);
	}
	
	//упражнение 6
	static void sixth(double x, double y) {
		/**
		 * Для данной области составить линейную программу, которая печатает true, 
		 * если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае:  
		 */
		System.out.println("Шестое упражнение. Ответ при x= " + x + " и у= " + y);
		int ymax = 4;
		int ymin = -3;
		if(y == -1 && x == 0) {
			System.out.println(false);
			return;
		}
		if(y > 0 && y <= ymax && x >= -2 && x <= 2) {
			System.out.println(true);
			return;
		}
		if(y <= 0 && y >= ymin && x >= -4 && x <= 4) {
			System.out.println(true);
			return;
		}
		System.out.println(false);
	}

}
