package tools;
/**
 * Удаляет заметки
 * @author Dima Zosimov
 * @version 1.0 21.02.2020
 */

import java.util.ArrayList;
import java.util.Scanner;

import domain.Note;

public class Remover {
	
	private Scanner scanner;
	private ArrayList<Note> notes;
	
	public Remover(Scanner scanner, ArrayList<Note> notes) {
		this.scanner = scanner;
		this.notes = notes;
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
	
	public void delete() {
		scanner.nextLine();
		System.out.println("Введите название заметки, которую необходимо удалить");
		String name = scanner.nextLine();
		boolean isDel = false;
		int index = 0;
		while(!isDel) {
			Note note = find(name, index);
			if(note == null) {
				return;
			}
			System.out.println(note);
			System.out.println("Удалить?");
			System.out.println("1.Да\t2.Нет");
			int key = scanner.nextInt();
			switch (key) {
			case 1 : 	notes.remove(note);
						isDel = true;
						System.out.println("Успешно удалено");
						return;
			case 2 :	index = notes.indexOf(note) + 1;
						break;
			default:	System.out.println("Неверно введено число");
			}
		}
	}
	
	private Note find(String name, int start) {
		for(int i = start; i < notes.size(); i++) {
			Note note = notes.get(i);
			if(note.getTopic().contains(name)) {
				return note;
			}
		}
		System.out.println("Ничего не найдено");
		return null;
	}

}
