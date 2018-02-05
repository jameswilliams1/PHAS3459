package crypto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		br.close();
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
	
	public static void getXPrices(ArrayList<Coin> coinlist) throws IOException {
		System.out.println("Input x:");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		in.close();
		File outputfile = new File(System.getProperty("user.home")+"/crypto_output_price_" + x + ".txt");
	    FileWriter fw = new FileWriter(outputfile);
		for( Coin c: coinlist) {
			//System.out.print(c.getSymbol() + " ");
			fw.write(c.getSymbol() + "\t");
			
			if ( x <= (c.getPricelist().size()) ) {
				for( int i = 0; i < x; i++) {
					//System.out.print(c.getPricelist().get(i) + " ");
					fw.write(c.getPricelist().get(i) + "\t");
				}
			}
			else {
				for ( int j = 0; j < c.getPricelist().size(); j++) {
					//System.out.print(c.getPricelist().get(j) + " ");
					fw.write(c.getPricelist().get(j) + "\t");
				}
			}
			//System.out.println("");
			fw.write(System.lineSeparator());
		}
		fw.close();
		System.out.println("Saved output to " + System.getProperty("user.home")+"/crypto_output_price" + x + ".txt");
	}
	
	public static void getXReturns(ArrayList<Coin> coinlist) throws IOException {
		System.out.println("Input x:");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		in.close();
		File outputfile = new File(System.getProperty("user.home")+"/crypto_output_return_" + x + ".txt");
	    FileWriter fw = new FileWriter(outputfile);
		for( Coin c: coinlist) {
			//System.out.print(c.getSymbol() + " ");
			fw.write(c.getSymbol() + "\t");
			
			if ( x <= (c.getPricelist().size()) ) {
				for( int i = 0; i < x; i++) {
					//System.out.print(c.getPricelist().get(i) + " ");
					fw.write( ((c.getPricelist().get(i) - c.getPricelist().get(0))/c.getPricelist().get(0)) + "\t");
				}
			}
			else {
				for ( int j = 0; j < c.getPricelist().size(); j++) {
					//System.out.print(c.getPricelist().get(j) + " ");
					fw.write( ((c.getPricelist().get(j) - c.getPricelist().get(0))/c.getPricelist().get(0)) + "\t");
				}
			}
			//System.out.println("");
			fw.write(System.lineSeparator());
		}
		fw.close();
		System.out.println("Saved output to " + System.getProperty("user.home")+"/crypto_output_return_" + x + ".txt");
	}

	

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Datapoint> data = new ArrayList<Datapoint>();
		
		try {
			data = dataFromFile(System.getProperty("user.home") + "/output.txt");
			names = getNames(System.getProperty("user.home") + "/names.txt");
			ArrayList<Coin> coinlist = makeCoinList(data, names);
			getXReturns(coinlist);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		

		
		
		
		

	}

}
