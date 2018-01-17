package exam2;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Uses Airport, Flight  and Analysis classes to calculate information about flights
 * 
 * @author
 *
 */
public class ExamPart1 {

	public static void main(String[] args) {
		ArrayList<Airport> airports = new ArrayList<Airport>();
		 try {
		      airports = Analysis.airportsfromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
		      
		    } catch (IOException e) {
		      System.out.println(e);
		    }

		 for (Airport airport:airports) {
			 System.out.println(airport);
		 }
		

	}

}
