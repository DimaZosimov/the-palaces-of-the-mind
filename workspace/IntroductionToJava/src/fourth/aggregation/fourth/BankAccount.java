package fourth.aggregation.fourth;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount {
	
	private String number;
	private boolean isBlocked = false;
	private Person holder;
	private double balance;
	
	public BankAccount(String number, Person person) {
		Pattern pat = Pattern.compile("\\w+");
		Matcher mat = pat.matcher(number);
		if(!mat.matches()) {
			throw new IllegalArgumentException();
		}
		this.number = number;
		this.holder = person;
		balance = 0;
		holder.addBankAccount(this);
		Functions.accounts.add(this);
	}
	
	public BankAccount(Person person) {
		this(new String("" + (int)(Math.random() * 10000 + 10000)), person);
	}
	
	public void blocking() {
		isBlocked = true;
	}
	
	public void unBlocking() {
		isBlocked = false;
	}
	
	public boolean putMoney(double money) {
		if(isBlocked()) { return false; }
		this.balance += money;
		return true;
	}
	
	public boolean withdrawMoney(double money) {
		if(isBlocked()) { return false; }
		this.balance -= money;
		return true;
	}
	
	public boolean isBlocked() {
		if(isBlocked) {
			System.out.println("Счёт заблокирован");
			return isBlocked;
		}
		return isBlocked;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getHolder() {
		return holder;
	}

	public double getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%.2f\tблокировка: %s", number, holder.toString(), balance, isBlocked);
	}

}
