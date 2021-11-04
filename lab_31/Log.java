import java.io.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.Calendar;
import java.util.ArrayList;

class Log {

	private static boolean user_found =false;
	private static boolean root;
	private static boolean debug;
	private static boolean autotests;
	private static String login = null;
	private static String password = null;

	private static Scanner sc=new Scanner(System.in);

	private static void change(int id_to_change, File data_base, File log) {
		boolean no_info_about_object_to_change = true;
		boolean append = true;
		File new_data_base = new File("new_data_base.txt");
		try( BufferedReader reader = new BufferedReader(new FileReader(data_base));
		BufferedWriter writer_log = new BufferedWriter(new FileWriter(log, append));
		BufferedWriter writer_new_data_base = new BufferedWriter(new FileWriter(new_data_base, append))) {
			String vehicle_info;
			while ((vehicle_info=reader.readLine())!=null) {
				String[] params = vehicle_info.split("\\|");
				String type = params[0];
				String brand = params[1];
				String model = params[2];
				int maxcargoweight = Integer.parseInt(params[3]);
				int passengersquantity = Integer.parseInt(params[4]);
				int maxspeed = Integer.parseInt(params[5]);
				int id = Integer.parseInt(params[6]);
				if(id!=id_to_change) {
					writer_new_data_base.write(type+"|"+brand+"|"+model+"|"+maxcargoweight+"|"+passengersquantity+"|"+maxspeed+"|"+id);
					writer_new_data_base.newLine();
				} else {
					no_info_about_object_to_change=false;
					System.out.println("Insert type:");
					while((type=sc.nextLine()).isEmpty()) {
						System.out.println("Wrong input. Insert again:");
					}
					System.out.println("Insert brand:");
					//brand=sc.nextLine();
					while((brand=sc.nextLine()).isEmpty()) {
						System.out.println("Wrong input. Insert again:");
					}
					System.out.println("Insert model:");
					//model=sc.nextLine();
					while((model=sc.nextLine()).isEmpty()) {
						System.out.println("Wrong input. Insert again:");
					}
					System.out.println("Insert maximum cargo weight:");
					maxcargoweight=sc.nextInt();
					System.out.println("Insert amount of passengers:");
					passengersquantity=sc.nextInt();
					System.out.println("Insert maximum speed:");
					maxspeed=sc.nextInt();
					writer_new_data_base.write(type+"|"+brand+"|"+model+"|"+maxcargoweight+"|"+passengersquantity+"|"+maxspeed+"|"+id);
					writer_new_data_base.newLine();
					writer_log.write("OBJECT "+type+" with id: "+id+" CHANGED");
					writer_log.newLine();
				}
			}	
			if (no_info_about_object_to_change) {
				writer_log.write("TRIED TO CHANGE NON_EXISTENT OBJECT");
				writer_log.newLine();
			}
		} catch (FileNotFoundException FNF) {
			FNF.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if(no_info_about_object_to_change) {
			new_data_base.delete();
		} else {
			data_base.delete();
			data_base=new_data_base;
			data_base.renameTo(new File("data_base.txt"));
		}
	}

	private static void delete (int id_to_delete, File data_base, File log) {
		boolean no_info_about_object_to_delete = true;
		boolean append = true;
		File new_data_base = new File("new_data_base.txt");
		try(BufferedReader reader = new BufferedReader(new FileReader(data_base));
		BufferedWriter writer_log = new BufferedWriter(new FileWriter(log, append));
		BufferedWriter writer_new_data_base = new BufferedWriter(new FileWriter(new_data_base, append))) {
			String vehicle_info;
			while ((vehicle_info=reader.readLine())!=null) {
				String[] params = vehicle_info.split("\\|");
				String type = params[0];
				String brand = params[1];
				String model = params[2];
				int maxcargoweight = Integer.parseInt(params[3]);
				int passengersquantity = Integer.parseInt(params[4]);
				int maxspeed = Integer.parseInt(params[5]);
				int id = Integer.parseInt(params[6]);
				if(id!=id_to_delete) {
					writer_new_data_base.write(type+"|"+brand+"|"+model+"|"+maxcargoweight+"|"+passengersquantity+"|"+maxspeed+"|"+id);
					writer_new_data_base.newLine();
				} else {
					no_info_about_object_to_delete=false;
					writer_log.write("OBJECT "+type+" DELETED");
					writer_log.newLine();
				}
			}	
			if (no_info_about_object_to_delete) {
				writer_log.write("TRIED TO DELETE NON_EXISTENT OBJECT");
				writer_log.newLine();
			}
		} catch (FileNotFoundException FNF) {
			FNF.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if(no_info_about_object_to_delete) {
			new_data_base.delete();
		} else {
			data_base.delete();
			data_base=new_data_base;
			data_base.renameTo(new File("data_base.txt"));
		}
	}

	private static void put(ArrayList<Vehicle> vehicles, File data_base, File log) {

		boolean append = true;
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(data_base, append));
				BufferedWriter writer_log=new BufferedWriter(new FileWriter(log, append))) {
			if(vehicles.size()==0) {
				writer_log.write("ERROR: NO VEHICLES HAS BEEN LOGGED");
				writer_log.newLine();
				return;
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			for (Vehicle vehicle : vehicles) {
				
				writer.write(vehicle.GetInfoForLogging());
				writer.newLine();

				LocalDate day = LocalDate.now();
				LocalTime time = LocalTime.now();
				LocalDateTime now = LocalDateTime.now();
				writer_log.write(vehicle.GetTypeOfVehicle()+new String(" is added to programm at "+dtf.format(now)));
				writer_log.newLine();
			}
		} catch (FileNotFoundException FNF){
			FNF.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void get(ArrayList<Vehicle> vehicles, File data_base, File log) {
		boolean append=true;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(data_base));
		BufferedWriter writer = new BufferedWriter(new FileWriter(data_base, append));
		BufferedWriter writer_log = new BufferedWriter(new FileWriter(log, append))) {
			String vehicle_info;
			boolean noLogging=true;
			while ((vehicle_info=reader.readLine())!=null) {
				noLogging=false;
				String[] params = vehicle_info.split("\\|");
				String type = params[0];
				String brand = params[1];
				String model = params[2];
				int maxcargoweight = Integer.parseInt(params[3]);
				int passengersquantity = Integer.parseInt(params[4]);
				int maxspeed = Integer.parseInt(params[5]);
				int id = Integer.parseInt(params[6]);
				if (type.equals("Car")) {
					vehicles.add(new Car(brand, model, maxcargoweight, passengersquantity, maxspeed));
				} else if (type.equals("Bus")) {
					vehicles.add(new Bus(brand, model, maxcargoweight, passengersquantity, maxspeed));
				} else if (type.equals("Truck")) {
					vehicles.add(new Truck(brand, model, maxcargoweight, passengersquantity, maxspeed));
				} else if (type.equals("Trailer")) {
					vehicles.add(new Trailer(brand, model, maxcargoweight, passengersquantity, maxspeed));
				} else if (type.equals("Motorbike")) {
					vehicles.add(new Motorbike(brand, model, maxcargoweight, passengersquantity, maxspeed));
				}
				
				LocalDate day = LocalDate.now();
				LocalTime time = LocalTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				
				writer_log.write(type+new String(" is added to programm at "+dtf.format(now)));
				writer_log.newLine();
			}
			if(noLogging) {
				writer_log.write("ERROR: NO VEHICLES HAD BEEN LOGGED");
				writer_log.newLine();
			}	
		} catch (FileNotFoundException FNF) {
			FNF.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static String func_interface() {
		System.out.println("1. Add object to log");
		System.out.println("2. Delete object from log");
		System.out.println("3. Load data from log lo program");
		System.out.println("4. Change data in data_base");
		System.out.println("5. Exit");
		Scanner sc=new Scanner(System.in);
		return sc.nextLine();
	}

	//Function for formatting text in log.txt

	private static void logging_started_finished( java.io.File log, String login, String started_or_finished) {
		LocalDate day = LocalDate.now();
		LocalTime time = LocalTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		boolean append = true;

		try (BufferedWriter writer=new BufferedWriter(new FileWriter(log, append))) {
			writer.write(login+" "+started_or_finished+" logging. Day: " + dtf.format(now));
			writer.newLine();
		} catch (FileNotFoundException FNF) {
			FNF.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void log(ArrayList<Vehicle> vehicles) {
		System.out.println("Welcome!");
		while(!user_found) {
			root=true;
			autotests=true;
			debug=true;
			try(BufferedReader reader=new BufferedReader(new FileReader("settings.txt"))) {
				System.out.println("login: ");
				login = sc.nextLine();
				String buff;
				while( (buff=reader.readLine())!=null) {
					if (buff.equals(new String("user:"))) {
						root = false;
						debug = false;
						autotests = false;
					}
					if(buff.equals(new String("login: ")+login)) {						
						break;
					}
				}
				if (buff == null) {
					System.out.println("Wrong login!\n");
					continue;
				}
				System.out.println("password: ");
				String password = sc.nextLine();
				buff = reader.readLine();
				if (!buff.equals(new String("password: ") + password)) {
					System.out.println("Wrong password.");
					continue;
				}
				user_found = true;
			} catch (FileNotFoundException FNF) {
				FNF.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		File log = new java.io.File("log.txt");
		File data_base = new File("data_base.txt");
		if (!log.exists()) {
			try {
			boolean file_created = log.createNewFile();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		if (!data_base.exists()) {
			try {
			boolean file_created = data_base.createNewFile();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		logging_started_finished(log, login, "started");
		String option="";
		while(!option.equals("5")) {
			System.out.println("Choice: "+(option=func_interface()));
			if (option.equals(new String("1"))) {
				put(vehicles, data_base, log);
			} else if (option.equals("2")) {
				delete(vehicles.get(3).GetId(), data_base, log);
			} 
		       	else if (option.equals("3")) {
				get(vehicles, data_base, log);
			}
			else if (option.equals("4")) {
				change(vehicles.get(3).GetId(), data_base, log);
			}
		}
		logging_started_finished(log, login, "finished");
	}
}
