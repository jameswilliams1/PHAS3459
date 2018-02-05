package crypto;

import java.util.ArrayList;

public class Coin {
	
	private String symbol;
	private ArrayList<Double> pricelist;
	
	public Coin(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public ArrayList<Double> getPricelist() {
		return pricelist;
	}



	public void setPricelist(ArrayList<Double> pricelist) {
		this.pricelist = pricelist;
	}

	@Override
	public String toString() {
		return "Coin [symbol=" + symbol + ", pricelist=" + pricelist + "]";
	}
	
	


	
}
