package lab_4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


class Log {
	Random rand=new Random();
	File logArrayList;
	File logLinkedList = new File("logLinkedList.txt");

	public static void ExtractTime(String TotalCount, ArrayList<Integer> TotalCounts, ArrayList<Integer> TotalTimes,
								   ArrayList<Integer> MedianTimes, File log) throws FileNotFoundException {
		try(BufferedReader reader=new BufferedReader(new FileReader(log))) {
			String Line;
			while((Line=reader.readLine())!=null) {
				if(Line.contains(TotalCount)) {
					int CountExtracted=Integer.parseInt(Line.replaceAll("\\D+",""));
					TotalCounts.add(CountExtracted);
					Line= reader.readLine();
					int TotalTimeExtracted=Integer.parseInt(Line.replaceAll("\\D+",""));
					TotalTimes.add(TotalTimeExtracted);
					Line= reader.readLine();
					int MedianTimeExtracted=Integer.parseInt(Line.replaceAll("\\D+",""));
					MedianTimes.add(MedianTimeExtracted);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fillArrayListLog(BufferedWriter writer, String operationName,
										 int overallTime, ArrayList<Long> timesList) throws IOException {
		for(int i=0; i<timesList.size(); ++i) {
			overallTime+=timesList.get(i);
			double ID = rand.nextDouble();
			writer.write(operationName+", ID = "+ID);
			writer.newLine();
		}
		writer.write(operationName+"TotalCount = " + timesList.size());
		writer.newLine();
		writer.write(operationName+"TotalTime = " + overallTime);
		writer.newLine();
		writer.write(operationName + "MedianTime = " +  overallTime/timesList.size());
		writer.newLine();
	}

	private void fillLinkedListLog(BufferedWriter writer, String operationName,
								  int overallTime, LinkedList<Long> timesList) throws IOException {
		for(int i=0; i<timesList.size(); ++i) {
			overallTime+=timesList.get(i);
			double ID = rand.nextDouble();
			writer.write(operationName+", ID = "+ID);
			writer.newLine();
		}
		writer.write(operationName+"TotalCount = " + timesList.size());
		writer.newLine();
		writer.write(operationName+"Total time = " + overallTime);
		writer.newLine();
		writer.write(operationName + "MedianTime = " + overallTime/timesList.size());
		writer.newLine();
	}

	private static boolean fileCreated(File file) throws IOException {
		if (!file.exists()) {
			return file.createNewFile();
		}
		return true;
	}
	
	public void ArrayList (String programStartTime, ArrayList<Long> additionTimes,
			ArrayList<Long> deletionTimes, String programFinishTime, int VehiclesAmount) throws IOException {
		logArrayList = new File("logArrayList"+VehiclesAmount+".txt");
		if (!fileCreated(logArrayList)) {
				System.err.println("File has not been created");
				return;
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logArrayList))) {
			writer.write("Start Program" + programStartTime);
			writer.newLine();
			int overallTime=0;
			fillArrayListLog(writer, "Add", overallTime, additionTimes);
			overallTime=0;
			fillArrayListLog(writer, "Remove", overallTime, deletionTimes);
			writer.write("Program Finshed at " + programFinishTime);
			writer.newLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void LinkedList (String programStartTime, LinkedList<Long> additionTimes,
									LinkedList<Long> deletionTimes, String programFinishTime, int VehiclesAmount) throws IOException {
		logArrayList = new File("logLinkedList"+VehiclesAmount+".txt");
		if (!fileCreated(logArrayList)) {
			System.err.println("File has not been created");
			return;
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logArrayList))) {
			writer.write("Start Program" + programStartTime);
			writer.newLine();
			int overallTime=0;
			fillLinkedListLog(writer, "Add", overallTime, additionTimes);
			overallTime=0;
			fillLinkedListLog(writer, "Remove", overallTime, deletionTimes);
			writer.write("Program Finshed at " + programFinishTime);
			writer.newLine();
		}catch(IOException e) {
			e.printStackTrace();
		}


	}
}
