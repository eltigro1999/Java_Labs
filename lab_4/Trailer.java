public class Trailer extends Vehicle {
	boolean hasTruck=false;
	Truck truck=null;
	Trailer() {
		super("SCHMITZ", "ACF", 20000, 21, 162);
	}
	Trailer(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		super(brand, model, max_cargo_weight, passengers_quantity, max_speed);
	}
	void addTruck(Truck truck) {
		this.truck=truck;
		hasTruck=true;
		max_speed-=20;
	}
	boolean HasTruck() {
		return hasTruck;
	}
}
