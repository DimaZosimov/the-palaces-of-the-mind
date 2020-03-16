package second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	/**
	 * Задачи. Массивы массивов
	 * @author Dima Zosimov
	 *
	 */
public class TwodimensionalArrays {

	public static void main(String[] args) {
		int rows = 10, columns = 10;
		int[][] matrix = createMatrix(rows, columns);
		int[][] posMatrix = createPositiveMatrix(rows, columns, 100);
		System.out.println("Исходная матрица");
		printMatrix(matrix);
		first(matrix);
		second(matrix);
		third(matrix, 3, 4);
		fourth(6);
		fifth(6);
		sixth(6);
		seventh(6);
		eighth(matrix);
		ninth(posMatrix);
		tenth(matrix);
		eleventh();
		twelfth(matrix);
		thirteenth(matrix);
		fourteenth();
		fifteenth(matrix);
		sixteenth(4);
		
		
		
	}
	static int[][] createMatrix(int rows, int columns, int num){
		/**
		 * Создает матрицу с числами в интервале [-num; num]
		 */
		int[][] matrix = new int[rows][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 2 * num - num);
			}
		}
		return matrix;
	}
	
	static int[][] createMatrix(int rows, int columns){
		/**
		 * Создает матрицу с числами в интервале [-100; 100]
		 */
		int num = 100;
		int[][] matrix = createMatrix(rows, columns, num);
		return matrix; 
	}
	
	static int[][] createPositiveMatrix(int rows, int columns, int num){
		/**
		 * Создает положительную матрицу
		 */
		int[][] matrix = new int[rows][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * num);
			}
		}
		return matrix;
	}
	
	static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	static void printDoubleMatrix(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%5.2f ", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	static void first(int[][] matrix) {
		/**
		 * Дана матрица. Вывести на экран все нечетные столбцы,
		 *  у которых первый элемент больше последнего. 
		 */
		/*
		 * в нечётных столбцах сравниваем первый и последний элемент 
		 * если условие выполнено, записываем в лист весь столбец в качестве одномерного массива 
		 * после создаем новую матрицу и заполняем элементы с полученного листа 
		 */
		
		List<int[]> arrays = new ArrayList<>();
		int[] array = new int[matrix.length];
		for(int j = 0; j < matrix.length; j += 2) {
			if(matrix[0][j] > matrix[matrix.length-1][j]) {		
				for(int i = 0; i < matrix.length; i++) {
					array[i] = matrix[i][j];
				}
				arrays.add(array);								
				array = new int[matrix.length];
			}
		}
		int col = arrays.size();
		int rows = matrix.length;
		int[][] newMatrix = new int[rows][col];
		for(int j = 0; j < col; j++) {
			int[] arr = arrays.get(j);
			for(int i = 0; i < rows; i++) {
				newMatrix[i][j] = arr[i];
			}
		}
		System.out.println("Первое упражнение.");
		if(newMatrix.length == 0) {
			System.out.println("Во всех нечетных столбцах первый элемент меньше последнего. Нечего выводить");
		}else {
		printMatrix(newMatrix);
		}
	}

	static void second(int[][] matrix) {
		/**
		 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали. 
		 */
		System.out.println("Второе упражнение");
		int j = 0;
		int k = matrix.length-1;
		for(int i = 0; i < matrix.length; i++) {
			if(j != k) {
				System.out.print(matrix[i][j] + " " + matrix[i][k] + " ");
			} else {
				System.out.print(matrix[i][j] + " ");
			}
			j++;
			k--;
		}
	}

	static void third(int[][] matrix, int k, int p) {
		/**
		 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы. 
		 */
		System.out.println("Третье упражнение");
		System.out.println(k + "-ая строка");
		for(int i = 0; i < matrix.length; i++) {
			System.out.printf("%3d ", matrix[k-1][i]);
		}
		System.out.println("\n" + p + "-ыйстолбец");
		for(int i =0; i < matrix[k].length; i++) {
			System.out.printf("%3d ", matrix[i][p-1]);
		}
	}

	static void fourth(int n) {
		/**
		 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		 */
		System.out.println("Четвёртое упражнение");
		int[][] matrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = j+1;
				}
			} else {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = n-j;
				}
			}
		}
		
		printMatrix(matrix);
	}
	
	static void fifth(int n) {
		/**
		 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		 */
		System.out.println("Пятое упражнение");
		int[][] matrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-i; j++) {
				matrix[i][j] = i+1;
			}
		}
		printMatrix(matrix);
	}
	
	static void sixth(int n) {
		/**
		 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		 */
		System.out.println("Шестое упражнение");
		int [][] matrix = new int [n][n];
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n-i; j++) {
				matrix[i][j] = 1;
			}
			for(int k = n-1-i; k >= i; k--) {
				matrix[n-i-1][k] = 1;
			}
		}
		printMatrix(matrix);
	}
	
	static void seventh(int n) {
		/**
		 * Сформировать квадратную матрицу порядка N по правилу:  
		 * A[I,J] = sin((I^2 - J^2) / N)
		 * и подсчитать количество положительных элементов в ней. 
		 */
		System.out.println("Седьмое упражнение");
		int qty = 0;
		if(n <= 0) {
			System.out.println("число n меньше или равно 0");
			return;
		}
		double [][] matrix = new double[n][n];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2))/n);
				if(matrix[i][j] > 0) {
					qty++;
				}
			}
		}
		printDoubleMatrix(matrix);
		System.out.println("Количество положительных элементов " + qty);
		
	}
	
	static void eighth(int[][] matrix) {
		/**
		 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить 
		 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит 
		 * пользователь с клавиатуры. 
		 */
		System.out.println("Восьмое упражнение. Введите номера столбцов через Enter (число от 1 до " + matrix.length + ")");
		int col1 = scanInt();
		int col2 = scanInt();
		if(col1 > matrix.length || col2 > matrix.length) {
			System.out.println("Введенное число больше числа столбцов в матрице");
			return;
		}
		if (col1 == col2) {
			System.out.println("Требуется поменять местами один и тот же столбец местами? Хм, получайте...");
			printMatrix(matrix);
			return;
		}
		int n;
		for(int i = 0; i < matrix.length; i++) {
			n = matrix[i][col1-1];
			matrix[i][col1-1] = matrix[i][col2-1];
			matrix[i][col2-1] = n;
		}
		printMatrix(matrix);
		
	}
	
	static int scanInt() {
		int num;
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		return num;
	}
	
	static void ninth(int[][] matrix) {
		/**
		 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой 
		 * столбец содержит максимальную сумму. 
		 */
		int sum = 0;
		int maxSum = 0;
		int col = 0;
		System.out.println("Девятое упражнение. Исходная матрица для девятого упражнения");
		printMatrix(matrix);
		for(int j = 0; j < matrix[0].length; j++) {
			for(int i = 0; i < matrix.length; i++) {
				sum += matrix[i][j];
			}
			System.out.println(j+1 + " cтолбец - сумма " + sum);
			if(maxSum < sum) {
				col = j+1;
				maxSum = sum;
			}
		}
		System.out.println("Столбец " + col + " содержит максимальную сумму" );
	}
	
	static void tenth(int [][] matrix) {
		/**
		 * Найти положительные элементы главной диагонали квадратной матрицы. 
		 */
		System.out.println("Десятое упражнение");
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][i] > 0) {
				System.out.print(matrix[i][i] + " ");
			}
		}
	}
	
	static void eleventh() {
		/**
		 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в 
		 * которых число 5 встречается три и более раз. 
		 */
		int[][] matrix = createPositiveMatrix(10, 20, 15);
		System.out.println("Одинадцатое упражнение");
		printMatrix(matrix);
		int qty = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 5) {
					qty++;
				}
			}
			if(qty > 2) {
				System.out.println(i+1 + " строка - число 5 встречается " + qty + " раз(а)");
			}
			qty = 0;
		}
	}
	
	static void twelfth(int[][]matrix) {
		/**
		 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов. 
		 */
		System.out.println("Двенадцатое упражнение");
		System.out.println("По возрастанию");
		for(int i = 0; i < matrix.length; i++) {
			quickSort(matrix[i], 0, matrix.length-1);
		}
		printMatrix(matrix);
		System.out.println("По убыванию");
		for(int i = 0; i < matrix.length; i++) {
			quickSortDescending(matrix[i], 0, matrix.length-1);
		}
		printMatrix(matrix);
	}
	public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
}
	
	static void quickSortDescending(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент больше, чем pivot
            while (source[leftMarker] > pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент меньше, чем pivot
            while (source[rightMarker] < pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет больше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSortDescending(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSortDescending(source, leftBorder, rightMarker);
        }
}

	static void thirteenth(int [][] matrix) {
		/**
		 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов. 
		 */
		System.out.println("Тринадцатое упражнение");
		System.out.println("По возрастанию");
		matrix = transposeMatrix(matrix);
		for(int i = 0; i < matrix.length; i++) {
			quickSort(matrix[i], 0, matrix.length-1);
		}
		printMatrix(transposeMatrix(matrix));
		System.out.println("По убыванию");
		for(int i = 0; i < matrix.length; i++) {
			quickSortDescending(matrix[i], 0, matrix.length-1);
		}
		printMatrix(transposeMatrix(matrix));
	}
	
	static int[][] transposeMatrix(int [][] matrix){
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[j][i] = matrix[i][j];
			}
		}
		return newMatrix;
	}
	
	static void fourteenth() {
		/**
		 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число 
		 * единиц равно номеру столбца. 
		 */
		System.out.println("Четырнадцатое упражнение");
		int m = (int)(Math.random()*19 + 1);
		int n = (int)(Math.random()*19 + 1);
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(j >= i) {
					matrix[i][j] = 1;
				} else {
					continue;
				}
			}
		}
		printMatrix(matrix);
		
	}
	
	static void fifteenth(int[][] matrix) {
		/**
		 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него. 
		 */
		int max = maxElement(matrix);
		System.out.println("Пятнадцатое упражнение.");
		int cht = 1;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(cht % 2 != 0) {
					matrix [i][j] = max;
				}
				cht++;
			}
		}
		printMatrix(matrix);
	}
	static int maxElement(int[][] matrix) {
		if(matrix.length == 0) {
			throw new NullPointerException();
		}
		int max = matrix[0][0];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}
		return max;
	}
	
	static void sixteenth(int n) {
		/**
		 * Магическим квадратом порядка n называется квадратная матрица размера nxn, 
		 * составленная из чисел 1, 2, 3, ..., n^2 так, что суммы по каждому столбцу, 
		 * каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат. 
		 */
		System.out.println("Упражнение шестнадцатое. Магический квадрат " + n + "-го порядка");
		int [][] matrix = new int[n][n];
		if(n <= 2) {
			System.out.println("Магические квадраты возможно построить от 3-го порядка и выше");
			return;
		}
		int c = 1;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] = c;
				c++;
			}
		}
		System.out.println("Исходная матрица");
		printMatrix(matrix);
		System.out.println("Магический квадрат");
		if(n % 2 != 0) {
			matrix = magBoxOdd(matrix);
		} else {
			matrix = magBoxEven(matrix);
		}
		printMatrix(matrix);
	}
	
	static int[][] magBoxOdd(int [][] matrix) { 	// метод терраса
		int len = matrix.length;
		int [][] newMatrix = new int[len][len];
		int mid = (len - 1)/2;
		int k, d;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				k = i + mid - j;
				d = j - mid + i;
				if(k < 0) { k = len + k;}
				if(k > (len - 1)) { k = k - len;}
				if(d < 0) { d = len + d;}
				if(d > (len - 1)) { d = d - len;}
				newMatrix[k][d] = matrix[i][j];
			}
		}
		return newMatrix;
	}
	
	static int[][] magBoxEven(int[][] matrix){ 		// метод рауз-болла
		boolean is = true;							// true - оставляем элемент, false - меняем
		int[][] magBox = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			is = change(is, i);
			for(int j = 0; j < matrix.length; j++) {
				is = change(is, j);
				if(is) {
					magBox[i][j] = matrix[i][j];
				} else {
					magBox[i][j] = matrix[matrix.length - 1 -i][matrix.length - 1 - j];
				}
			}
		}
		return magBox;
	}
	
	static boolean change(boolean is, int i) { // каждая нечетный столбец/строка меняет значение is
		if(i % 2 != 0) {
			if(is) {
				is = false;
			} else {
				is = true;
			}
			return is;
		} else {
			return is;
		}
	}
	
	
	
}
