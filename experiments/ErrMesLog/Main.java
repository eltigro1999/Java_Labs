import java.util.logging.Logger;

class Main {
	private static Logger log;
	public static void main(String[] args) {
		log = Logger.getLogger(Main.class.getName());
		System.err.println("Message");
	}
}
