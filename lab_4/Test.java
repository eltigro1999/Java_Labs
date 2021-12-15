class Test {
	static void Polymorphism(Vehicle vehicle) {	//Shows info about the object
		System.out.println( vehicle.GetBrand());
		System.out.println( vehicle.GetModel());
		System.out.println( vehicle.GetMaxCargoWeight());
		System.out.println( vehicle.GetPassengersQuantity());
		System.out.println( vehicle.GetMaxSpeed());
		System.out.println();
	}

	public static void lab2() {

		//Lab 2

		//Vehicle v=new Vehicle();	It's abstract. So the object of the abstract class
		//				 is not allowed to be created
		
		Motorbike bike=new Motorbike();
		Polymorphism(bike);
		Motorbike suzuki=new Motorbike("Suzuki", "V-STROM", 200, 2, 173);	
		Polymorphism(suzuki);
		
				
		Car car=new Car();
		Polymorphism(car);
		Car audi=new Car("Audi", "q8", 600, 5, 250);
		Polymorphism(audi);
		

		Truck truck=new Truck();
		Polymorphism(truck);
		Truck Mercedes=new Truck("Mercedes Benz", "Actros", 135000, 40, 162);
		Polymorphism(Mercedes);
	
		Bus bus=new Bus();
		Polymorphism(bus);
		Bus man = new Bus("Man", "Lion's coach", 25300, 59, 120);
		Polymorphism(man);
		
		Trailer trailer=new Trailer();
		Polymorphism(trailer);
		Trailer krone=new Trailer("Krone", "Model", 10000, 40, 125);
		Polymorphism(krone);
		trailer.addTruck(truck);
		System.out.println("Has truck:"+trailer.HasTruck());
		System.out.println("Speed:"+trailer.GetMaxSpeed());
	}

	public static void main(String args[]) {
		lab2();
	}
}
