package fifth.exercise1;
/**
 * 
 * @author Dima Zosimov
 *
 */

public class TextFile extends File{
	
	private String text;

	public TextFile(Directory directory, String name) {
		super(directory, "txt", name);
		text = new String();
		directory.addFile(this);
	}
	
	public void rename(String name) {
		super.setName(name);
	}
	
	public void read() {
		System.out.println(text);		
	}
	
	public void write(String text) {
		this.text = this.text.concat(text);
	}


}
