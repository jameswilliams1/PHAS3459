package crypto;

import java.util.Scanner;

public class Datapoint {
	private String symbol;
	private Double price;
	
	public Datapoint(){
	}
	
	
	public static Datapoint parseLine(String line){
		Datapoint dp = new Datapoint();
		Scanner s = new Scanner(line);
		if(s.hasNext()){
			dp.symbol = s.next();
			dp.price = s.nextDouble();
		}
		s.close();
		return dp;
	}

}