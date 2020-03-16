package fourth.aggregation.second;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class Wheel {
	
	private String tireManufact;
	private String rimManufact;
	private double width;
	private double radius;
	
	public Wheel(String tireManufact, String rimManufact, double width, double radius) {
		this.tireManufact = tireManufact;
		this.rimManufact = rimManufact;
		if(width <= 0 || radius <= 0) throw new IllegalArgumentException();
		this.width = width;
		this.radius = radius;
	}
	
	public Wheel(double width, double radius) {
		this("pirelli", "K&K", width, radius);
	}
	
	public Wheel() {
		this(12.5, 15);		
	}
	
	public String getTireManufact() {
		return tireManufact;
	}
	
	public void setTireManufact(String tireManufact) {
		this.tireManufact = tireManufact;
	}
	
	public String getRimManufact() {
		return rimManufact;
	}
	
	public void setRimManufact(String rimManufact) {
		this.rimManufact = rimManufact;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Wheel [tireManufact=" + tireManufact + ", rimManufact=" + rimManufact + ", width=" + width + ", radius="
				+ radius + "]";
	}
	
}
