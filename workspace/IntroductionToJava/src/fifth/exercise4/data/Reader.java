package fifth.exercise4.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс будет читать информацию с файлов
 * 
 * @author Dima Zosimov
 * @version 1.0 26.01.2020
 *
 */

public class Reader {
	
	private File file = null;
	private List<Treasure> treasures;
	public Reader() {
		file = new File("src\\fifth\\exercise4\\data\\data.csv");
			try(Scanner scan = new Scanner(new FileReader(file))){
			if(!file.canRead()) {
				System.out.println("Файл невозможно прочитать");
				return;
			}
			scan.useDelimiter("(;|\\r\\n)+");
			int cost;
			String name;
			treasures = new ArrayList<Treasure>();
			while(scan.hasNext()) {
				name = scan.next();
				cost = scan.nextInt();
				treasures.add(new Treasure(name, cost));				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Treasure> getTreasures(){
		return treasures;
	}
	
}
