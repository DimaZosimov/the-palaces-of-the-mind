package domain;

import java.io.Serializable;

/**
 * Пользователь 
 * @author Dima Zosimov
 * @version 1.0 04.02.2020
 *
 */

public class User extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public User(String login, String name, String password, String mail) {
		super(login, name, password, mail);
	}
	
	@Override
	public String toString() {
		return "user: " + super.toString();
	}

}
