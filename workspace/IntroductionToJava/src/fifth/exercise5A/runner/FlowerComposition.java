package fifth.exercise5A.runner;

/**
 * Класс цветочная компазиция, которая содержит список цветов и упаковку
 * 
 * @author Dima Zosimov
 * @version 1.0 29.01.2020
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fifth.exercise5A.data.flowers.*;
import fifth.exercise5A.data.packagings.Basket;
import fifth.exercise5A.data.packagings.Carton;
import fifth.exercise5A.data.packagings.Felt;
import fifth.exercise5A.data.packagings.Packaging;
import fifth.exercise5A.data.packagings.WoodBox;

public class FlowerComposition {
	
	private Packaging packaging;
	private List<Flower> flowers;
	private String name;
	
	public FlowerComposition(String name, Packaging packaging) {
		Pattern pat = Pattern.compile("[\\w\\s]+");
		Matcher mat = pat.matcher(name);
		if(!mat.matches()) {
			throw new IllegalArgumentException();
		}
		this.packaging = packaging;
		flowers = new ArrayList<Flower>();
	}
	
	public FlowerComposition(String name, Packaging packaging, boolean tape) {
		this(name, packaging);
		this.packaging.setTape(tape);
	}
	
	public void addFlower(String flower, int qty) {
		if(qty < 0) {
			throw new IllegalArgumentException("Количество цветов задано не верно");
		}
		switch(name.toLowerCase()) {
		case "роза" : while(qty-- != -1) {
							addFlower(new Rose());
						}
						break;
		case "хризонтема" : while(qty-- != -1) {
							addFlower(new Chrysanthemum());
						}
						break;	
		case "гвоздика" : while(qty-- != -1) {
							addFlower(new Clove());
						}
						break;
		case "эрингиум" : while(qty-- != -1) {
							addFlower(new Eringium());
						}
						break;				
		case "эустома" : while(qty-- != -1) {
							addFlower(new Eustomas());
						}
						break;				
		case "гортензия" : while(qty-- != -1) {
							addFlower(new Hydrangea());
						}
						break;	
		case "лилия" : while(qty-- != -1) {
							addFlower(new Lily());
						}
						break;	
		default : System.out.println("Таких цветов нет в ассортименте");
		}
	}
	
	public void addFlower(Flower flower) {
		flowers.add(flower);
	}

	public Packaging getPackaging() {
		return packaging;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public String getName() {
		return name;
	}
	
	public void setPackaging(String name) {
		switch (name.toLowerCase()) {
		case "корзинка" : setPackaging(new Basket());
		case "картонная коробка" : setPackaging(new Carton());
		case "фетр" : setPackaging(new Felt());
		case "деревянный ящик" : setPackaging(new WoodBox());
		default : System.out.println("такой упаковки нет");
		}
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Цветочная компазиция \"%s\"%nСостав: %s%Упаковка : %s", 
								name, toStringFlowers(), packaging);
	}
	
	public String toStringFlowers() {
		String res = new String();
		for(Flower fl : flowers) {
			res = res.concat(fl + ", ");
		}
		return res;
	}
	
	

}
