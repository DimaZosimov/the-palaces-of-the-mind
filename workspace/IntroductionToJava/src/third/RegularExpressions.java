package third;
/**
 * Работа с регулярными выражениями (Pattern, Matcher)
 * @author Dima Zosimov
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpressions {

	public static void main(String[] args) {
		String s = "Иногда  необходимо  сбросить  состояние  экземпляра  Matcher  в  исходное, " + 
				"для этого применяется метод reset() или reset(CharSequence input), который " + 
				"также устанавливает новую последовательность символов для поиска.\r\n" + 
				"Для замены всех подпоследовательностей символов, удовлетворяющих шаблону, " + 
				"на заданную строку можно применить метод replaceAll (String replacement).\r\n" + 
				"В  регулярном  выражении  для  более  удобной  обработки  входной  после до " + 
				"вательности применяются группы, которые помогают выделить части найденной " + 
				"подпоследовательности. В шаблоне они обозначаются скобками «(» и «)». Номера групп " + 
				"начинаются с единицы. Нулевая группа совпадает со всей найденной подпоследовательностью. " + 
				"Далее приведены методы для извлечения информации о группах!";

		sortParagraph(s);
			System.out.println();
		sortSentence(s);
			System.out.println();
		sortLexeme(s, "с");

	}
		
	/**
	 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
	 * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
	 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
	 * алфавиту.
	 * 
	 */
	public static void sortParagraph(String s) {
		Pattern pattern = Pattern.compile("[\n]{1}");
		//Разбитие текста на абзацы
		String[] paragraph = pattern.split(s);
		//Сортировка по убыванию по количеству предложений в абзаце
		Arrays.sort(paragraph, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Pattern pat = Pattern.compile("([\\?\\!\\.]+)");
				Matcher m1 = pat.matcher(o1);
				Matcher m2 = pat.matcher(o2);
				int qty1 = 0;
				int qty2 = 0;
				while(m1.find()) {	qty1++;	}
				while(m2.find()) {	qty2++;	}
				if(qty1 > qty2) {	return 1; } 
				else if (qty2 > qty1) {	return -1; }
				else {	return 0; }
			}
		});
		for(String i : paragraph) {
			System.out.println(i);
		}
	}
	
	public static String[] splitIntoSentences(String s) {
		Pattern pattern = Pattern.compile("[\\!\\.\\?]");
		String[] sentences = pattern.split(s);
		return sentences;
	}
	
	public static String[] splitIntoWords(String sentence) {
		Pattern pat = Pattern.compile("[^A-Za-zА-Яа-я]+");
		String[] words = pat.split(sentence.trim());
		return words;
	}
	
	public static void sortSentence(String s) {
		String[] sentences = splitIntoSentences(s);
		for(int i = 0; i < sentences.length; i++) {
			String[] words = splitIntoWords(sentences[i]);
			Arrays.sort(words, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() > o2.length()) { return 1; }
					if(o1.length() < o2.length()) { return -1;}
					return 0;
				}		
			});
			System.out.println(Arrays.toString(words));
		}
	}
	
	public static void sortLexeme(String s, String letter) {
		String[] sentences = splitIntoSentences(s);
		for(int i = 0; i < sentences.length; i++) {
			String[] words = splitIntoWords(sentences[i]);
			Arrays.sort(words, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					//найдем количество совпадений заданной буквы в сравниваемых словах
					Pattern pat = Pattern.compile(letter);
					Matcher m1 = pat.matcher(o1);
					Matcher m2 = pat.matcher(o2);
					int qty1 = 0; 
					int qty2 = 0;
					while(m1.find()) { qty1++;}
					while(m2.find()) { qty2++;}
					if(qty1 > qty2) { return -1;}
					else if(qty1 < qty2) { return 1; }
					else { return o1.compareTo(o2);	}
				}
			});
			System.out.println(Arrays.toString(words));
		}
	}

}
