package assignment3;

public class TestCylinder {
	 public static void main(String[] args) {
		   
	      //Constructed a Circle with Circle()
		  Circle c1 = new Circle();
		  System.out.println(c1.getRadius()+ " " + c1.getColor());
	      //Run of the program should produce the following output:
		  c1.setRadius(2.0);
		  c1.setColor("yellow");
		  System.out.println("Radius is " + c1.getRadius()+ ", Color is " + c1.getColor() + ", Base area is " + c1.getArea());
	      //Radius is 2.0, Color is yellow, Base area is (your answer)
	      
	      //Constructed a Cylinder with Cylinder()
		  Cylinder cy1 = new Cylinder();
		  System.out.println("Radius is " + cy1.getRadius()+ ", Color is " + cy1.getColor() + ", Height is " + cy1.getHeight() 
		  					+ ", Base area is " + cy1.getArea() + ", Volume is " + cy1.getVolume());
	      //Run of the program should produce the following output:
	      //Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)

	      //Constructed a Cylinder with Cylinder(height, radius)
		  Cylinder cy2 = new Cylinder(5.0, 2.0);
		  System.out.println("Radius is " + cy2.getRadius()+ ", Color is " + cy2.getColor() + ", Height is " + cy2.getHeight() 
			+ ", Base area is " + cy2.getArea() + ", Volume is " + cy2.getVolume());
	      //Run of the program should produce the following output:
	      //Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
	 }
}

class Circle {
	protected double radius;
	protected String color;
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.color = "";
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return (double) Math.pow(this.radius, 2) * Math.PI;
	}
}

class Cylinder extends Circle {
	private double height;
	
	public Cylinder() {
		this.height = 1.0;
	}
	
	public Cylinder(double height) {
		this.height = height;
	}
	
	public Cylinder(double height, double radius) {
		this.radius = radius;
		this.height = height;
	}
	
	public Cylinder(double height, double radius, String color) {
		this.radius = radius;
		this.height = height;
		this.color = color;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getVolume() {
		double area = super.getArea();
		return (double) area * this.height;
	}
	
	@Override
	public double getArea() {
		return (double) 2 * this.radius * (this.radius + this.height) * Math.PI;
	}
}
