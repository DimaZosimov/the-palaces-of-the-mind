package fourth;

/**
 * @author Dima Zosimov
 */

import java.util.*;

public class CustomerMain {

	public static void main(String[] args) {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("Зосимов", "Дмитрий", "Александрович", "Брест", 1025_2390_0000_9100l, "AB1025239000009100"));
		list.add(new Customer("Иванов", "Иван", "Михайлович", "Минск", 1031_2381_0000_9100l, "AB10312381000009100"));
		list.add(new Customer("Березуцкий", "Анрей", "Михайлович", "Гомель", 1031_4211_0000_9861l, "AB1031421100009861"));
		list.add(new Customer("Фоменко", "Николай", "Артемович", "Гродно", 1031_4212_0001_9891l, "AB1031421200019891"));
		list.add(new Customer("Андропенко", "Кирилл", "Семенович", "Гомель", 1031_4211_0001_9898l, "AB1031421100019898"));
	
	System.out.println("В алфавитном порядке");
	sort(list);
	printList(list);
	System.out.println("\nсписок покупателей, у которых номер кредитной карточки находится в заданном интервале\n");
	printList(getCreditCardBetween(list, 1031_4212_0001_0000l, 1031_4212_1000_0000l));
	
	}
	
	public static void sort(List<Customer> list) {
		Collections.sort(list, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				int comp = o1.getSurname().compareTo(o2.getSurname());
				if(comp == 0) {
					return o1.getName().compareTo(o2.getName());
				} else {
					return comp;
				}
			}
		});
	}
	
	public static List<Customer> getCreditCardBetween(List<Customer> list, long start, long finish){
		List<Customer> newList = new ArrayList<Customer>();
		for(Customer c : list) {
			if(c.getCreditCard() >= start && c.getCreditCard() <= finish) {
				newList.add(c);
			}
		}
		return newList;
	}
	
	public static void printList(List<Customer> list) {
		for(Customer c : list) {
			System.out.println(c);
		}
	}

}
