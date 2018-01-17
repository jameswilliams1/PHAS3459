package exam2;

import java.util.Collection;

/**
 * Represents an algorithm for filtering flights
 * @author 
 *
 */
public interface FlightFilter {
	
	Collection<Flight>  filter(Collection<Flight> flights, Criteria c);

}
