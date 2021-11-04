class Motorbike extends Vehicle {
	public Motorbike() {
		super("Yamaha", "YBR125", 200, 1, 110);
		type="Motorbike";
	}
	public Motorbike(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
		type="Motorbike";
	}
	@Override
	String GetTypeOfVehicle() {
		return new String("Motorbike");
	}
}
