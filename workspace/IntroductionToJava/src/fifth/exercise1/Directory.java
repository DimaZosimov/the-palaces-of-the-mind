package fifth.exercise1;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Directory {
	
	private String directory;
	private List<File> files;
	
	public Directory(String directory) {
		this.directory = directory;
		files = new ArrayList<File>();
	}
	
	public void addFile(File file) {
		files.add(file);
	}
	
	public File createTextFile(String name) {
		return new TextFile(this, name);
	}
	
	public File deleteTextFile(File file) {
		files.remove(file);
		return null;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return directory;
	}
	
	

}
