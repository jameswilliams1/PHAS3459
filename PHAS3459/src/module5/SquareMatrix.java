package module5;

import java.lang.reflect.Array;

public class SquareMatrix {
  /*
   * Represents a square matrix using a 2-D array
   */
  
  private double[][] elements;
  private int length;
  
  // Creates empty matrix
  public SquareMatrix() {
  }
  
  // Creates SquareMatrix from an array
  public SquareMatrix(double[][] elements) throws Exception {
    if(elements.length != Array.getLength(elements[0])) {
      throw new Exception("Rows and columns must have same length");
    }
    else {
      this.elements = elements;
      this.length = elements.length;
    }
  }
  
  // Returns string representation of matrix
  public String toString() {
    String output =  "";
    for(int i = 0; i < this.length; i++) {
      output += " | ";
      for(int j = 0; j < this.length; j++) {
        output += elements[i][j] + " | ";
      }
      output += "\n"; 
      }
    return output;
    }
  }
  
  
  
  
  
  
  
  
  
  
  



