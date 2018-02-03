package exam1;

import java.util.Scanner;

/*
 * Represents a sea-ice data measurement
 */

public class Measurement {

	private int year; // Year of measurement
	private int month; // Numerical month of measurement
	private String dataType; // Data source used to compile the data
	private String region; // Region of measurement (N or S hemisphere)
	private double extent; // Ice extent: total area of land / sea covered by ice in millions of square
							// kilometres
	private double area; // Ice area: total area of actual ice in millions of square kilometres
	
	// Empty constructor sets numbers to 0, Strings to ""
	public Measurement() {
		this.year = 0;
		this.month = 0;
		this.dataType = "";
		this.region = "";
		this.extent = 0.0;
		this.area = 0.0;
	}
	
	// Constructor sets variables to argument values
		public Measurement(int year, int month, String dataType, String region, double extent, double area) {
			this.year = year;
			this.month = month;
			this.dataType = dataType;
			this.region = region;
			this.extent = extent;
			this.area = area;
		}

	// Displays a Measurement as a string
	@Override
	public String toString() {
		return "Measurement [year=" + year + ", month=" + month + ", dataType=" + dataType + ", region=" + region
				+ ", extent=" + extent + " million KM^2, area=" + area + " million KM^2]";
	}
	
	// Gets each variable
	public int getYear(){
		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public String getDataType(){
		return this.dataType;
	}
	
	public String getRegion(){
		return this.region;
	}
	
	public double getExtent(){
		return this.extent;
	}
	
	public double getArea() {
		return this.area;
	}
	
	// Parses input string (line) into Measurement object
	public static Measurement parseLine(String line) {
		Measurement m = new Measurement();
		Scanner s = new Scanner(line);
		s.useDelimiter(",\\s*");
		if ( s.hasNext() ) { // Checks if next token is present
			m.year = s.nextInt();
			m.month = s.nextInt();
			m.dataType = s.next();
			m.region = s.next();
			m.extent = s.nextDouble();
			m.area = s.nextDouble();
		}
		s.close();
		return m;
	}
}
