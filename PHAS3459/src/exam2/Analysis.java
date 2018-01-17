package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Contains static methods for storing and analysing Airport and Flight objects
 * 
 * @author 
 *
 */
public class Analysis {
	
	public static ArrayList<Airport> airportsfromURL(String url) throws IOException {
		 ArrayList<Airport> airports = new ArrayList<Airport>();
		    URL u = new URL(url);
		    InputStream is = u.openStream();
		    InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);
		    String line = "";
		    while ((line = br.readLine()) != null) {
		    	Airport a = Airport.parseLine(line);
		    	airports.add(a);
		    }
		    return airports;
	}

}
