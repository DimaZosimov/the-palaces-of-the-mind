package tools;
/**
 * Загрузчик данных с файла
 * @author Dima Zosimov
 * @version 1.0 20.02.2020
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader {
	
	private File file;
	
	public Loader(File file) {
		try {
		if(!file.isFile()) {
			throw new FileNotFoundException("Файл не найден");
		}
		if(!file.canRead()) {
			throw new IOException("Файл нельзя прочитать");
		}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		this.file = file;		
	}
	
	public Object load(){
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			
			obj = ois.readObject();
			
		} catch(FileNotFoundException e) {
			System.out.println("Файл не найден");
			e.getStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return obj;
	}

}
