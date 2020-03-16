package mail;

import java.util.HashMap;
import java.util.Map;

import data.DataUser;
import domain.Person;

/**
 * 
 * @author Dima Zosimov
 * @version 1.0 19.02.2020
 *
 */

public class MailSender {
	
	private HashMap<String, Person> users;
	
	public MailSender() {
		DataUser dataUser = new DataUser();
		this.users = dataUser.getUsers();
	}
	
	public void sendMail(Person from, Person to, String message, Object object) {
		System.out.println("Mail отправлен от " + from + " к " + to);
		System.out.println("Сообщение:\n" + message);
		System.out.println("Прикрепленные объекты:\n" + object);		
	}
	
	public void sendMailAllUsers(Person from, String message, Object object) {
		for(Map.Entry<String, Person> user : users.entrySet()) {
			if(!from.equals(user.getValue())) {
				sendMail(from, user.getValue(), message, object);
			}
		}
	}
	
	public void sendMailToAdmin(Person from, String message, Object object) {
		sendMail(from, users.get("admin"), message, object);
	}

}
