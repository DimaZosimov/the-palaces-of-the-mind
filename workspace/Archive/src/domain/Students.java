package domain;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class Students {

	private ArrayList<Student> list = new ArrayList<Student>();
	
	public Students() {
		super();
	}
	
	public void setList(ArrayList<Student> list) {
		this.list = list;
	}
	
	public boolean add(Student st) {
		return list.add(st);
	}
	
	public int size() {
		return list.size();
	}
	
	public Student getStudent(int index) {
		return list.get(index);
	}
	
	public ArrayList<Student> getList(){
		return list;
	}

	@Override
	public String toString() {
		return "Students [list=" + list + "]";
	}
	
	
}
