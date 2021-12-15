import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

class Create {

	 static Vehicle RandomVehicle() {
	 	//Emhanced switch
		 return switch ((new Random()).nextInt(5)) {
			 case 0 -> new Car();
			 case 1 -> new Motorbike();
			 case 2 -> new Trailer();
			 case 3 -> new Truck();
			 default -> new Bus();
		 };
	}

	static void VehicleArrayList(int VehiclesAmount, ErrMsgLog eml) throws IOException {
		int vehiclesAmountTenth = VehiclesAmount/10;
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		ArrayList<Long> additionTimes = new ArrayList<>();
		ArrayList<Long> deletionTimes = new ArrayList<>();
		Log log=new Log();
		String programStartTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
		for (int i=0; i< VehiclesAmount; ++i) {
			try {
				long time = System.nanoTime();
				vehicles.add(RandomVehicle());
				additionTimes.add(System.nanoTime()-time);
			} catch (Exception e) {
				//TODO
				//Log the errors
				eml.AddErrWithLog(e);
			}
		}
		for (int i=0; i<vehiclesAmountTenth; ++i) {
			try {
				long time = System.nanoTime();
				vehicles.remove(new Random().nextInt(VehiclesAmount));
				deletionTimes.add(System.nanoTime()-time);
			} catch (Exception e) {
				eml.AddErrWithLog(e);
			}
		}
		String programFinishTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
		log.ArrayList(programStartTime, additionTimes, deletionTimes, programFinishTime, VehiclesAmount);
	}

	static void VehicleLinkedList(int VehiclesAmount, ErrMsgLog eml) throws IOException {
		int vehiclesAmountTenth = VehiclesAmount/10;
		LinkedList<Vehicle> vehicles = new LinkedList<>();
		LinkedList<Long> additionTimes = new LinkedList<>();
		LinkedList<Long> deletionTimes = new LinkedList<>();
		Log log=new Log();
		String programStartTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
		for (int i=0; i< VehiclesAmount; ++i) {
			try {
				long time = System.nanoTime();
				vehicles.add(RandomVehicle());
				additionTimes.add(System.nanoTime()-time);
			} catch (Exception e) {
				eml.AddErrWithLog(e);
			}
		}
		for (int i=0; i<vehiclesAmountTenth; ++i) {
			try {
				long time = System.nanoTime();
				vehicles.remove(new Random().nextInt(VehiclesAmount));
				deletionTimes.add(System.nanoTime()-time);
			} catch (Exception e) {
				eml.AddErrWithLog(e);
			}
		}
		String programFinishTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
		log.LinkedList(programStartTime, additionTimes, deletionTimes, programFinishTime, VehiclesAmount);
	}
}

