package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Писатель данных в файл
 * @author Dima Zosimov
 * @version 1.0 20.02.2020
 *
 */

public class Writer {
	
	private File file;
	
	public Writer(File file) {
		try {
			if(!file.isFile()) {
				file.createNewFile();
			}
			if(!file.canWrite()) {
				throw new IOException("Файл закрыт для записи");
			}
			this.file = file;
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public void write(Object obj) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			
			oos.writeObject(obj);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
