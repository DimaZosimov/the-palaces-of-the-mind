package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Заметка
 * @author Dima Zosimov
 * @version 1.0 20.02.2020
 *
 */

public class Note implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String topic;
	private Date date;
	private String mail;
	private String message;
	private String dateString;
	
	public Note(String topic, String mail, String message) {
		this.topic = topic;
		this.date = new Date();
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		this.dateString = sdf.format(date);
		this.mail = mail;
		this.message = message;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("%s%n%s%n%s%n%s%n", topic, dateString, mail, message);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		Note other = (Note) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

	
	
	

}
