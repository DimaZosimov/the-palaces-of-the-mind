package fourth;

/**
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10
 * 
 * @author Dima Zosimov 
 */

import java.util.Arrays;

public class Student {
	
	private String fio;
	private String group;
	private int[] marks = new int[5];
	
	//Создайте массив из десяти элементов такого типа
	public void setTenMarks() {
		this.marks = new int[10];
	}
	
	/*Добавьте возможность вывода фамилий и
	 *номеров групп студентов, имеющих оценки, равные только 9 или 10
	 */
	public boolean isExcellentStudent() {
		for(int i = 0; i < marks.length; i++) {
			if(marks[i] < 9) {
				return false;
			}
		}
		System.out.println(this.toString());
		return true;
	}
	
	public String toString() {
		return String.format("%s\t%s\t%s", fio, group, Arrays.toString(marks));
	}
	
	public Student(String fio, String group, int[] marks) {
		super();
		this.fio = fio;
		this.group = group;
		this.marks = marks;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	

}
