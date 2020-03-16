package third;

import java.util.Arrays;

/**
 * Работа со строкой как с массивом символов
 * @author Dima Zosimov
 *
 */

public class CharacterArray {

	public static void main(String[] args) {
		
		String[] s = {"CharacterArray", "SnakeCase", "_UniCode", "ПриветМир"};
		String text = "In linguistics, a word of a spoken language can be defined as the smallest sequence of phonemes "
				+ "that can be uttered in isolation with objective or practical meaning. For many languages, words also correspond "
				+ "to sequences of graphemes (\"letters\") in their standard writing systems that are delimited by spaces wider "
				+ "than the normal inter-letter space, or by other graphical conventions.[1] The concept of \"word\" is usually "
				+ "distinguished from that of a morpheme, which is the smallest unit of speech which has a meaning, even if it will not stand on its own.";
		String swd = "The world's population in 2019 amounted to 7.7 billion people";
		String fif = "   Hi    World!!   ";
		first(s);
		second(text, "word", "letter");
		third(swd);
		fourth(swd);
		fifth(fif);

	}
	
	static void printStringArray(String[] c) {
		for(String i : c) {
			System.out.printf("%s ", i);
		}
		System.out.println();
	}
	
	static void printCharArray(char[] c) {
		for(int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		
	}
	
	static void first(String[] c) {
		/**
		 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
		 */
		System.out.println("Первое упражнение");
		printStringArray(c);
		c = getSnakeCase(c);
		printStringArray(c);
	}
	
	static String[] getSnakeCase(String[] c) {
		char[] s;
		for(int i = 0; i < c.length; i++) {
			s = c[i].toCharArray();
			String ns = new String();
			for(int j = 0; j < s.length; j++) {
				if(Character.isUpperCase(s[j])) {
					ns = ns.concat("_" + Character.toString(s[j]).toLowerCase());
				} else {
					ns = ns.concat(Character.toString(s[j]));
				}
			}
			c[i] = ns.substring(1);		// обрезаем "_", т.к. этот символ добавляется перед каждой прописной буквой (и перед первой в том числе)
		}
		return c;
	}
	
	static void second(String s, String find, String replace) {
		/**
		 * Замените в строке все вхождения 'word' на 'letter'
		 */
		System.out.println("\nВторое упражнение. Исходный текст:\n" + s);
//		s = s.replaceAll(find, replace);
		char[] c = s.toCharArray();
		char[] f = find.toCharArray();
		char[] r = replace.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(c[i] != f[0]) {
				//находим первое совпадение буквы с первой буквой искомого слова
				while(++i < c.length && c[i] != f[0]);
			}
			if(i < c.length) {
				int j = i + 1;
				int end = j + f.length -1;
				//находим совпадения остальных букв
				for(int k = 1; j < end && c[j] == f[k]; j++, k++);
				// j == end - все буквы совпажают
				if(j == end) {
					// проверим, если после найденного слова еще буквы, чтобы не получилось при поиске слова "char" найти часть слова "CHARacter"
				if(j+1 != c.length && !Character.isLetter(c[j])) {
						c = replaceChars(c, i, r, f);
					}
				}
			}
		}
		printCharArray(c);
	}
	
	static char[] replaceChars(char[] c, int startInd, char[] replace, char[] find) {
		int len = c.length - startInd - find.length;
		c = Arrays.copyOf(c, c.length + (replace.length - find.length));
		System.arraycopy(c, startInd + find.length, c, startInd + replace.length, len);
		System.arraycopy(replace, 0, c, startInd, replace.length);
		return c;
	}
	
	static void third(String s) {
		/**
		 * В строке найти количество цифр.
		 */
		System.out.println("\nТретье упражнение. Исходный текст\n" + s);
		int qty = 0;
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(Character.isDigit(c[i])) {
				qty++;
			}
		}
		System.out.println("Количество цифр " + qty);
	}
	
	static void fourth(String s) {
		/**
		 * В строке найти количество чисел.
		 */
		System.out.println("\nЧетвертое упражнение. Исходный текст\n" + s);
		int qty = 0;
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length-1; i++) {
			if(!Character.isDigit(c[i])) {
				while(++i < c.length && !Character.isDigit(c[i]));
			}
			if(i < c.length) {
				qty++;
				while(++i < c.length && Character.isDigit(c[i]));
			}
		}
		System.out.println("Количество чисел в тексте: " + qty);
	}
	
	static void fifth(String s) {
		/**
		 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
		 * Крайние пробелы в строке удалить.
		 */
		System.out.println("\nПятое упражнение. Исходный текст\n" + s);
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(Character.isSpaceChar(c[i])) {
				c = deleteSpace(c, i);
			}
		}
		if(Character.isSpaceChar(c[0])) {
			c = deleteSpace(c, -1);
		}
		if(Character.isSpaceChar(c[c.length-1])) {
			c = deleteSpace(c, c.length-2);
		}
		printCharArray(c);
	}
	
	static char[] deleteSpace(char[] c, int i) {
		while(++i < c.length && Character.isSpaceChar(c[i])) {
			System.arraycopy(c, i+1, c, i, c.length - i -1);
			i--;
			c = Arrays.copyOf(c, c.length - 1);
		}
		return c;
	}
	
}
