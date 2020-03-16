package fourth;

/**
 * Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 *
 * @author Dima Zosimov
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	
	private static int idGenerator = 0;
	{
		++idGenerator;
	}
	
	private int id = idGenerator;
	private String surname;
	private String name;
	private String patronymic;
	private String adress;
	private long creditCard;
	private String bankAccount;
	
	public Customer(String surname, String name, String patronymic, String adress, long creditCard,
			String bankAccount) {
		Pattern pat = Pattern.compile("[A-Za-zА-Яа-я]+");
		Matcher ms = pat.matcher(surname);
		Matcher mn = pat.matcher(name);
		Matcher mp = pat.matcher(patronymic);
		if(!ms.matches() || !mn.matches() || !mp.matches()) {
			throw new IllegalArgumentException("не правильно введено ФИО");
		}
		if(creditCard < 0 || creditCard > 1_0000_0000_0000_0000l) {
			throw new IllegalArgumentException("credit card");
		}
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.adress = adress;
		this.creditCard = creditCard;
		this.bankAccount = bankAccount;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public long getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(long creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getBankAccount() {
		return bankAccount;
	}
	
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public String toString() {
		return String.format("ID %d %-10s %-8s %s\t%s\t%-18d %s", 
				id, surname, name, patronymic, adress, creditCard, bankAccount);
	}
	
	
	
	
	

}
