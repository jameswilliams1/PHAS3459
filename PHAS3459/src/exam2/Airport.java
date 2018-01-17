package exam2;

import java.util.Scanner;

/**
 * Represents an airport
 * 
 * @author
 *
 */
public class Airport {

	private String code; // airport code
	private String name; // name of airport
	private String timeZone; // time zone of airport

	/**
	 * Creates new Airport object with specified parameters
	 * 
	 * @param code
	 * @param name
	 * @param timeZone
	 */
	public Airport(String code, String name, String timeZone) {
		this.code = code;
		this.name = name;
		this.timeZone = timeZone;
	}
	
	/**
	 * Returns name of the Airport
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns code of the Airport
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Returns time zone of the Airport
	 * @return timeZone
	 */
	public String getTimeZone() {
		return this.timeZone;
	}

	/**
	 * Displays Airport as a string
	 */
	@Override
	public String toString() {
		return "Airport [code=" + code + ", name=" + name + ", timeZone=" + timeZone + "]";
	}

	/**
	 * Parses line of data into parameters and returns Airport object
	 * 
	 * @param line
	 * @return Airport
	 */
	public static Airport parseLine(String line) {
		Scanner s = new Scanner(line); // instantiates Scanner object from line of text
		s.useDelimiter(",");
		String code = "";
		String name = "";
		String timeZone = "";
		if (s.hasNext()) {
			code = s.next();
			name = s.next();
			timeZone = s.next();
		}
		s.close();
		return new Airport(code, name, timeZone);
	}

}
