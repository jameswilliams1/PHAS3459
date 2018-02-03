package exam2;

import java.util.ArrayList;
import java.util.Collection;

public class SpecifyAirports implements FlightFilter {

	/**
	 * Returns list of flights that have the required inputs (origin/destination
	 * airports) from a list of flights
	 */
	@Override
	public Collection<Flight> filter(Collection<Flight> flights, Criterion c) {
		Collection<Flight> filteredFlights = new ArrayList<Flight>(); //creates new empty list
		for(Flight f: flights) { //iterates over each available flight
			if( f.getOrigin().equals(c.getOrigin()) && f.getDestination().equals(c.getDestination())) { //checks if flight matches criterion
				filteredFlights.add(f); //adds to new list if it matches
			}
		}
		
		return null;
	}

}
