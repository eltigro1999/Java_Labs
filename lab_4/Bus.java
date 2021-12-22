package lab_4;

public class Bus extends Vehicle{
	Bus() {
		super("Hyundai", "H350", 1400, 14, 173);
	}
	Bus(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
			super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
	}
}
