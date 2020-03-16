package fifth.exercise2;
/**
 * 
 * @author Dima Zosimov
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Payment payment = new Payment();
		payment.addProduct(payment.new Product("молоко", 1.72));
		payment.addProduct(payment.new Product("хлеб", 0.75));
		payment.addProduct(payment.new Product("йогурт", 1.27));
		payment.addProduct(payment.new Product("сырок", 0.65));
		payment.addProduct(payment.new Product("кетчуп", 2.22));
		payment.addProduct(payment.new Product("колбаса", 3.45));
		
		payment.printReceipt();
		System.out.printf("%nИТОГ:\t%.2f", payment.getCost());

	}

}
