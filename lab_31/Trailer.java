class Trailer extends Vehicle {
	Trailer() {
		super("SCHMITZ", "ACF", 20000, 21, 162);
		type="Trailer";
	}
	Trailer(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
	}
	@Override
	String GetTypeOfVehicle() {
		return new String("Trailer");
	}
}
