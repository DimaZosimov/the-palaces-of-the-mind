package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import domain.Note;
import tools.Adder;
import tools.Loader;
import tools.Printer;
import tools.Remover;
import tools.Searcher;
import tools.Writer;

/**
 * База данных
 * @author Dima Zosimov
 * @version 1.0 21.02.2020
 *
 */

public class DataNotes {
	
	private static ArrayList<Note> notes;
	private static final File FILE = new File("src\\data\\data.txt");
	private Scanner scanner;
	
	public DataNotes(Scanner scanner) {
		if(notes == null) {
			Loader loader = new Loader(FILE);
			notes = (ArrayList<Note>) loader.load();
			if(notes == null) {
				notes = new ArrayList<Note>();
			}
		}
		this.scanner = scanner;
	}
	
	public void print(ArrayList<Note> notes) {
		Printer printer = new Printer(notes);
		printer.print();
	}
	
	public void print() {
		print(notes);
	}
	
	public void add() {
		Adder adder = new Adder(scanner);
		Note note = adder.getNote();
		notes.add(note);
		System.out.println("Успешно добавлено");
	}
	
	public void write() {
		Writer writer = new Writer(FILE);
		writer.write(notes);
	}
	
	public void search() {
		Searcher searcher = new Searcher(scanner, notes);
		searcher.search();
		print(searcher.getSearchedNotes());
	}
	
	public void remove() {
		Remover remover = new Remover(scanner, notes);
		remover.delete();
		notes = remover.getNotes();
	}

}
