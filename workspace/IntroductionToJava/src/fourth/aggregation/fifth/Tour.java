package fourth.aggregation.fifth;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class Tour {
	
	private String country;
	private String type;
	private String transport;
	private String nutrition;
	private int days;
	
	public Tour(String country, String type, String transport, String nutrition, int days) {
		this.country = country;
		this.type = type;
		this.transport = transport;
		this.nutrition = nutrition;
		this.days = days;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTransport() {
		return transport;
	}
	
	public void setTransport(String transport) {
		this.transport = transport;
	}
	
	public String getNutrition() {
		return nutrition;
	}
	
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%d\t%s\t%s", country, type, days, nutrition, transport);
	}
	
	
	public boolean equalsCountry(String country) {
		return this.country.equalsIgnoreCase(country);
	}
	
	public boolean equalsType(String type) {
		return this.type.equalsIgnoreCase(type);
	}
	
	public boolean equalsNutrition(String nurtition) {
		return this.nutrition.contains(nurtition);
	}
	
	public boolean equalsTransport(String transport) {
		return this.transport.equalsIgnoreCase(transport);
	}
	
	

}
