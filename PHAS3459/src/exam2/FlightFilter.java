package exam2;

import java.util.Collection;

/**
 * Represents an algorithm for filtering flights (comparing to criterion)
 * @author 
 *
 */
public interface FlightFilter {
	
	Collection<Flight>  filter(Collection<Flight> flights, Criterion c);

}
