package second;

import java.util.Arrays;

public class Sorting {
	/**
	 * 	Одномерные массивы. Сортировки
	 * @author Dima Zosimov
	 * 
	 */
	public static void main(String[] args) {
		int[] a = createArray(10);
		int[] b = createArray(10);
		System.out.println("Массив A");
		printArray(a);
		System.out.println("Массив B");
		printArray(b);
		
		first(a, b, 5);
		second(a, b);
		third(a);
		fourth(b);
		fifth(b);
		sixth(a);
		seventh(a, b);
		eighth(a, b);
		
	}
	
	static int[] createArray(int len){
		int[] array = new int[len];
		for(int i = 0; i < len; i++) {
			array[i] = (int)(Math.random() * 50);
		}
		return array;
	}
	
	static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%3d ", array[i]);
		}
		System.out.println();
	}
	
	static void first(int[] a, int[] b, int k) {
		/**
		 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в 
		 * один  массив,  включив  второй  массив  между  k-м  и  (k+1)  -  м  элементами  первого,  при  этом  не  используя 
		 * дополнительный массив.
		 */
		System.out.println("Первое упражнение");
		System.out.println("k = " + k);
		if(k > a.length) {
			throw new IndexOutOfBoundsException();
		}
		
		a = Arrays.copyOf(a, a.length + b.length);
		// сдвинем сразу все элементы начиная с k+1 в конец массива
		System.arraycopy(a, k+1, a, k+1+b.length, a.length- b.length - k - 1);
		// вставим массив b в этот промежуток
		System.arraycopy(b, 0, a, k+1, b.length);
		printArray(a);
		
	}
	
	static void second(int[] a, int[] b) {
		/**
		 * Даны две последовательности a1<=a2<=...<=an и b1<=b2<=...<=bm.
		 *  Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. 
		 *  Примечание. Дополнительный массив не использовать.
		 */
		System.out.println("Второе упражнение");
		a = getUnitedArray(a, b);
		printArray(a);
	}
	
	static int[] getUnitedArray(int[] a, int[] b) {
		a = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, a, a.length - b.length, b.length);
		TwodimensionalArrays.quickSort(a, 0, a.length-1);
		return a;
	}
	
	static void seventh(int[] a, int[] b) {
		/**
		 * Пусть  даны  две  неубывающие  последовательности  действительных  чисел 
		 * a1<=a2<=...<=an и b1<=b2<=...<=bm.
		 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1<=b2<=...<=bm
		 * в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
		 */
		System.out.println("Седьмое упражнение");
		TwodimensionalArrays.quickSort(a, 0, a.length-1);
		TwodimensionalArrays.quickSort(b, 0, b.length-1);
		System.out.println("Последовательность А");
		printArray(a);
		System.out.println("Псоледовательность В");
		printArray(b);
		int indexB = 0;
		for(int i = 0; i < a.length; i++) {
			while(indexB < b.length && a[i] > b[indexB]) {
				System.out.println("элемент b" + indexB + "=" + b[indexB] + " необходимо вставить в ячейку " +
			(i + indexB));
				indexB++;
			}
		}
		while(indexB < b.length) { //это если остались элементы b, которые больше всех a
			System.out.println("элемент b" + indexB + "=" + b[indexB] + " необходимо вставить в ячейку " +
					(a.length + indexB));
						indexB++;
		}
		printArray(getUnitedArray(a, b));
	}

	static void eighth(int[] p, int[] q) {
		/**
		 * Даны дроби p1/q1, p2/q2,..., pn/qn (pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему 
		 * знаменателю и упорядочивает их в порядке возрастания. 
		 */
		System.out.println("Восьмое упражнение. Исходные дроби");
		if(p.length != q.length) {
			System.out.println("Количество числителей и знаменателей не равны");
			return;
		}
		long[] pp = new long[p.length];
		long[] qq = new long[q.length];
		printFraction(p, q);
		long znam = 1;
		for(int i = 0; i < q.length; i++) { 
			qq[i] = q[i];
			pp[i] = p[i];
		}
		for(int i = 0; i < qq.length; i++) {
			for(int j = 0; j < pp.length; j++) {
				if(i != j) {
					pp[j] *= qq[i];
				}
			}
			znam *= qq[i];
		}
		for(int i = 0; i < qq.length; i++) { 
			qq[i] = znam;
		}
		Arrays.sort(pp);
		
		System.out.println("\nОтвет");
		printFraction(pp, qq);
	}
	
	static void printFraction(long[] p, long[] q) {
		for(int i = 0; i < p.length; i++) {
			System.out.printf("%d/%d ", p[i], q[i]);
		}
	}
	
	static void printFraction(int[] p, int[] q) {
		for(int i = 0; i < p.length; i++) {
			System.out.printf("%d/%d ", p[i], q[i]);
		}
	}
	
	static void third(int[] array) {
		/**
		 *  Сортировка выбором.
		 */
		System.out.println("Третье упражнение. Исходный массив");
		printArray(array);
		long start = System.nanoTime();
		array = selectionSortDescending(array);
		long finish = System.nanoTime();
		System.out.println("Сортировка вставками по убыванию");
		printArray(array);
		System.out.println("Время затраченное на выполнение " + (finish - start) + " наносекунд");
	}
	
	static int[] selectionSortDescending(int[] array) {
		int max;
		int indexMax;
		for(int i = 0; i < array.length-1; i++) {
			max = array[i];
			indexMax = i;
			/*
			 * находим индекс макс, но не меняем сразу, так как возможно несколько раз менять
			 *  а суть задания менять первый элемент с максимальным,а не с каждым, который больше его
			 */
			for(int j = i+1; j < array.length; j++) { 	
				if(max < array[j]) {
					indexMax = j;
					max = array[j];
				}
			}
			
			if(indexMax != i) {
				max = array[indexMax];
				array[indexMax] = array[i];
				array[i] = max;
			}
		}
		return array;
	}
	
	static int[] bubbleSort(int[] a) {
		boolean isSorted = true;
		int i = 0;
		int obm = 0;
		int tmp;
		while(isSorted) {
			isSorted = false;
			for(int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j+1]) {
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					isSorted = true;
					obm++;
				}
			}
			i++;
		}
		System.out.println("Количество обменов равно " + obm);
		return a;
	}
	
	static void fourth(int[] a) {
		/**
		 * Сортировка обменами
		 */
		System.out.println("Четвёртое упражнение. Исходный массив");
		printArray(a);
		System.out.println("Сортировка обменами");
		long start = System.nanoTime();
		a = bubbleSort(a);
		long finish = System.nanoTime();
		printArray(a);
		System.out.println("Время затраченное на выполнение " + (finish - start) + " наносекунд");
	}
	
	static int binSearch(int[] a, int fromIndex, int toIndex, int key) {
		int l = fromIndex - 1;
		int r = toIndex;
		while(l < (r-1)) {
			int m = (l + r)/2;
			if(a[m] < key) {
				l = m;
			}else {
				r = m;
			}
		}
		return r;
	}
	
	static int[] insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int j = i - 1;
			int insertPlace;
			if(a[j] > a[i]) {
				int tmp = a[i];
				insertPlace = binSearch(a, 0, j, tmp); //Arrays.binarySearch(a, 0, j, tmp)
				if(insertPlace < 0) {
					insertPlace = Math.abs(insertPlace) - 1;
					//System.arraycopy(a, insertPlace, a, ~insertPlace + 1, i - ~insertPlace);
					//a[~insertPlace] = tmp;
					System.arraycopy(a, insertPlace, a, insertPlace + 1, i - insertPlace);
					a[insertPlace] = tmp;
				} else {
					System.arraycopy(a, insertPlace, a, insertPlace + 1, i - insertPlace);
					a[insertPlace] = tmp;
				}
			}
			
		}
		return a;
	}
	
	static void fifth(int[] a) {
		/**
		 * Сортировка вставками
		 */
		System.out.println("Пятое упражненеи. Исходный массив");
		printArray(a);
		System.out.println("Сортировка вставками");
		long start = System.nanoTime();
		a = insertionSort(a);
		long finish = System.nanoTime();
		printArray(a);
		System.out.println("Время затраченное на выполнение " + (finish - start) + " наносекунд");
	}
	
	static int[] sortShell(int[] a){
		   int j, k, h, m=0;
		   int[] d = { 1, 4, 8, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901, 		//шаги
		               84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
		               58548857, 157840433, 410151271, 1131376761, 2147483647 };
		   while (d[m] < a.length) {		// выбор шага
			   ++m;
		   }
		   while (--m >= 0){
		      k = d[m];
		      for (int i = k; i < a.length; i++){     
		         j=i;
		         h=a[i];
		         while ((j >= k) && (a[j-k] > h)){
		              a[j]=a[j-k];
		              j -= k;
		         }
		         a[j] = h;
		      }
		   }
		   return a;
		}
	
	static void sixth(int[] a) {
		/**
		 * Сортировка Шелла
		 */
		System.out.println("Шестое упражненеи. Исходный массив");
		printArray(a);
		System.out.println("Сортировка Шелла");
		long start = System.nanoTime();
		a = sortShell(a);
		long finish = System.nanoTime();
		printArray(a);
		System.out.println("Время затраченное на выполнение " + (finish - start) + " наносекунд");
	} 
		
}
