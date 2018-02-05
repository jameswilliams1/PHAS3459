package crypto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Analysis {

	public static ArrayList<Datapoint> dataFromFile(String filename)
			throws IOException {
		ArrayList<Datapoint> data = new ArrayList<Datapoint>();
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			Datapoint d = Datapoint.parseLine(line);
			data.add(d);
		}
		br.close();
		return data;
	}
	
	public static ArrayList<String> getNames(String filename) throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ( (line = br.readLine()) != null) {
			String name = Datapoint.parseNames(line);
			names.add(name);
		}
		return names;
	}
	
	public static ArrayList<Coin> makeCoinList(ArrayList<Datapoint> data, ArrayList<String> names){
		ArrayList<Coin> coins = new ArrayList<Coin>();
		for ( String name: names) {
			Coin coin = new Coin(name);
			ArrayList<Double> prices = new ArrayList<Double>();
			for ( Datapoint d: data) {
				if (coin.getSymbol().equals(d.getSymbol())) {
					prices.add(d.getPrice());
				}
			}
			coin.setPricelist(prices);
			coins.add(coin);
		}
		return coins;
	}

	

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Datapoint> data = new ArrayList<Datapoint>();
		try {
			data = dataFromFile("C:\\Users\\James\\Downloads\\output.txt");
			names = getNames("C:\\Users\\James\\Downloads\\names.txt");
		} catch (IOException e) {
			System.out.println(e);
		}
		ArrayList<Coin> coinlist = makeCoinList(data, names);
		System.out.println(coinlist.get(1));
		
		
		

	}

}
