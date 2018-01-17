package exam2;

import java.util.ArrayList;
import java.util.Collection;

public class SpecifyAirports implements FlightFilter {

	/**
	 * Returns list of flights that have the required inputs (origin/destination
	 * airports) from a list of flights
	 */
	@Override
	public Collection<Flight> filter(Collection<Flight> flights, Criteria c) {
		Collection<Flight> filteredFlights = new ArrayList<Flight>();
		for(Flight f: flights) {
			if( f.getOrigin().equals())
		}
		
		return null;
	}

}
