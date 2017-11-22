package module6;

import java.util.Scanner;

/*
 * Extends DataPoint class to add labels
 */

public class LabelledDataPoint extends DataPoint {

  protected String label; // Label of DataPoint

  // Sets numbers to 0 & label to"" when no arguments
  public LabelledDataPoint() {
    super();
    this.label = "";
  }

  // Adds input for label
  public LabelledDataPoint(double x, double y, double ey, String label) {
    super(x, y, ey);
    this.label = label;
  }

  // Displays DataPoint as String
  @Override
  public String toString() {
    return label + ": " + super.toString();
  }
  
//Parses input string line (3 numbers and label) into LabelledDataPoint object containing x, y,
 // ey & label
 public static DataPoint parseLine(String line) {
   Scanner s = new Scanner(line);
   double x = 0.0;
   double y = 0.0;
   double ey = 0.0;
   String label = "";
   // Iterates while next token present
   while (s.hasNext()) {
     // Updates each value with next token
     x = s.nextDouble();
     y = s.nextDouble();
     ey = s.nextDouble();
     if(s.hasNext()) {
       label = s.next();
     }
   }
   s.close();
   if ( label != "") {
     return new LabelledDataPoint(x, y, ey, label);
   }
   // Creates DataPoint from stored values
   return new DataPoint(x, y, ey);
 }

}
