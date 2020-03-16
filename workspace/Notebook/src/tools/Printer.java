package tools;
/**
 * Вывод на консоль
 * @author Dima Zosimov
 * @version 1.0 20.02.2020
 *
 */

import java.util.ArrayList;

import domain.Note;

public class Printer {
	
	private ArrayList<Note> notes;
	
	public Printer(ArrayList<Note> notes) {
		this.notes = notes;
	}
	
	public void print() {
		if(notes.isEmpty() || notes == null) {
			System.out.println("Ничего не найдено");
		}
		int ind = 0;
		for(Note note : notes) {
			System.out.println(++ind + ")\t" + note);
		}
	}

}
