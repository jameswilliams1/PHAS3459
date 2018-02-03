package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Contains static methods for storing and analysing Airport and Flight objects
 * 
 * @author
 *
 */
public class Analysis {

	/**
	 * Returns list of airports from web page input
	 * 
	 * @param url
	 * @return aiports
	 * @throws IOException
	 */
	public static ArrayList<Airport> airportsFromURL(String url) throws IOException {
		ArrayList<Airport> airports = new ArrayList<Airport>(); // empty Airport list
		URL u = new URL(url);
		InputStream is = u.openStream();
		// ensures special characters are read properly (in UTF-8):
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr); // opens BufferedReader on input stream of linea from page
		String line = "";
		while ((line = br.readLine()) != null) { // iterates over each line
			Airport a = Airport.parseLine(line); // creates Airport from input data
			airports.add(a); // adds each Airport to list
		}
		return airports;
	}

	/**
	 * Returns list of flights from web page input
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Flight> flightsFromURL(String url) throws IOException {
		ArrayList<Flight> flights = new ArrayList<Flight>(); // empty Airport list
		URL u = new URL(url);
		InputStream is = u.openStream();
		// ensures special characters are read properly (in UTF-8):
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr); // opens BufferedReader on input stream of linea from page
		String line = "";
		while ((line = br.readLine()) != null) {// iterates over each line
			Flight f = Flight.parseLine(line);
			flights.add(f);
		}
		return flights;
	}

	/**
	 * Returns name of an airport from input list of airports and code to be checked
	 * 
	 * @param airports
	 * @param code
	 * @return name
	 */
	public static String aiportName(ArrayList<Airport> airports, String code) {
		String name = "";
		for (Airport a : airports) {
			if (a.getCode().equals(code)) {
				name = a.getName();
			}
		}
		return name;
	}

}
