package fifth.exercise2;
/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Payment {
	
	private List<Product> products;
	
	public Payment(){
		this.products = new ArrayList<Payment.Product>();
	}
	
	public Payment(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public double getCost() {
		double sum = 0;
		for(Product pr : products) {
			sum += pr.cost;
		}
		return sum;
	}
	
	public void printReceipt() {
		for(Product pr : products) {
			System.out.println(pr);
		}
	}
	
	public class Product{
		
		private String name;
		private double cost;
		Product(String name, double cost){
			if(cost < 0) {
				throw new IllegalArgumentException();
			}
			this.cost = cost;
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public double getCost() {
			return cost;
		}
		
		public void setCost(double cost) {
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "Product [name=" + name + ", cost=" + cost + "]";
		}
	}

}
