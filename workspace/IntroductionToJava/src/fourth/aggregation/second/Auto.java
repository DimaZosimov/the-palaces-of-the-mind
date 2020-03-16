package fourth.aggregation.second;

/**
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 * 
 * @author Dima Zosimov
 *
 */

public class Auto {
	
	private String model;
	private Wheel frontLeftWheel;
	private Wheel frontRightWheel;
	private Wheel rearLeftWheel;
	private Wheel rearRightWheel;
	private Motor motor;
	private double fuelTankCapacity;
	private double fuel = 0;
	private boolean start = false;
	
	public Auto(String model, Wheel frontLeftWheel, Wheel frontRightWheel, Wheel rearLeftWheel, Wheel rearRightWheel,
			Motor motor, double fuelTankCapacity) {
		this.model = model;
		this.frontLeftWheel = frontLeftWheel;
		this.frontRightWheel = frontRightWheel;
		this.rearLeftWheel = rearLeftWheel;
		this.rearRightWheel = rearRightWheel;
		this.motor = motor;
		if(fuelTankCapacity < 10) throw new IllegalArgumentException();
		this.fuelTankCapacity = fuelTankCapacity;
	}
	 public void fill(double fuel) {
		 if(fuel < 0) throw new IllegalArgumentException();
		 if((this.fuel + fuelTankCapacity) < fuel) {
			 System.out.println("Требуется меньше топлива");
			 return;
		 }
		 this.fuel += fuel;
		 System.out.println("Машина заправлена на " + fuel);
	 }
	 
	 public void drive() {
		 if(!start) {
			 start = true;
		 }
		 System.out.println("Машина едет");
	 }
	 
	 public boolean changeWheel(Wheel wheel, String whichWheel) {
		 switch (whichWheel) {
		 case "frontLeft": setFrontLeftWheel(wheel); return true;
		 case "frontRight" : setFrontRightWheel(wheel); return true;
		 case "rearLeft" : setRearLeftWheel(wheel); return true;
		 case "rearRight" : setRearRightWheel(wheel); return true;
		 default: return false;
		 }
	 }
	public void setFrontLeftWheel(Wheel frontLeftWheel) {
		this.frontLeftWheel = frontLeftWheel;
	}
	public void setFrontRightWheel(Wheel frontRightWheel) {
		this.frontRightWheel = frontRightWheel;
	}
	public void setRearLeftWheel(Wheel rearLeftWheel) {
		this.rearLeftWheel = rearLeftWheel;
	}
	public void setRearRightWheel(Wheel rearRightWheel) {
		this.rearRightWheel = rearRightWheel;
	}
	public void printModel() {
		System.out.println(model);
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	 
	 
	
	

}
