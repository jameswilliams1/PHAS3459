package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {
  /*
   * Defines functions for reading and processing numerical files on the web
   */

  private double minValue = 999999999999999.0; // Sets min & max to extreme values
  private double maxValue = -999999999999999.0;
  private int nValues = 0;
  private double sumOfValues = 0.0;
  public String fileLoc = "";

  public static String getStringFromKeyboard() throws IOException {
    // Prompts user to enter a save directory & returns keyboard input through
    // BufferedReader
    System.out.println("Enter save directory:");
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    String s = br.readLine();
    // Uses user home directory if no input
    if (s.length() != 0) {
      return s;
    } else {
      System.out.println("User home directory has been selected.");
      System.out.println();
      return System.getProperty("user.home");
    }
  }

  public BufferedReader brFromURL(String urlName) throws IOException {
    // Returns BufferedReader object from web page input using java.net.URL
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    return new BufferedReader(isr);
  }

  public void analysisStart(String dataFile) throws IOException {
    // Creates new file in specified path
    File outputfile = new File(dataFile);
    FileWriter fw = new FileWriter(outputfile);
    fw.close();
  }

  public void analyseData(String line) throws IOException {
    Scanner s = new Scanner(line);
    BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileLoc, true));

    while (s.hasNext()) { // Checks for remaining tokens

      if (s.hasNextDouble()) {
        Double number = s.nextDouble();
        System.out.println(number);
        String numberAsString = Double.toString(number);
        bw.write(numberAsString); // Writes string representation of double to file
        bw.newLine();
        this.nValues++; // Updates variables
        this.sumOfValues += number;

        if (this.minValue > number) { // Updates min/max if a token is less/more than current value
          this.minValue = number;
        } else if (this.maxValue < number) {
          this.maxValue = number;
        }
      }

      else if (s.hasNextInt()) { // Works same as for doubles
        int number = s.nextInt();
        System.out.println(number);
        bw.write(number);
        bw.newLine();
        this.nValues++;
        this.sumOfValues += number;

        if (this.minValue > number) {
          this.minValue = number;
        } else if (this.maxValue < number) {
          this.maxValue = number;
        }
      } else { // Goes to new line for non-numbers
        s.nextLine();
      }

    }
    s.close();
    bw.close();
  }

  public void analysisEnd() {
    System.out.println("The minimum value was: " + this.minValue);
    System.out.println("The maximum value was: " + this.maxValue);
    System.out.println("The average value was: " + (this.sumOfValues / this.nValues));
    System.out.println("The total was: " + this.sumOfValues);
  }

  public static void main(String[] args) {

    NumericalReader nr1 = new NumericalReader(); // Creates objects holding variables
    NumericalReader nr2 = new NumericalReader();
    String line = "";
    String saveDir = "";

    try {
      saveDir = NumericalReader.getStringFromKeyboard();
    } catch (java.io.IOException e) {
      System.out.println(e);
    }
    try {
      nr1.fileLoc = (saveDir + File.separator + "numbers1.txt");
      System.out.println("Saving to " + nr1.fileLoc);
      nr1.analysisStart(nr1.fileLoc);

      // Creates BufferedReader object from a web page
      BufferedReader webBuffer1 = nr1
          .brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
      // Prints each number until readLine returns a null (empty) line
      while ((line = webBuffer1.readLine()) != null) {
        nr1.analyseData(line);
      }
    } catch (java.io.IOException e) {
      System.out.println(e);
    }
    nr1.analysisEnd(); // Print min, max, avarage, total
    System.out.println();

    try {
      nr2.fileLoc = (saveDir + File.separator + "numbers2.txt");
      System.out.println("Saving to " + nr2.fileLoc);
      nr2.analysisStart(nr2.fileLoc);

      // Creates BufferedReader object from a web page
      BufferedReader webBuffer2 = nr2
          .brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
      // Prints each number until readLine returns a null (empty) line
      while ((line = webBuffer2.readLine()) != null) {
        nr2.analyseData(line);
      }
    } catch (java.io.IOException e) {
      System.out.println(e);
    }
    nr2.analysisEnd(); // Print min, max, avarage, total

  }
}
