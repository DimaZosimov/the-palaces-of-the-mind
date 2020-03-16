package runner;
/**
 * Консольное меню
 * 
 * @author Dima Zosimov
 * @version 1.0 09.02.2020
 * 			1.1 10.02.2020 добавлено меню администратора в startMenu()
 */

import java.util.Scanner;

import data.DataUser;
import domain.Admin;
import domain.Person;
import domain.User;

public class ConsoleMenu implements CatalogConsoleMenu{
	
	private Scanner scan;
	
	public ConsoleMenu(Scanner scanner) {
		this.scan = scanner;
	}
	
	private Person enterMenu() {
		System.out.println("Введите логин");
		String login = scan.next();
		System.out.println("Введите пароль");
		String password = scan.next();
		DataUser dataUser = new DataUser();
		Person user = null;
		if(dataUser.getUsers().containsKey(login)) {
			user = dataUser.getUsers().get(login);
			if(user.getPassword().equals(password)) {
				System.out.println("Добро пожаловать, " + user.getName());
				return user;
			} else {
				System.out.println("Введен неверно логин или пароль");
				startMenu();
			}
		} else {
			System.out.println("Введен неверно логин или пароль");
			startMenu();
		}
		return user;
		
	}
	
	@Override
	public void startMenu() {
		System.out.println("Введите число");
		System.out.println("1. Войти");
		System.out.println("2. Регистрация");
		System.out.println("3. Выход");
		int key = scan.nextInt();
		Person person;
		switch (key) {
		case 1 :  	person = enterMenu();
					Session.person = person;
				    if(person instanceof Admin) {
				    	new AdminMenu(scan).start();
				    } else {
				    	new UserMenu(scan).start();
				    }
					break;
		case 2 : 	registrationMenu();
					break;
		case 3 : 	break;
		default:	System.out.println("Неверно введено число");
					startMenu();
		}
	}
	
	@Override
	public void start() {
		if(scan != null) {
			System.out.println("Учет книг в домашней библиотеке");
			System.out.println();
			startMenu();
		}
	}
	
	private void registrationMenu() {
		User user = null;
		System.out.println("Логин");
		String login = scan.next();
		DataUser dataUser = new DataUser();
		if(dataUser.getUsers().containsKey(login)) {
			System.out.println("Пользователь с таким логином уже существует");
			startMenu();
			return;
		}
		System.out.println("Пароль");
		String password = scan.next();
		System.out.println("Имя");
		String name = scan.next();
		System.out.println("Адрес электронной почты");
		String mail = scan.next();
		user = new User(login, name, password, mail);
		dataUser.getUsers().put(login, user);
		dataUser.writeUsers();
		System.out.println("Аккаунт успешно зарегестрирован");
		startMenu();
	}

}
