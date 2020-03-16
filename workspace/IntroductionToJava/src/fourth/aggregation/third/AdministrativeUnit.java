package fourth.aggregation.third;

/**
 * Класс административная единица
 * 
 * @author Dima Zosimov
 */

import java.util.List;

abstract class AdministrativeUnit<T> {
	
	private String name;
	private List<T> list;
	private City capital;
	
	public void setCapital(City city) {
		this.capital = city;		
	}
	
	public boolean add(T t) {
		list.add(t);
		return true;
	}
	
	public City getCapital() {
		return capital;
	}
		
	public void setList(List<T> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<T> getList() {
		return list;
	}
	@Override
	public String toString() {
		return name;
	}

}
