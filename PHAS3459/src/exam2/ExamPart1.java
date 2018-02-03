package exam2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Uses Airport, Flight and Analysis classes to calculate information about
 * flights
 * 
 * @author
 *
 */
public class ExamPart1 {

	public static void main(String[] args) {
		ArrayList<Airport> airports = new ArrayList<Airport>();
		ArrayList<Flight> flights = new ArrayList<Flight>();
		try {
			airports = Analysis
					.airportsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
			flights = Analysis.flightsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt");

		} catch (IOException e) {
			System.out.println(e);
		}

		for (Flight flight : flights) {
			System.out.println("Flight code: " + flight.getFlightCode());
			System.out.println("Origin airport: " + Analysis.aiportName(airports, flight.getOrigin()));
			System.out.println("Destination airport: " + Analysis.aiportName(airports, flight.getDestination()));
			System.out.println("Date/time of departure: " + flight.getdepartureDate() + " " + flight.getdepartureTime());
			System.out.println("Date/time of arrival: " +  flight.getArrivalDate() + " " + flight.getArrivalTime());
			System.out.println("Flight time: ");
			System.out.println("Cost of flight: £" + flight.getCost());
			System.out.println();
		}

	}

}
