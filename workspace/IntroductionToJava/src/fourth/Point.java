package fourth;

/**
 * Класс точка на плоскости
 * @author Ulric
 *
 */

public class Point {
	
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("Point (%.2f;%.2f)", x, y);
	}
	
	
	

}
