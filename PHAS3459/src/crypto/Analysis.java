package crypto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Analysis {

	public static ArrayList<Datapoint> dataFromCSV(String filename)
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


	public static void main(String[] args) {

		ArrayList<Datapoint> data = new ArrayList<Datapoint>();
		try {
			data = dataFromCSV("/Users/Akhil/Downloads/Final_Sorted_Crypto.txt");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
