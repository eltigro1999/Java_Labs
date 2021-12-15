import java.io.File;

class Log {
	Random rand=new Random();
	File logArrayList = new File("logArrayList.txt");
	File logLinkedList = new File("logLinkedList.txt");

	private static void fillArrayListLog(BufferedWrited writer, String operationName, 
			int overallTime, ArrayList<Integer> timesList) {
		for(int i=0; i<timesList.size(); ++i) {
			overallTime+=timesList.get(i);
			double ID = rand.nextDouble();
			writer.write("add, ID = "+ID);
			writer.nextLine();
		}
		writer.write(operationName+"TotalCount = " + timesList.size());
		writer.newLine();
		writer.write(operationName+"Total time = " + overallTime);
		writer.newLine();
		writer.write(operationName+"MedianTime = " + overallTime/timesList.size());
		writer.newLine();
	}

	private static boolean fileCreated(File file) {
		if (!File.exists()) {
			return file.createNewFile();
		}
		return true;
	}
	
	public static void ArrayList (String programStartTime, ArrayList<Integer> additionTimes, 
			ArrayList<Integer> deletionTimes, String programFinishTime) {
		if (!fileCreated(logArrayList)) {
				System.err.println("File has not been created");
				return;
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logArrayList))) {
			writer.write("Start Program" + programStartTime);
			writer.newLine();
			int overallTime=0;
			fillArrayListLog(writer, "Add", overallTime, additionTimes);
			/*for(int i=0; i<additionTimes.size(); ++i) {
				overallTime+=additionTime.get(i);
				double ID = rand.nextDouble();
				writer.write("add, ID = "+ID);
				writer.nextLine();
			}
			writer.write("AddTotalCount = " + additionTimes.size());
			writer.newLine();
			writer.write("AddTotal time = " + overallTime);
			writer.newLine();
			writer.write("AddMedianTime = " + overallTime/additionTime.size());
			writer.newLine();*/
			overallTime=0;
			fillArrayListLog(writer, "Remove", overallTimes, deletionTimes);
			/*for(int i=0; i<Times.size(); ++i) {
				overallTime+=additionTime.get(i);
				double ID = rand.nextDouble();
				writer.write("add, ID = "+ID);
				writer.nextLine();
			}*/
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
