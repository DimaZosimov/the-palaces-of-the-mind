package second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Декомпозиция
 * @author Dima Zosimov
 *
 */

public class Decomposition {

	public static void main(String[] args) {
		
		int[] a = createArray(10);
		
		first(25, 10);
		second(3, 9, 12, 6);
		third(13);
		fourth(5);
		fifth(a);
		sixth(3, 5, 12);
		seventh();
		eighth(a, 3, 8);
		ninth(4, 6, 7, 8);
		tenth(35690);
		eleventh(-1, 22);
		twelfth(4, 30);
		thirteenth(55);
		fourteenth(100);
		fifteenth(2);
		sixteenth(3);
		seventeenth(11);
	}
	
	static int[] createArray(int len) {
		return Sorting.createArray(len);
	}
	static void printArray(int[] a) {
		Sorting.printArray(a);
	}
	
	static int gcd(int a, int b) { //НОД
		if(a == 0) return b;
		if(b == 0) return a;
		if(a < 0) {
			a = Math.abs(a);
		}
		if(b < 0) {
			b = Math.abs(b);
		}
		while(a != b) {
			if(a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}
	
	static int nok(int a, int b) { //НОК
		int gcd = gcd(a, b);
		return (a * b)/gcd;
	}
	
	static void first(int a, int b) {
		/**
		 * Найти НОК и НОД
		 */
		System.out.println("Первое упражнение. Числа А= " + a + " и B= " + b);
		if(a < 0 || b < 0) {
			System.out.println("Числа не натуральные");
		} else {
		System.out.println("НОД " + gcd(a,b));
		System.out.println("НОК " + nok(a,b));
		}
	}
	
	static void second(int a, int b, int c, int d) {
		/**
		 * Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел. 
		 */
		System.out.println("Второе упражнение. Числа A= " + a + ", B= " + b + ", C= " + c + ", D= " + d);
		if(a < 0 || b < 0 || c < 0|| d < 0) {
			System.out.println("Присуствует не натуральное число");
		} else {
			int gcd = gcd(a, b, c, d);
			System.out.println("Нод " + gcd);
		}
	}
	
	static int gcd(int...ar) {
		int min = ar[0];
		for(int i = 0; i < ar.length - 1; i++) {
			for(int j = i+1; j < ar.length; j++) {
				int gcd = gcd(ar[i], ar[j]);
				if(min > gcd) {
					min = gcd;
				}
			}
		}
		return min;
	}
	
	static double squareRightTriangle(int a, double h) {
		return a * h * 1 / 2;
	}
	
	static double squareIsoscelesTriangle(int a, int grad) {
		return 1/2 * a * a * Math.sin(grad * Math.PI / 180);
	}
	
	static double squareRightHexagon(int a) {
		int grad = 120;
		double h = 2 * a * Math.cos(60 * Math.PI / 180);
		double s = 2 * (squareRightTriangle(a, h) + squareIsoscelesTriangle(a, grad));
		return s;
	}
	
	static void third(int a) {
		/**
		 * Вычислить  площадь  правильного  шестиугольника  со  стороной  а,  используя  метод  вычисления  площади 
		 * треугольника. 
		 */
		System.out.println("Третье упражнение. Сторона правильного шестиугольника равна " + a);
		if(a <= 0) {
			System.out.println("Сторона равна 0 или отрицательное число");
		} else {
			System.out.println("Площадь равна");
			System.out.printf("%.1f%n", squareRightHexagon(a));
		}
	}
	
	final static Map<String, String> getDisPoints(int[][] p){
		Map<String, String> map = new HashMap<>();
		double mdis = 0;
		for(int i = 0; i < p[0].length - 1; i++) {
			for(int j = i+1; j < p[0].length; j++) {
				double dis = Math.sqrt(Math.pow(Math.abs(p[0][j] - p[0][i]), 2) + Math.pow(Math.abs(p[1][j] - p[1][i]), 2));
				if(mdis < dis) {
					mdis = dis;
					map.put("dis", "" + mdis);
					map.put("fir", "" + i);
					map.put("sec", "" + j);				
				}
			}
		}
		return map;
	}
	
	static void fourth(int n) { //n - количество точек
		/**
		 * На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими 
		 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив. 
		 */
		System.out.println("Четвертое упражнение. Количество точек n = " + n);
		if(n < 2) {
			System.out.println("Кочество точек меньше 2");
			return;
		}
		int[][] points = new int [2][n]; //[0] - x, [1] - y
		for(int i = 0; i < points[0].length; i++) {
			points[0][i] = (int)(Math.random() * 2 * 20 - 20);
			points[1][i] = (int)(Math.random() * 2 * 20 - 20);
			System.out.println("Точка " + i + " - [" + points[0][i] + ";" + points[1][i] + "]");
		}
		Map<String, String> map = getDisPoints(points);
		System.out.println("Максимально отдалены точки " + map.get("fir") + " и " + map.get("sec") + ", расстояние равно " + map.get("dis"));
	}
	
	static void fifth(int[] a) {
		/**
		 * Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число, 
		 * которое меньше максимального элемента массива, но больше всех других элементов). 
		 */
		System.out.println("Пятое упражнение. Исходный массив");
		printArray(a);
		a = Sorting.sortShell(a);
		System.out.println("Число второе максимальное число " + a[a.length-2]);
	}
	
	static void sixth(int a, int b, int c) {
		/**
		 * Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми. 
		 */
		System.out.println("Шестое упражнение. Числа а= " + a + ", b= " + ", c= " + c);
		boolean ans = false;
		if(gcd(a,b) == 1 && gcd(a, c) == 1 && gcd(b,c) == 1) {
			ans = true;
		}
		System.out.println("Числа взаимно простые: " + ans);
	}
	
	static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	static void seventh() {
		/**
		 * Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
		 */
		System.out.println("Седьмое упражнение");
		for(int i = 1; i < 10; i+=2) {
			System.out.println("Факториал числа " + i + " равен " + factorial(i));
		}
	}
	
	static int getSum(int[]d, int k) {
		return d[k] + d[k+1] + d[k+2];
	}
	
	static void eighth(int[]d, int k, int m) {
		/**
		 * Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6]. 
		 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов 
		 * массива с номерами от k до m. 
		 */
		System.out.println("Восьмое упражнение. Исходный массив");
		printArray(d);
		if(k < 0 || m < 0 || k > d.length-1 || m > d.length-1) {
			throw new IndexOutOfBoundsException();
		}
		if(k > m) {
			int i = k;
			k = m;
			m = i;
		}
		while(k < (m-1)) {
			System.out.println("Сумма элементов массива " + k + ", " + (k+1) + ", " + (k+2) + " равна " + getSum(d, k));
			k++;
		}
	}
	
	static double formGerona(double h, int z, int t) {
		double polprmt = 0.5 * (h + z + t);
		return Math.sqrt(polprmt * (polprmt - h) * (polprmt - z) * (polprmt - t)); 
	}
	
	static double squareQuadrangle(int x, int y, int z, int t) {
		double s1 = squareRightTriangle(x, y);
		double hypotenuse = Math.sqrt(x * x + y * y);
		double s2 = formGerona(hypotenuse, z, t);
		return s1 + s2;
	}
	
	static void ninth(int x, int y, int z, int t) {
		/**
		 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади, 
		 * если угол между сторонами длиной X и Y— прямой. 
		 */
		System.out.println("Девятое упражнение. Исходные данные");
		System.out.println("x= " + x + ", y= " + y + ", z= " + ", t= " + t);
		System.out.println("Площадь четырёхугольника " + squareQuadrangle(x, y, z, t));
	}

	static int[] getDigits(long n) {
		String s = new String("" + n);
		int dig[] = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			dig[i] = Integer.parseInt(s.substring(i, i+1));
		}
		return dig;
	}
	
	static void tenth(int n) {
		/**
		 * Дано  натуральное  число  N.  Написать  метод(методы)  для  формирования  массива,  элементами  которого 
		 * являются цифры числа N. 
		 */
		System.out.println("Десятое упражнение. N= " + n);
		if(n < 0) {
			System.out.println("Число не натуральное");
			return;
		}
		System.out.println("Число состоит из цифр");
		printArray(getDigits(n));
	}
	
	static boolean compareNum(int fir, int sec) {
		String s1 = new String("" + Math.abs(fir));
		String s2 = new String("" + Math.abs(sec));
		if(s1.length() > s2.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	static void eleventh(int fir, int sec) {
		/**
		 * Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
		 */
		System.out.println("Одинадцатое упражнение. Числа " + fir + " " + sec);
		if(compareNum(fir, sec)) {
			System.out.println("Колчиство цифр больше в первом числе");
		} else if(compareNum(sec, fir)) {
			System.out.println("Количество цифр больше во втором числе");
		} else { 
			System.out.println("Количество цифр в двух числах равны");
		}
	}
	
	static boolean isPrime(int n) {
		if(n <= 1) {return false;}
		if(n <= 3) {return true;}
		if(n % 2 == 0 || n % 3 == 0) {return false;}
		int i = 5;
		while(i * i <= n) {
			if(n % i == 0 || i % (n+2) == 0) {
				return false;
			}
			i += 6;
		}
		return true;
	}
	
	static void thirteenth(int n) {
		/**
		 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43). 
		 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для 
		 * решения задачи использовать декомпозицию.
		 */
		System.out.println("Тринадцатое упражнение. n = " + n);
		if(n < 3) {
			System.out.println("Заданное число должно быть больше 2");
			return;
		}
		for(int i = n; i < 2 * n - 2; i++) {
			if(isPrime(i)) {
				if(isPrime(i+2)) {
					System.out.println("Числа " + i + " и " + (i+2) + " близнецы");
				}
			}
		}
	}
	
	static boolean isAmstrong(int n) {
		int sum = 0;
		int[] dig = getDigits(n);
		int len = dig.length;
		for(int i = 0; i < len; i++) {
			sum += dig[i];
		}
		if(Math.pow(sum, len) == n) {
			return true;
		} else {
			return false;
		}
	}
	
	static void fourteenth(int k) {
		/**
		 * Натуральное  число,  в  записи  которого  n  цифр,  называется  числом  Армстронга,  если  сумма  его  цифр, 
		 * возведенная  в  степень  n,  равна  самому  числу.  Найти  все  числа  Армстронга  от  1  до  k.  Для  решения  задачи 
		 * использовать декомпозицию. 
		 */
		System.out.println("Четырнадцатое упражнение. k = " + k);
		if(k < 0) {
			System.out.println("Число не натуральное");
			return;
		}
		for(int i = 1; i <= k; i++) {
			if(isAmstrong(i)) {
				System.out.println(i + " число Амстронг");
			}
		}
	}
	
	static void twelfth(int k, int n) {
		/**
		 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого 
		 * являются числа, сумма цифр которых равна К и которые не большее N. 
		 */
		System.out.println("Девнадцатое упражнение. K= " + k + ", N= " + n);
		if(k < 0 || n < 0) {
			System.out.println("Заданано не натуральное число");
			return;
		}
		int[] a = new int[10];
		int len = 0;
		int[] dig;
		for(int i = 0; i < n; i++) {
			if(i < 10 && i == k) {
				a[len] = i;
				len++;
			} else {
				dig = getDigits(i);
				int sum = sumOfArrElem(dig);
				if(sum == k) {
					a[len] = i;
					len++;
				}
			}
			if(len == a.length) {		// расширение массива
				a = grow(a);
			}			
		}
		a = Arrays.copyOf(a, len);
		printArray(a);
	}
	
	static int sumOfArrElem(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	static int[] grow(int[] a) {
		return Arrays.copyOf(a, a.length + 10);
	}
	
	static void fifteenth(int n) {
		/**
		 * Найти  все  натуральные  n-значные  числа,  цифры  в  которых  образуют  строго  возрастающую 
		 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию. 
		 */
		System.out.println("Пятнадцатое упражнение. N= " + n);
		if(n <= 0) {
			System.out.println("N <= 0");
			return;
		}
		printArray(getNum(n));
	}
		
	static long[] getNum(int n) {
			long[] a = new long[n * 10];
			int ind = 0;
			for(long i = (long)(Math.pow(10, n-1)); i < (long)(Math.pow(10, n)); i++) {
				int[] dig = getDigits(i);
				if(isIncreasing(dig)) {
					a[ind] = i;
					ind++;
				}
				if(ind == a.length) {
					a = Arrays.copyOf(a, ind + 10);
				}
			}
			a = Arrays.copyOf(a, ind);
			return a;
		}
	
	static boolean isIncreasing(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] >= a[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	static void printArray(long[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.printf("%3d ", a[i]);
		}
		System.out.println();
	}
	
	static void sixteenth(int n) {
		/**
		 * Hаписать  программу,  определяющую  сумму  n  -  значных  чисел,  содержащих  только  нечетные  цифры. 
		 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
		 */
		System.out.println("Шестнадцатое упражнение. N= " + n);
		if(n <= 0) {
			System.out.println("N <= 0");
			return;
		}
		getNumWithOddDig(n);
		
	}
	
	static void getNumWithOddDig(int n) {
		int[] dig;
		long sum = 0;
		for(long i = (long)(Math.pow(10, n-1)); i < (long)(Math.pow(10, n)); i++) {
			dig = getDigits(i);
			if(isOddDigits(dig)) {
				System.out.print(i + " ");
				sum += i;
			}
		}
		System.out.println("\nСумма = " + sum);
		System.out.println("Количство четных цифр в найденной сумме равна " + getQtyEvenDigits(sum));
	}
	
	static boolean isOddDigits(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] % 2 == 0) {
				return false;
			}
		}
		return true;
	}
	
	static int getQtyEvenDigits(long num) {
		int[] dig = getDigits(num);
		int qty = 0;
		for(int i = 0; i < dig.length; i++) {
			if(dig[i] % 2 == 0) {
				qty++;
			}
		}
		return qty;
	}
	
	static void seventeenth(int n) {
		/**
		 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких 
		 * действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию. 
		 */
		System.out.println("Семнадцатое упражнение. N= " + n);
		if(n < 0) {
			System.out.println("n < 0, вычитая сумму, 0 не получим");
			return;
		}
		if(n == 0) {
			System.out.println("Требуется 0 действий");
			return;
		}
		int sum = getSumDig(n);
		int qty = 0;
		while(n >= 0) {
			n -= sum;
			qty++;
		}
		System.out.println("Требуется " + qty + " действий");
	}
	
	static int getSumDig(int n) {
		int[] dig = getDigits(n);
		int sum = 0;
		for(int i = 0; i < dig.length; i++) {
			sum += dig[i];
		}
		return sum;
	}
}
