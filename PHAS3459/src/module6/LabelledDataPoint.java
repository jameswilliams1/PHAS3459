package module6;

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

}
