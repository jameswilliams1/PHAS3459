package final2012;

import java.util.Scanner;

public class Data {
  
  /**
   * Parses a String line containing bin bounds and count into a Bin object
   * 
   * @param line
   * @return
   */
  public static Bin parseLine(String line) {
    Scanner s = new Scanner(line);
    double minE = 0.0;
    double maxE = 0.0;
    double count = 0.0;
    if (s.hasNext()) {
      minE = s.nextDouble();
      maxE = s.nextDouble();
      count = s.nextDouble();
    }
    s.close();
    return new Bin(minE, maxE, count);
  }

  public static void main(String[] args) {
    
  }

}
