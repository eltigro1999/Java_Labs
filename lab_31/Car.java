class Car extends Vehicle {
	Car() {
	super("Lada", "Sedan", 1000, 5, 150);
	}
	Car(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
		type="Car";
	}
	@Override
	String GetTypeOfVehicle() {
		return new String("Car");
	}
}
