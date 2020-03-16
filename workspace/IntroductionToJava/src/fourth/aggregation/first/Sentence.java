package fourth.aggregation.first;

import java.util.*;
import java.util.regex.*;

public class Sentence {
	
	private String sentence;
	private List<Word> words;
	public Sentence(String sentence) {
		this.sentence = sentence;
		Pattern pat = Pattern.compile("\\w+");
		Matcher mat = pat.matcher(sentence);
		while(mat.find()) {
			words.add(new Word(mat.group()));
		}
	}
	public Sentence(Word...words) {
		this.words = Arrays.asList(words);
		for(Word word : words) {
			this.sentence = sentence.concat(word.getWord() + " ");
		}
	
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public void add(Word word) {
		sentence = sentence.concat(word.getWord());
	}
	
	public void add(Word word, int index) {
		StringBuffer sb = new StringBuffer(sentence);
		sb.insert(index, word.getWord());
		this.sentence = sb.toString();
	}
	
	public List<Word> getWords(){
		return words;
	}
}
