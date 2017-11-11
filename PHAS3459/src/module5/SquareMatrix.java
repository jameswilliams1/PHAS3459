package module5;

import java.lang.reflect.Array;

public class SquareMatrix {
  /*
   * Represents a square matrix using a 2-D array
   */
  
  private double[][] elements;
  private int size;
  
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
      this.size = elements.length;
    }
  }
  
  // Returns string representation of matrix
  public String toString() {
    String output =  "";
    for(int i = 0; i < this.size; i++) {
      output += " | ";
      for(int j = 0; j < this.size; j++) {
        output += elements[i][j] + " | ";
      }
      output += "\n"; 
      }
    return output;
    }
  
  // Returns a size*size unit matrix
  public static SquareMatrix unitMatrix(int size) throws Exception {
    if(size != (int) size ) {
      throw new Exception("Size must be an integer");
    }
    double[][] values = new double[size][size];
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        values[i][j] = 1;
      }
      }
    return new SquareMatrix(values);
  }
  
  
  
  
  
  
  
  }
  
  
  
  
  
  
  
  
  
  
  



