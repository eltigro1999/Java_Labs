import java.util.ArrayList;

class Test {
	ArrayList<Vehicle> vehicles;
	ArrayList<Vehicle> vehicles_loaded=new ArrayList<Vehicle>(0);

	static void Polymorphism(Vehicle vehicle) {	//Shows info about the object
		System.out.println( vehicle.GetBrand());
		System.out.println( vehicle.GetModel());
		System.out.println( vehicle.GetMaxCargoWeight());
		System.out.println( vehicle.GetPassengersQuantity());
		System.out.println( vehicle.GetMaxSpeed());
		System.out.println( vehicle.GetId());
		System.out.println( vehicle.GetStaticId());
		System.out.println();
	}

	public void lab_2() {

		//Lab 2

		//Vehicle v=new Vehicle();	It's abstract. So the object of the abstract class
		//				 is not allowed to be created
		
		vehicles = new ArrayList<Vehicle>();

		Motorbike bike=new Motorbike();
		//Polymorphism(bike);
		vehicles.add(bike);
		Motorbike suzuki=new Motorbike("Suzuki", "V-STROM", 200, 2, 173);	
		//Polymorphism(suzuki);
		vehicles.add(suzuki);
		
				
		Car car=new Car();
		//Polymorphism(car);
		vehicles.add(car);
		Car audi=new Car("Audi", "q8", 600, 5, 250);
		//Polymorphism(audi);
		vehicles.add(audi);

		Truck truck=new Truck();
		//Polymorphism(truck);
		vehicles.add(truck);
		Truck Mercedes=new Truck("Mercedes Benz", "Actros", 135000, 40, 162);
		//Polymorphism(Mercedes);
		vehicles.add(Mercedes);
	
		Bus bus=new Bus();
		//Polymorphism(bus);
		vehicles.add(bus);
		Bus man = new Bus("Man", "Lion's coach", 25300, 59, 120);
		//Polymorphism(man);
		vehicles.add(man);
		
		Trailer trailer=new Trailer();
		//Polymorphism(trailer);
		vehicles.add(trailer);
		Trailer krone=new Trailer("Krone", "Model", 10000, 40, 125);
		//Polymorphism(krone);
		vehicles.add(krone);
		
	}

	public void lab3(ArrayList<Vehicle> vehicles) {
		Log.log(vehicles);
	}


	public static void main(String args[]) {
		Test test = new Test();
		test.lab_2();
		//for (Vehicle vehicle : test.vehicles) {
		//	System.out.println(vehicle.GetBrand());
		//}
		//System.out.println("\n\n\n");
		//Log.log(test.vehicles);
		Log.log(test.vehicles);
		for (Vehicle vehicle : test.vehicles) {
			System.out.println(vehicle.GetId());
		}
	}
}
