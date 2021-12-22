package lab_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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

	public static void lab4() throws IOException {
		ErrMsgLog eml=new ErrMsgLog();
		for (int i = 10; i != 1000000; i *= 10) {
			Create.VehicleArrayList(i, eml);
			Create.VehicleLinkedList(i, eml);
		}

	}

	//
	//@containerType - ArrayList or LinkedList
	//
	public static void lab5(String containerType) throws FileNotFoundException {
		ArrayList<Integer> AddTotalCounts=new ArrayList<Integer>();
		ArrayList<Integer> RemoveTotalCounts=new ArrayList<Integer>();
		ArrayList<Integer> AddTotalTimes=new ArrayList<Integer>();
		ArrayList<Integer> AddMedianTimes=new ArrayList<Integer>();
		ArrayList<Integer> RemoveTotalTimes=new ArrayList<Integer>();
		ArrayList<Integer> RemoveMedianTimes=new ArrayList<Integer>();
		for(int containerSize=10; containerSize<=100000;containerSize*=10 ) {
		File log=new File("log"+containerType+containerSize+".txt");
		Log.ExtractTime("AddTotalCount" /*,"AddTotalTime", "AddMedian"*/, AddTotalCounts,AddTotalTimes, AddMedianTimes, log);
		Log.ExtractTime("RemoveTotalCount" ,/*"RemoveTotalTime", "RemoveMedian",*/
				RemoveTotalCounts,RemoveTotalTimes, RemoveMedianTimes, log);
		}
		if(containerType.equals("ArrayList")) {
			Component component = new Component("Add", "Total", AddTotalTimes, AddTotalCounts, 20, 50000);
			Graphic graphicAddTotal = new Graphic(component);

			Component component1 = new Component("Add", "Median", AddMedianTimes, AddTotalCounts, 20, 20);
			Graphic graphicAddMedian = new Graphic(component1);

			Component component2 = new Component("Remove", "Total", RemoveTotalTimes, RemoveTotalCounts, 5, 100000);
			Graphic graphicRemoveTotal = new Graphic(component2);

			Component component3 = new Component("Remove", "Median", RemoveMedianTimes, RemoveTotalCounts, 5, 20);
			Graphic graphicRemoveMedian = new Graphic(component3);
		}
		else if(containerType.equals("LinkedList")) {
			Component component = new Component("Add", "Total", AddTotalTimes, AddTotalCounts, 20, 50000);
			Graphic graphicAddTotal = new Graphic(component);

			Component component1 = new Component("Add", "Median", AddMedianTimes, AddTotalCounts, 20, 50);
			Graphic graphicAddMedian = new Graphic(component1);

			Component component2 = new Component("Remove", "Total", RemoveTotalTimes, RemoveTotalCounts, 5, 1000000);
			Graphic graphicRemoveTotal = new Graphic(component2);

			Component component3 = new Component("Remove", "Median", RemoveMedianTimes, RemoveTotalCounts, 10, 200);
			Graphic graphicRemoveMedian = new Graphic(component3);
		}

	}

	public static void main(String[] args) throws IOException {
//		lab5("ArrayList");
		lab5("LinkedList");
	}
}
