package fourth.aggregation.fourth;

/**
 * 
 * @author Dima Zosimov
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String surname;
	private String name;
	private String patronymic;
	private List<BankAccount> accounts;
	
	public Person(String surname, String name, String patronymic) {
		this.surname = surname;
		this.name = name;
		if(patronymic.isEmpty()) {
			this.patronymic = new String();
		} else {
			this.patronymic = patronymic;
		}
		accounts = new ArrayList<BankAccount>();
	}
	
	public void addBankAccount(BankAccount ba) {
		accounts.add(ba);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", surname, name, patronymic);
	}

}
