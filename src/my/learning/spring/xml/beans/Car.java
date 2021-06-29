package my.learning.spring.xml.beans;

public class Car {

	private String model;	
	
	public Car(String model) {
		this.model = model;
	}

	public void move() {
		System.out.println("Car of model " + this.model + " is moving...");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
