package exam2;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private LocalDate departureDate; // departure date
	private LocalTime departureTime; //departure time (local time at origin)
	private LocalDate arrivalDate; // arrival date
	private LocalTime arrivalTime; //arrival time (local time at destination)
	private double cost; // cost of flight in pounds

}
