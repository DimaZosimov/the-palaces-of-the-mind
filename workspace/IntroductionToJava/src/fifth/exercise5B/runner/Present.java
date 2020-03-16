package fifth.exercise5B.runner;

import java.util.ArrayList;
import java.util.List;

import fifth.exercise5A.data.packagings.Packaging;
import fifth.exercise5B.data.Sweets;

/**
 * Класс подарок, который содержит список сладостей и упаковку
 * Упаковку для подрака используем с задания варинта А
 * 
 * @author Dima Zosimov
 * @version 1.0 02.02.2020
 *
 */

public class Present {
	
	private Packaging packaging;
	private List<Sweets> sweets;
	
	public Present() {
		this.packaging = null;
		this.sweets = new ArrayList<Sweets>();
	}
	
	public void addSweetness(Sweets sweetness) {
		sweets.add(sweetness);
	}

	public Packaging getPackaging() {
		return packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public List<Sweets> getSweets() {
		return sweets;
	}

	public void setSweets(List<Sweets> sweets) {
		this.sweets = sweets;
	}

	@Override
	public String toString() {
		String list = new String();
		for(Sweets sweetness : sweets) {
			list = list.concat(sweetness + ", ");
		}
		return list;
	}
	
	
	

}
