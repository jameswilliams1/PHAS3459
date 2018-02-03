package exam1;

/*
 * Reads measurements of sea-ice data from a URL and performs analysis
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class MidTermExam {

	// Returns (unsorted) ArrayList object from web page input
	public static ArrayList<Measurement> dataFromURL(String urlName) throws IOException {
		// Creates empty ArrayList
		ArrayList<Measurement> measurements = new ArrayList<Measurement>();
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		for (int i = 0; i < 1; i++) { // Skips 1st row
			br.readLine();
		}
		// Iterates while next token present
		while ((line = br.readLine()) != null) {
			// Parses each line into Measurement object
			Measurement m = Measurement.parseLine(line);
			// Adds each Player to ArrayList
			measurements.add(m);
		}
		return measurements;
	}

	public static void main(String[] args) {

		ArrayList<Measurement> unsorted = new ArrayList<Measurement>(); // Initialises list of Measurement objects
																		// (unsorted)
		try {
			System.out.println(
					"Reading sea-ice data from: http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv");
			// Fills ArrayList with Measurement objects (unsorted)
			unsorted = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv");
		} catch (IOException e) {
			System.out.println(e + " Page does not exist");
		}

		System.out.println("Total number of measurements recorded: " + unsorted.size());
		System.out.println();

		// Empty HashMap of ArrayLists of Measurement objects sorted by month
		HashMap<Integer, ArrayList<Measurement>> sorted = new HashMap<Integer, ArrayList<Measurement>>();
		// Iterates over Measurement list & sorts into ArrayList objects by month
		for (Measurement m : unsorted) {
			int currentMonth = m.getMonth(); // Gets month of current Measurement
			ArrayList<Measurement> currentMeasurements = sorted.get(currentMonth); // Creates new list of measurements
			if (currentMeasurements == null) {
				sorted.put(currentMonth, new ArrayList<Measurement>()); // Creates month in HashMap if not already
																		// present
			}
			sorted.get(currentMonth).add(m); // Adds current measurement to corresponding month
		}

		double minExtent = Double.MAX_VALUE; // Initialises minExtent/minArea to largest double value
		int minExtentMonth = 0;
		int minExtentYear = 0;
		int minExtentIndex = 0;
		double minArea = Double.MAX_VALUE;
		int minAreaMonth = 0;
		int minAreaYear = 0;
		int minAreaIndex = 0;
		for (int month : sorted.keySet()) { // Iterates over each month in HashMap
			for (Measurement m : sorted.get(month)) { // Iterates over each Measurement in each month
				if (m.getExtent() < minExtent && m.getExtent() != -9999) { // Finds measurement with lowest extent
																			// (excluding -9999)
					minExtent = m.getExtent();
					minExtentMonth = m.getMonth();
					minExtentYear = m.getYear();
				}
				if (m.getArea() < minArea && m.getArea() != -9999) { // Finds measurement with lowest area
					// (excluding -9999)
					minArea = m.getArea();
					minAreaMonth = m.getMonth();
					minAreaYear = m.getYear();
				}
			}
		}

		for (int i = 0; i < sorted.get(minExtentMonth).size(); i++) { // Iterates over month w/ min extent to find
																		// corresponding index in ArrayList
			if (sorted.get(minExtentMonth).get(i).getYear() == minExtentYear) {
				minExtentIndex = i;
			}
		}
		for (int i = 0; i < sorted.get(minAreaMonth).size(); i++) { // Iterates over month w/ min area to find
			// corresponding index in ArrayList
			if (sorted.get(minAreaMonth).get(i).getYear() == minAreaYear) {
				minAreaIndex = i;
			}
		}
		System.out.println("Lowest total ice extent was: " + minExtent + " million KM^2");
		System.out.println("Details of measurement:");
		System.out.println(sorted.get(minExtentMonth).get(minExtentIndex));
		System.out.println();
		System.out.println("Lowest total ice area was: " + minArea + " million KM^2");
		System.out.println("Details of measurement:");
		System.out.println(sorted.get(minAreaMonth).get(minAreaIndex));
		System.out.println();

		int minAreaThisYear = 0;
		for (int month : sorted.keySet()) { // Iterates over each month in HashMap
			double minAreaThisMonth = Double.MAX_VALUE; // Resets minAreaThisMonth each month
			for (Measurement m : sorted.get(month)) { // Iterates over each Measurement in each month
				if (m.getArea() < minAreaThisMonth && m.getArea() != -9999) { // Finds measurement with lowest area
					// (excluding -9999)
					minAreaThisMonth = m.getArea();
					minAreaThisYear = m.getYear();
				}
			}

			System.out.println("For month: " + month + " minimum ice area was: " + minAreaThisMonth
					+ " million KM^2 in: " + minAreaThisYear);
			int index = 0; // index of min Area for each month
			for (int i = 0; i < sorted.get(month).size(); i++) { // Iterates over each month to get index of year with
																	// min area
				if (sorted.get(month).get(i).getArea() == minAreaThisMonth) {
					index = i;
				}
			}
			// Finds difference between min area & area previous year
			double difference = (minAreaThisMonth - sorted.get(month).get(index - 1).getArea());
			System.out.println("Area difference from previous year was: " + difference + "million KM^2");
		}

	}
}
