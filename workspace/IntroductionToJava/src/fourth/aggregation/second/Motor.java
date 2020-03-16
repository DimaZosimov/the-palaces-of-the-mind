package fourth.aggregation.second;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class Motor {
	
	private String manufacturer;
	private String model;
	private double capacity;
	private double power;
	private String type;
	
	public Motor(String manufacturer, String model, double capacity, double power, String type) {
		if(capacity < 500 || power <= 0) throw new IllegalArgumentException();
		this.manufacturer = manufacturer;
		this.model = model;
		this.capacity = capacity;
		this.power = power;
		this.type = type;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public double getPower() {
		return power;
	}
	
	public void setPower(double power) {
		this.power = power;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Motor [manufacturer=" + manufacturer + ", model=" + model + ", capacity=" + capacity + ", power="
				+ power + ", type=" + type + "]";
	}
	
}
