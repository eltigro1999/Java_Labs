abstract class Vehicle {
	private String brand;
	private String model;
	private int max_cargo_weight;
	private int passengers_quantity;
	private int max_speed;
	Vehicle() {
		this("BMW", "X5", 500, 5, 250);
	}
	Vehicle(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		this.brand=brand;
		this.model=model;
		this.max_cargo_weight=max_cargo_weight;
		this.passengers_quantity=passengers_quantity;
		this.max_speed=max_speed;
	}
	String GetBrand() {
		return brand;
	}
	String GetModel() {
		return model;
	}
	int GetMaxCargoWeight() {
		return max_cargo_weight;
	}
	int GetPassengersQuantity() {
		return passengers_quantity;
	}
	int GetMaxSpeed() {
		return max_speed;
	}
}
