package third;

/**
 * Работа со строкой как с объектом типа String или StringBuilder
 * @author Dima Zosimov
 *
 */

public class ObjectString {

	public static void main(String[] args) {
		
		String s = "Дан текст    (строка). Найдите наибольшее       количество подряд   идущих пробелов в нем.";
		String a = "String and basics of text processing";
		String text = "In linguistics, a word of a spoken language can be defined as the smallest sequence of phonemes "
				+ "that can be uttered in isolation with objective or practical meaning. For many languages, words also correspond "
				+ "to sequences of graphemes (\"letters\") in their standard writing systems that are delimited by spaces wider "
				+ "than the normal inter-letter space, or by other graphical conventions.[1] The concept of \"word\" is usually "
				+ "distinguished from that of a morpheme, which is the smallest unit of speech which has a meaning, even if it will not stand on its own.";
		
		first(s);
		second(a);
		third("топот");
		fourth("информатика", "торт");
		fifth(a);
		sixth(a);
		seventh(a);
		eigth(a);
		ninth(a);
		tenth(text);
	}
	
	public static void first(String s) {
		/**
		 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
		 */
		System.out.println("Первое упражнение. Исходная строка\n" + s);
		int qty = 1;
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			if(Character.isSpaceChar(s.charAt(i))) {
				while(++i < s.length() && Character.isSpaceChar(s.charAt(i))){
					qty++;
				}
				max = Math.max(max, qty);
				qty = 1;
			}
		}
		System.out.println("Наибольшее количство пробелов равно " + max);
	}
	
	public static void second(String s) {
		/**
		 * В строке вставить после каждого символа 'a' символ 'b'
		 */
		System.out.println("\nВторое упражнение. Исходный текст\n" + s);
		StringBuffer sb = new StringBuffer(s);
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == 97) {
				sb.insert(i+1, 'b');
			}
		}
		System.out.println(sb);
	}
	
	public static void third(String s) {
		/**
		 * Проверить, является ли заданное слово палиндромом.
		 */
		System.out.println("\nТретье упражнение. Слово: " + s);
		StringBuffer sb = new StringBuffer(s);
		StringBuffer bs = sb.reverse();
		System.out.print("Слово палиндром? ");
		if(sb.equals(bs)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	public static void fourth(String inf, String tort) {
		/**
		 * С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
		 */
		System.out.println("\nЧетвёртое упражнение");
		String ans = new String();
		for(int i = 0; i < tort.length(); i++) {
			for(int j = 0; j < inf.length(); j++) {
				if(i < tort.length() && tort.charAt(i) == inf.charAt(j)) {
					ans = ans.concat("" + inf.charAt(j));
				}
			}
		}
		if(!ans.equals(tort)) {
			System.out.println("Сложить слово не получилось " + ans);
			return;
		}
		System.out.println("Полученное слово " + ans);
	}
	
	public static void fifth(String s) {
		/**
		 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
		 */
		System.out.println("\nПятое упражнение. Исходная строка\n" + s);
		int qty = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a') {
				qty++;
			}
		}
		System.out.println("буква а встречается " + qty + " раз(а)");
	}
	
	public static void sixth(String s) {
		/**
		 * Из заданной строки получить новую, повторив каждый символ дважды.
		 */
		System.out.println("\nШестое упражнение. Исходная строка\n" + s);
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < sb.length(); i+=2) {
			sb.insert(i, sb.charAt(i));
		}
		System.out.println(sb);
	}
	
	public static void seventh(String s) {
		/**
		 *  Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
		 *  def", то должно быть выведено "abcdef".
		 */
		System.out.println("\nСедьмое упражнение. Исходный текст\n" + s);
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < sb.length(); i++) {
			if(Character.isSpace(sb.charAt(i))) {
				sb.deleteCharAt(i);
			}
			char b = sb.charAt(i);
			for(int j = i+1; j < sb.length(); j++) {
				if(b == sb.charAt(j)) {
					sb.deleteCharAt(j);
					j--;
				}
			}
		}
		System.out.println(sb);
	}
	
	public static void eigth(String s) {
		/**
		 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
		 * длинных слов может быть несколько, не обрабатывать.
		 */
		System.out.println("\nВосьмое упражнение. Строка слов\n" + s);
		String max = new String();
		StringBuffer sb = new StringBuffer(s);
		for(int i = 0; i < sb.length(); i++) {
			String ss = new String();
			if(Character.isLetter(sb.charAt(i))) {
				int start = i;
				while(++i < sb.length() && Character.isLetter(sb.charAt(i)));
				ss = sb.substring(start, i);
			}
			if(ss.length() > max.length()) {
				max = ss;
			}
		}
		System.out.println("Самое длинное слово " + max);
	}
	
	public static void ninth(String s) {
		/**
		 * Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
		 * буквы.

		 */
		System.out.println("\nДевятое упражнение. Исходный текст\n" + s);
		int up =0;
		int low = 0;
		for(int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				up++;
			}
			if(Character.isLowerCase(s.charAt(i))) {
				low++;
			}
		}
		System.out.println("Прописных букв " + up + "\nСтрочных букв " + low);
	}
	
	public static void tenth(String s) {
		/**
		 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
		 * знаком. Определить количество предложений в строке X.
		 */
		System.out.println("\nДесятое упражнение. Исходный текст\n" + s);
		int qty = 0;
		for(int i = 0; i < s.length(); i++) {
			char point = s.charAt(i);
			if(point == '.' || point == '!' || point == '?') {
				qty++;
			}
		}
		System.out.println("Количество предложений равно " + qty);
	}

}
