abstract class Vehicle {
	protected String type="vehicle";
	protected String brand;
	protected String model;
	protected int max_cargo_weight;
	protected int passengers_quantity;
	protected int max_speed;
	protected static int static_id=0;
	protected int id=static_id;
	Vehicle() {
		this("BMW", "X5", 500, 5, 250);
	}
	Vehicle(String brand, String model,int max_cargo_weight,int passengers_quantity, int max_speed) {
		this.brand=brand;
		this.model=model;
		this.max_cargo_weight=max_cargo_weight;
		this.passengers_quantity=passengers_quantity;
		this.max_speed=max_speed;
		id=static_id;
		static_id++;
	}
	String GetTypeOfVehicle() {
		return type;
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
	int GetId() {
		return id;
	}
	static int GetStaticId() {
		return static_id;
	}
	String GetInfoForLogging() {
		return this.GetTypeOfVehicle()+"|"+this.GetBrand()+"|"+this.GetModel()+"|"+this.GetMaxCargoWeight()+"|"+this.GetPassengersQuantity()+"|"+this.GetMaxSpeed()+"|"+this.GetId();
	}
}
