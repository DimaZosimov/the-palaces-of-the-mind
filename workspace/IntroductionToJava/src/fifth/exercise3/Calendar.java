package fifth.exercise3;
/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.*;

public class Calendar {
	
	private HashMap<String, Holiday> map;
	
	public Calendar(String date, String info) {
		if(map == null) {
			map = new HashMap<String, Calendar.Holiday>();
		}
		Holiday holiday = new Holiday(info);
		map.put(date, holiday);
	}
	
	public void addInfo(String date, String info) {
		if(map.containsKey(date)) {
			map.get(date).setInfo(info);
		} else {
			map.put(date, new Holiday(info));
		}
	}
	
	public void deleteInfo(String date) {
		if(!map.containsKey(date)) {
			return;
		}
		map.get(date).deleteInfo();
	}
	
	public void printCalendar() {
		Set<Map.Entry<String, Holiday>> pri = map.entrySet();
		for(Map.Entry<String, Holiday> m : pri) {
			System.out.println(m.getKey() + "\t" + m.getValue());
		}
	}
	
	public String toString() {
		return map.toString();
	}

	public class Holiday{
		
		private String info;
		
		Holiday(String info){
			if(this.info == null) {
				this.info = new String();
			}
			this.info = this.info.concat(" " + info);
		}
		
		public void setInfo(String info) {
			this.info = this.info.concat(" " + info);
		}
		
		public void deleteInfo() {
			this.info = null;
		}

		public String getInfo() {
			return info;
		}
		
		public String toString() {
			return info;
		}
		
	}

}
