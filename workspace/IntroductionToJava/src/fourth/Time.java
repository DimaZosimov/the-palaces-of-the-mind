package fourth;

/**
 * Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд
 * 
 * @author Dima Zosimov
 *
 */

public class Time {

	private int hour;
	private int minute;
	private int second;
	
	public Time(int hour, int minute, int second) {
		if(hour < 0 || hour > 23) {
			this.hour = 0;
		} else {
			this.hour = hour;
		}
		if(minute < 0 || minute > 59) {
			this.minute = 0;
		} else {
			this.minute = minute;
		}
		if(second < 0 || second > 59) {
			this.second = 0;
		} else {
			this.second = second;
		}
	}
	
	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public String toString() {
		return String.format("%d:%d:%d", hour, minute, second);
	}
	
	

}
