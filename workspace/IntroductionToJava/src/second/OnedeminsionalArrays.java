package second;

import java.util.ArrayList;
import java.util.List;

/**
 * Одномерные массивы
 * @author Dima Zosimov
 *
 */
public class OnedeminsionalArrays {

	public static void main(String[] args) {
		
		int [] a = {1,2,30,22,15,26,3,5,39,6, 22, 22, 22, 15, 15,15,15,15};
		double [] b = {-2, 3.1, 4, -10, -2.1, -5, 3, 2, 8.1};
		double [] c = {-10, 2, 5, 2.1, -5.4, -8, 0, 10, 4.2, -3.1};
		first(a, 3);
		second(b, 2.01);
		third(c);
		fourth(c);
		fifth(a);
		sixth(c);
		eighth(a);
		ninth(a);
		tenth(a);
	}
	
	static void first(int[] array, int k) {
		/**
		 * В массив A [N] занесены натуральные числа. 
		 * Найти сумму тех элементов, которые кратны данному К.
		 */
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] % k == 0 ) {
			sum += array[i];
			}
		}
		System.out.println("Первое упражнение. Сумма = " + sum);
	}
	
	static void second(double[] a, double z) {
		/**
		 * Дана последовательность действительных чисел а 1  ,а 2  ,..., а п. Заменить все ее члены, большие данного Z, 
		 * этим числом. Подсчитать количество замен. 
		 */
		int index = 0;
		System.out.println("Второе упраженение. Исходная последовательность");
		for(int i = 1; i < a.length; i++) {
			System.out.print(a[i] + " ");
			if(a[i] > z) {
				a[i] = z;
				index++;
			}
		}
		System.out.println("Результат замен (Z = " + z + ")");
		for(double i : a) {
			System.out.print(i + " ");
		}
		System.out.println("количество замен = " + index);
	}
	
	static void third(double[] a) {
		/**
		 * Дан  массив  действительных  чисел,  размерность  которого  N.  Подсчитать,  
		 * сколько  в  нем  отрицательных, положительных и нулевых элементов. 
		 */
		int indpl = 0;
		int indmi = 0;
		int indze = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > 0) {
				indpl++;
			} else if(a[i] < 0) {
				indmi++;
			} else {
				indze++;
			}
		}
		System.out.println("Третье упражнение.");
		for(double i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\nКоличество положительных " + indpl);
		System.out.println("Количество отрицательных " + indmi);
		System.out.println("Количество нулевых " + indze);
		
	}
	
	static void fourth(double[] a) {
		/**
		 * Даны действительные числа а 1  ,а 2  ,..., а n  . 
		 * Поменять местами наибольший и наименьший элементы. 
		 */
		double max = a[0], min = a[0];
		int imax = 0, imin = 0;
		System.out.println("Четвёртое упражнение. Исходный массив");
		for(double i : a) {
			System.out.print(i + " ");
		}
		for(int i = 1; i < a.length; i++) {
			if(max < a[i]) {
				imax = i;
				max = a[i];
			}
			if(min > a[i]) {
				imin = i;
				min = a[i];
			}
		}
		a[imin] = max;
		a[imax] = min;
		System.out.println("\nПосле перестановки");
		for(double i : a) {
			System.out.print(i + " ");
		}
	}
	
	static void fifth(int [] a) {
		/**
		 * Даны целые числа а 1  ,а 2  ,..., а n. Вывести на печать только те числа, для которых а i  > i. 
		 */
		System.out.println("Пятое упражнение.");
		for(int i = 0; i < a.length; i++) {
			if(a[i] > i) {
				System.out.println(a[i] + " > " + i);
			}
		}
	}
	
	static void sixth(double[] a) {
		/**
		 * Задана  последовательность  N  вещественных  чисел.  Вычислить  сумму  чисел,  
		 * порядковые  номера  которых являются простыми числами. 
		 */
		List<Integer> prost = new ArrayList<>();
		prost.add(1);
		boolean is = true;
		for(int i = 2; i < a.length; i++) {
			for(int j = 2; j < i-1; j++) {
				if(i % j == 0) {
					is = false;
				}
			}
			if(is) {
				prost.add(i);
			}
			is = true;
		}
		System.out.println("Шестое упражнение.");
		for(int i : prost) {
			System.out.println(a[i] + " index " + i);
		}
	}
	
	static void eighth(int[] a) {
		/**
		 * Дана  последовательность  целых  чисел a1,a2,...an.  Образовать  новую  последовательность,  
		 * выбросив  из исходной те члены, которые равны  min(a1, a2, ..., an). 
		 */
		int min = a[0];
		int qty = 0;
		for(int i = 1; i < a.length; i++) {
			if(min > a[i]) {
				min = a[i];
				qty = 0;
			}
			if(min == a[i]) {
				qty++;
			}
		}
		int[] newA = new int[a.length - qty - 1];
		qty = 0;
		for(int i = 0; i < a.length; i++) {
			if(min != a[i]) {
				newA[qty] = a[i];
				qty++;
			}
		}
		System.out.println("Восьмое задание. Исходный массив");
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\nНовый массив");
		for(int i : newA) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static void ninth(int[] a) {
		/**
		 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
		 * Если таких чисел несколько, то определить наименьшее из них. 
		 */
		int qty = 0, num; 
		int result = 0, resnum = a[0];
		List<Integer> numbers = new ArrayList<Integer>(); //числа, которые уже считались (чтобы не считать те же числа снова)
		for(int i = 0; i < a.length-1; i++) {
			num = a[i];
			System.out.println("Число " + num);
			if(numbers.contains(num)) {
				continue; //если число есть в листе, значит мы его уже встречали
			} else {
				numbers.add(num);
				for(int j = i+1; j < a.length; j++) {
					if(num == a[j]) {
						qty++;
					}
				}
				if(result < qty) {
					result = qty;
					resnum = num;
				}else if(result == qty && resnum > num) {
						resnum = num;
				}
				qty = 0;
			}
		}
		System.out.println("Девятое упражнение. Самое встречаемое число:\n" + resnum);
		System.out.println("Встречается " + result + "раз(а)");
	}
	
	static void tenth(int[] a) {
		/**
		 * Дан  целочисленный  массив  с  количеством  элементов  п.  
		 * Сжать  массив,  выбросив  из  него  каждый  второй элемент 
		 * (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать. 
		 */
		int j = 1;
		System.out.println("Десятое упражнение. Исходный массив");
		for(Integer i : a) {
			System.out.print(i + " ");
		}
		for(int i = 2; i < a.length; i += 2) {
			a[j] = a[i];
			j++;
		}
		for(int i = j; i < a.length; i++) {
			a[i] = 0;
		}
		System.out.println("\nИтоговый массив");
		for(Integer i : a) {
			System.out.print(i + " ");
		}
	}

}
