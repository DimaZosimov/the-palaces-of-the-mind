package fourth;

/**
 *  Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного
 * 
 * @author Dima Zosimov
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Airline {
	
	private String to;
	private String num;
	private String type;
	private Date time;
	private String daysOfWeek;
	public Airline(String to, String num, String type, String time, String daysOfWeek) {
		this.to = to;
		this.num = num;
		this.type = type;
		SimpleDateFormat ft = new SimpleDateFormat("H:m");
		try {
			this.time = ft.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.daysOfWeek = daysOfWeek;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDaysOfWeek() {
		return daysOfWeek;
	}
	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
	
	@Override
	public String toString() {
		return String.format("№ %-6s %-10s %-5s%2tH:%2tM\t%s", num, to, type, time, time, daysOfWeek);
	}
	

}
