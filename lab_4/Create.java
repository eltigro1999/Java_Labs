import java.util.Random;
import java.util.ArrayList;
import java.util.io.IOException;
import java.util.ArrayList;

class Create {
	Random rand=new Random();
	static Vehicle RandomVehicle() {
		switch (rand.nextInt(5)) {
			case 0: return new Car();
				break;
			case 1: return new Motorbike();
				break;
			case 2: return new Trailer();
				break;
			case 3: return new Truck();
				break;
			case 4: return new Bus();
				break;
		}
	}
	static void VehicleArrayList(int VehiclesAmount) {
		int vehiclesAmountTenth = VehiclesAmount/10;
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		ArrayList<Integer> additionTimes = new ArrayList<>();
		ArrayList<Integer> deletionTimes = new ArrayList<>();
		String programStartTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		for (int i=0; i< VehiclesAmount; ++i) {
			try {
				int time = System.currentTimeMillis();
				vehicles.add(Create.RandomVehicle());
				additionTimes.add(System.currentTimeMillis()-time);
			} catch (Exception e) {
				//TODO
				//Log the errors
			}
		}
		for (int i=0; i<VehiclesAmountTenth; ++i) {
			try {
				int time = System.currentTimeMillis();
				vehicles.remove(rand.nextInt(VehiclesAmount));
				deletionTimes.add(System.currentTimeMillis()-time);
			} catch (Exception e) {
				//TODO
				//Log the errors
			}
		}
		String programFinishTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		Log.ArrayList(programStartTime, additionTimes, deletionTimes, programFinishTime);
	}
}

