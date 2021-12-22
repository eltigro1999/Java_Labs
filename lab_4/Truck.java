package lab_4;

public class Truck extends Vehicle {
	Truck() {
		super("Man", "F2000", 25000, 50, 150);
	}
	Truck(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
	}
}
