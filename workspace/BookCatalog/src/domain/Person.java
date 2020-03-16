package domain;

import java.io.Serializable;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 04.02.2020
 *
 */

public abstract class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String name;
	private String password;
	private String mail;
	private boolean isAdmin = false;
	
	public Person(String login, String name, String password, String mail) {
		this.login = login;
		this.name = name;
		this.password = password;
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", mail=" + mail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (isAdmin != other.isAdmin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
	
}
