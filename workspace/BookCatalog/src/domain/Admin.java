package domain;

import java.io.Serializable;

/**
 * Администратор
 * @author Dima Zosimov
 * @version 1.0 04.02.2020
 *
 */

public class Admin extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Admin(String login, String name, String password, String mail) {
		super(login, name, password, mail);
		this.setAdmin(true);
	}

	@Override
	public String toString() {
		return "admin: " + super.toString();
	}

}
