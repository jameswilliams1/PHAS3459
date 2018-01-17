package exam2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Represents a flight between 2 airports
 * 
 * @author
 *
 */
public class Flight {

	private String flightCode; // flight code
	private String origin; // origin airport code
	private String destination; // destination airport code
	private String departureDate; // departure date
	private String departureTime; // departure time (local time at origin)
	private String arrivalDate; // arrival date
	private String arrivalTime; // arrival time (local time at destination)
	private double cost; // cost of flight in pounds

	/**
	 * Returns flight code for flight
	 * @return flight code
	 */
	public String getFlightCode() {
		return this.flightCode;
	}
	
	/**
	 * Returns origin airport code for flight
	 * @return origin airport
	 */
	public String getOrigin() {
		return this.origin;
	}
	
	/**
	 * Returns detination airport code for flight
	 * @return destination
	 */
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * Returns departure date for flight
	 * @return departure date
	 */
	public String getdepartureDate() {
		return this.departureDate;
	}
	
	/**
	 * Returns departure time for flight
	 * @return departure time
	 */
	public String getdepartureTime() {
		return this.departureTime;
	}
	
	/**
	 * Returns arrival date for flight
	 * @return arrival date
	 */
	public String getArrivalDate() {
		return this.arrivalDate;
	}
	
	/**
	 * Returns arrival time for flight
	 * @return arrival time
	 */
	public double getCost() {
		return this.cost;
	}
	
	/**
	 * Returns cost of flight
	 * @return cost
	 */
	public String getArrivalTime() {
		return this.arrivalTime;
	}
	
	
	/**
	 * Empty constructor
	 */
	public Flight() {

	}

	/**
	 * Creates new Flight object with specified parameters
	 * 
	 * @param flightCode
	 * @param origin
	 * @param destination
	 * @param departureDate
	 * @param departureTime
	 * @param arrivalDate
	 * @param arrivalTime
	 * @param cost
	 */
	public Flight(String flightCode, String origin, String destination, String departureDate, String departureTime,
			String arrivalDate, String arrivalTime, double cost) {
		this.flightCode = flightCode;
		this.origin = origin;
		this.destination = departureDate;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Parses line of data into parameters and returns Flight object
	 * 
	 * @param line
	 * @return Flight
	 */
	public static Flight parseLine(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(", ");
		Flight f = new Flight();

		if (s.hasNext()) {
			f.flightCode = s.next();
			f.origin = s.next();
			f.destination = s.next();
			f.departureDate = s.next();
			f.departureTime = s.next();
			f.arrivalDate = s.next();
			f.arrivalTime = s.next();
			f.cost = s.nextDouble();
		}

		s.close();
		return f;

	}

	/**
	 * Displays Flight as a string
	 */
	@Override
	public String toString() {
		return "Flight [flightCode=" + flightCode + ", origin=" + origin + ", destination=" + destination
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", arrivalDate="
				+ arrivalDate + ", arrivalTime=" + arrivalTime + ", cost=" + cost + "]";
	}

	/**
	 * Returns flight time of a Flight object
	 * @return flightTime
	 */
	public long flightTime() {
		
		LocalDateTime lt1 = LocalDateTime.parse("2018-01-02T09:05");
		ZoneId z1 = ZoneId.of("Europe/London");
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);

		LocalDateTime lt2 = LocalDateTime.parse("2018-01-02T11:20");
		ZoneId z2 = ZoneId.of("Europe/Paris");
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);

		long duration = zt1.until(zt2, ChronoUnit.MINUTES);
		
		return duration;
	}

}
