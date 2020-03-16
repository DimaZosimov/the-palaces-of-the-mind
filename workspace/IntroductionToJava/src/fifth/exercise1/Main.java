package fifth.exercise1;
/**
 * 
 * @author Dima Zosimov
 *
 */

public class Main {

	public static void main(String[] args) {
		Directory dir = new Directory("src/dir");
		TextFile textFile = new TextFile(dir, "text");
		System.out.println("Переименовать файл " + textFile);
		textFile.rename("poem");
		System.out.println("file: " + textFile);
		
		File document = dir.createTextFile("document");
		System.out.println("Вывести все файлы в это директории");
		for(File file : dir.getFiles()) {
			System.out.println(file);
		}
		
		System.out.println("Дополнить и прочитать текст");
		textFile.write("I want to be a programmer");
		textFile.read();
		
		System.out.println("Удалить файл document");
		document = dir.deleteTextFile(document);
		for(File file : dir.getFiles()) {
			System.out.println(file);
		}
		
		System.out.println(document);
		

	}

}
