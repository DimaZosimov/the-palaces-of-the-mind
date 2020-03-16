package data;

import java.io.File;

/**
 * Список пользователей
 * @author Dima Zosimov
 * @version 1.0 07.02.2020
 * @version 1.1 10.02.2020 - изменены Loader и Writer 
 */

import java.util.HashMap;

import domain.*;
import tools.Loader;
import tools.Writer;

public class DataUser {
	/**
	 * key - login
	 * value - Person
	 */
	private HashMap<String, Person> users;
	private final File FILE = new File("src\\data\\datauser.txt");
		
	public DataUser() {
		Loader loader = new Loader(FILE);
		users = (HashMap<String, Person>) loader.load();
		if(users == null) {
			users = new HashMap<String, Person>();
			if(!users.containsKey("admin")) {
				users.put("admin", new Admin("admin", "admin", "admin", "admin@ttt.by"));
			}
		}
	}

	public HashMap<String, Person> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, Person> users) {
		this.users = users;
	}
	
	public void writeUsers() {
		Writer writer = new Writer(FILE);
		writer.write(users);
	}

}
