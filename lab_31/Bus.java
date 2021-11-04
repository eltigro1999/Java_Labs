class Bus extends Vehicle{
	Bus() {
		super("Hyundai", "H350", 1400, 14, 173);
		type="Bus";
	}
	Bus(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
			super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
			type="Bus";
	}
	@Override
	String GetTypeOfVehicle() {
		return new String("Bus");
	}
}
