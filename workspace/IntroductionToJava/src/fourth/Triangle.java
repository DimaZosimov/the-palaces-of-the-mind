package fourth;

/**
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
 * площади, периметра и точки пересечения медиан.
 * 
 * @author Dima Zosimov
 *
 */

public class Triangle {
	
	private double side1;
	private double side2;
	private double side3;
	private double angle1;
	private double angle2;
	private double angle3;
	private double square;
	private double perimetr;
	private Point pointCrossMer;
	private Point point1;
	private Point point2;
	private Point point3;
	
	public Triangle(double side1, double side2, double side3) {
		if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
			throw new IllegalArgumentException();
		}
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		perimetr = Perimetr(side1, side2, side3);
		square = Square(side1, side2, side3);
		angle1 = (Angle(side1, side2, side3) * 180) / Math.PI;;
		angle2 = (Angle(side2, side1, side3) * 180) / Math.PI;
		angle3 = (Angle(side3, side1, side2) * 180) / Math.PI;
		point1 = new Point(0,0);
		point3 = new Point(side2, 0);
		point2 = new Point(Math.cos((angle1 * Math.PI) / 180) * side3, Math.sin((angle1 * Math.PI) / 180) * side3);
		pointCrossMer = crossPoint(point1, point2, point3);
	}
	
	public Triangle() {
		this(3, 4, 5);
	}
	
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}

	public double getAngle1() {
		return angle1;
	}

	public double getAngle2() {
		return angle2;
	}

	public double getAngle3() {
		return angle3;
	}

	public double getSquare() {
		return square;
	}

	public double getPerimetr() {
		return perimetr;
	}

	public Point getPointCrossMer() {
		return pointCrossMer;
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public Point getPoint3() {
		return point3;
	}

	private static double Perimetr(double side1, double side2, double side3) {
		return side1 + side2 + side3;
	}
	private static double Square(double side1, double side2, double side3) {
		double pp = Perimetr(side1, side2, side3) / 2;
		return Math.sqrt(pp * (pp - side1) * (pp - side2) * (pp - side3));
	}
	private static double Angle(double a, double b, double c) {
		return Math.acos((a*a - b*b - c*c) / (-2 * b * c));
	}
	private static Point crossPoint(Point point1, Point point2, Point point3) {
		double x = (point1.getX() + point2.getX() + point2.getX()) / 3;
		double y = (point1.getY() + point2.getY() + point2.getY()) / 3;
		return new Point(x,y);
	}

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", angle1=" + angle1 + ", angle2="
				+ angle2 + ", angle3=" + angle3 + ", point1=" + point1 + ", point2=" + point2 + ", point3=" + point3
				+ "]";
	}
	
	
	
	
	

}
