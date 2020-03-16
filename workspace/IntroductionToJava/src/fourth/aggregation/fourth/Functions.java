package fourth.aggregation.fourth;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Functions {
	
	public static List<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public static List<BankAccount> find(Person person) {
		return person.getAccounts();
	}
	
	public static BankAccount find(String number) {
		for(BankAccount ac : accounts) {
			if(number.equals(ac)) {
				return ac;
			}
		}
		return null;
	}
	
	public static void sortByNumber() {
		Collections.sort(accounts, new Comparator<BankAccount>() {
			@Override
			public int compare(BankAccount o1, BankAccount o2) {
				return o1.getNumber().compareTo(o2.getNumber());
			}
		});
	}
	
	public static void sortByPerson() {
		Collections.sort(accounts, new Comparator<BankAccount>() {
			@Override
			public int compare(BankAccount o1, BankAccount o2) {
				return o1.getHolder().toString().compareTo(o2.getHolder().toString());
			}
		});
	}
	
	public static void sortByBalance() {
		Collections.sort(accounts, new Comparator<BankAccount>() {
			@Override
			public int compare(BankAccount o1, BankAccount o2) {
				return (int) (o1.getBalance() - o2.getBalance());
			}
		});
	}
	
	public static double sumBalance(List<BankAccount> accounts) {
		double sum = 0;
		for(BankAccount ac : accounts) {
			sum += ac.getBalance();
		}
		return sum;
	}
	
	public static double sumBalanceAllAccounts() {
		return sumBalance(accounts);
	}
	
	public static List<BankAccount> getPositiveBalances(){
		List<BankAccount> newList = new ArrayList<BankAccount>();
		for(BankAccount ac : accounts) {
			if(ac.getBalance() >= 0) {
				newList.add(ac);
			}
		}
		return newList;
	}
	
	public static List<BankAccount> getNegativeBalances(){
		List<BankAccount> newList = new ArrayList<BankAccount>();
		for(BankAccount ac : accounts) {
			if(ac.getBalance() < 0) {
				newList.add(ac);
			}
		}
		return newList;
	}
	
	public static void printAccounts(List<BankAccount> accounts) {
		for(BankAccount ac : accounts) {
			System.out.println(ac);
		}
	}

}
