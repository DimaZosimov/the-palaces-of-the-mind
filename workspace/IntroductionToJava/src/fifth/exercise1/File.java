package fifth.exercise1;

/**
 * 
 * @author Dima Zosimov
 *
 */
abstract class File {
	
	private Directory directory;
	private String type;
	private String name;
	
	public File(Directory directory, String type, String name) {
		this.directory = directory;
		this.type = type;
		this.name = name;
	}
	
	public Directory getDirectory() {
		return directory;
	}
	
	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s.%s", directory.toString(), name, type);
	}
	
	
	
	

}
