import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

class ErrMsgLog {
	ArrayList<Exception> exceptions=new ArrayList<>();
	private final static Logger logger= Logger.getLogger(ErrMsgLog.class.getName());
	ErrMsgLog() throws IOException {
		FileHandler fh=new FileHandler("ErrorLog.txt");
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
	}
	public void AddErrWithLog(Exception e) {
		exceptions.add(e);
		logger.log(Level.SEVERE, e.getMessage() );
	}
	public int AmountOfExceptions(){
		return exceptions.size();
	}
}
