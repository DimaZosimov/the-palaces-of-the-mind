package tools;
/**
 * Поисковик
 * @author Dima Zosimov
 * @version 1.0 20.02.2020
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.Note;

public class Searcher {

	private Scanner scanner;
	private ArrayList<Note> notes;
	private ArrayList<Note> searchedNotes;
	
	public Searcher(Scanner scanner, ArrayList<Note> notes) {
		this.scanner = scanner;
		this.notes = notes;
		this.searchedNotes = new ArrayList<Note>();
	}
	
	public void search() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		scanner.nextLine();
		System.out.println("Параметры поиска");
		System.out.println("Тема");
		String topic = scanner.nextLine();
		Date from = null;
		Date to = null;
		try {
			Pattern pattern = Pattern.compile("((\\d{2}-){2}\\d{4})|()");
			System.out.println("Дата создания ОТ в фомате дд-мм-гггг");
			String dateFrom = scanner.nextLine();
			dateFrom.trim();
			Matcher matcher = pattern.matcher(dateFrom);
			while(!matcher.matches()) {
				System.out.println("Неверно введена дата");
				System.out.println("Дата создания ОТ в фомате дд-мм-гггг");
				dateFrom = scanner.nextLine();
			}
			if(!dateFrom.isBlank()) {
				from = sdf.parse(dateFrom);
			} else {
				from = new Date(100);
			}
			System.out.println("Дата создания ДО в фомате дд-мм-гггг");
			String dateTo = scanner.nextLine();
			matcher = pattern.matcher(dateTo);
			while(!matcher.matches()) {
				System.out.println("Неверно введена дата");
				System.out.println("Дата создания ДО в фомате дд-мм-гггг");
				dateTo = scanner.nextLine();
			}
			if(!dateTo.isBlank()) {
				to = sdf.parse(dateTo);
			} else {
				to = new Date();
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("e-mail");
		String mail = scanner.nextLine();
		System.out.println("Посик по ключевым словам");
		String message = scanner.nextLine();
		run(topic, from, to, mail, message);
	}
	
	private void run(String topic, Date from, Date to, String mail, String message) {
		for(Note note : notes) {
			String topicOfNote = note.getTopic().toLowerCase();
			if(topicOfNote.contains(topic.toLowerCase()) || topic == null) {
				String mailOfNote = note.getMail().toLowerCase();
				if(mailOfNote.contains(mail.toLowerCase()) || mailOfNote == null) {
					if(note.getDate().after(from) || from == null) {
						if(note.getDate().before(to) || to == null) {
							String messageOfNote = note.getMessage().toLowerCase();
							if(messageOfNote.contains(message.toLowerCase()) || message == null) {
								searchedNotes.add(note);
							}
						}
					}
				}
			}
		}
		searchedNotes.sort(new Comparator<Note>() {
			@Override
			public int compare(Note o1, Note o2) {
				if(o1.getDate().before(o2.getDate())) {
					return 1;
				} else if(o1.getDate().after(o2.getDate())) {
					return -1;
				} else {
					return 0;
				}
			}
			
		});
	}
	
	public ArrayList<Note> getSearchedNotes(){
		return searchedNotes;
	}
	
	
	
}
