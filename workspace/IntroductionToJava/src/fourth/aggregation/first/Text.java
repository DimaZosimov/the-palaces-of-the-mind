package fourth.aggregation.first;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
 * консоль текст, заголовок текста
 * 
 * @author Dima Zosimov
 */

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	
	private String name;
	private String text;
	private List<Sentence> sentences;
	
	public Text(String name, String text) {
		this.name = name;
		this.text = text;
		Pattern pat = Pattern.compile(".+\\.|\\!|\\?");
		Matcher mat = pat.matcher(text);
		while(mat.find()) {
			sentences.add(new Sentence(mat.group()));
		}
	}
	
	public Text(Sentence...sentences) {
		this.sentences = Arrays.asList(sentences);
		for(Sentence s : sentences) {
			this.text = text.concat(s + " "); 
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(Sentence sent, int index) {
		StringBuffer sb = new StringBuffer(text);
		sb.insert(index, sent.getSentence());
		this.text = sb.toString();
	}
	
	public void add(Sentence sent) {
		text = text.concat(" " + sent.getSentence());
	}
	
	public void printText() {
		System.out.println(text);
	}
	
	public void printName() {
		System.out.println(name);
	}

}
