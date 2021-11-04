import java.io.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.Calendar;

class File{
	static boolean user_found =false;
	static boolean root;
	static boolean debug;
	static boolean autotests;
	static String login = null;
	static String password = null;

	public static void logging_started_finished( java.io.File log, String started_or_finished) {
		LocalDate day = LocalDate.now();
		LocalTime time = LocalTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		try (BufferedWriter writer=new BufferedWriter(new FileWriter(log, true))) {
			writer.write("Logging has just been "+started_or_finished+". Day: " + dtf.format(now));
			writer.newLine();
		} catch (FileNotFoundException FNF) {
			FNF.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
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
		java.io.File log = new java.io.File("log.txt");
		if (!log.exists()) {
			try {
			boolean file_created = log.createNewFile();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		logging_started_finished(log, "started");
		logging_started_finished(log, "finished");
	}
}
