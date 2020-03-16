package first;

/**
 * Циклы
 * @author Dima Zosimov
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Cycles {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
		first(scan);
		second(-2, 4, 1);
		third();
		fourth();
		fifth(0.1);
		sixth();
		seventh(scan);
		eighth(34310, 21543);}

	}
	
	//упражнение 1
	static void first(Scanner scan) {
		/**
		 * Напишите программу, где пользователь вводит любое целое положительное число. 
		 * А программа суммирует все числа от 1 до введенного пользователем числа. 
		 */
		System.out.println("Первое упражнение. Введите число");
		int a = scan.nextInt();
		int sum = 0;
		for(int i = 1; i <= a; i++) {
			sum = sum + i;
		}
		System.out.println("Ответ: " + sum);
	}
	
	//упражнение 2
	static void second(double a, double b, double h) {
		/**
		 * Вычислить значения функции на отрезке [а,b] c шагом h:
		 */
		double x;
		System.out.printf("Второе упражнение. Отрезок [%.2f;%.2f], шаг h=%.2f. Ответ:%n", a, b, h);
		for(x = a; x <= b;x+=h) {
			if(x <= 2) {
				System.out.println("y= " + -x + " при x=" + x);
			} else {
				System.out.println("y= " + x + " при x=" + x);
			}
		}
	}
	
	//упражнение 3
	static void third() {
		/**
		 * Найти сумму квадратов первых ста чисел. 
		 */
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum+= i*i;
		}
		System.out.println("Третье упражнение. Ответ:\n" + sum);
	}
	
	//упражнение 4
	static void fourth() {
		/**
		 * Составить программу нахождения произведения квадратов первых двухсот чисел. 
		 */
		BigInteger p = BigInteger.valueOf(1);
		for(int i = 1; i <= 200; i++) {
			p = p.multiply(BigInteger.valueOf(i*i));
		}
		System.out.println("Четвертое упражнение. Ответ:\n" + p);
	}
	
	//упражнение 5
	static void fifth(double e) {
		/**
		 * Даны  числовой  ряд  и  некоторое  число  е.  Найти сумму тех членов  ряда,  
		 * модуль  которых  больше  или  равен заданному е. Общий член ряда имеет вид: 
		 * a = 1/2^n + 1/3^n
		 */
		double a;
		int n = 1;
		double sum = 0;
		a = 1/Math.pow(2, n) + 1/Math.pow(3, n);
		while(e <= Math.abs(a)) {
			sum += a;
			n++;
			a = 1/Math.pow(2, n) + 1/Math.pow(3, n);
		}
		System.out.println("Пятое упражнение. Ответ при e=" + e + ":\n" + sum);
	}
	
	//упражнение 6
	static void sixth() {
		/**
		 * Вывести на экран соответствий между символами и 
		 * их численными обозначениями в памяти компьютера.
		 */
		System.out.println("Шестое упражнение.");
		for(int i = 0; i <= 255; i++) {
			if(i%10 == 0) {
				System.out.println();
			}
			System.out.print((char)i);
		}
	}
	
	//упражнение 7
	static void seventh(Scanner scan) {
		/**
		 * Для каждого натурального числа в промежутке от m до n вывести все делители, 
		 * кроме единицы и самого числа. m и n вводятся с клавиатуры.
		 */
		System.out.println("\nСедьмое упражнение. Введите m и n");
		int m = scan.nextInt();
		int n = scan.nextInt();
		int min = Math.min(m, n);
		int max = Math.max(m, n);
		for(int i = min; i <= max; i++) {
			System.out.println("Делители числа " + i);
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
	
	//упражнение 8
	static void eighth(int a, int b) {
		/**
		 * Даны два числа. Определить цифры, входящие в запись как первого так и второго числа. 
		 */
		String sa = Integer.toString(a);
		String sb = Integer.toString(b);
		System.out.println("Восьмое упражнение. Даны числа: " + a + " и " + b);
		String [] array = {"1","2","3","4","5","6","7","8","9","0"};
		for(int i = 0; i < array.length; i++) {
			String number = array[i];
			if(sa.contains(number) && sb.contains(number)) {
				System.out.print(number + " ");
			}
		}
	}
}
