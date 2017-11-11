package module5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {
  /*
   * Represents a square matrix using a 2-D array
   */

  private double[][] elements; // Array of elements
  private int size; // Size of matrix
  
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
  
  // Sets specified matrix value
  public void set(int row, int col, double value) { 
    elements[row][col] = value; 
    }
  
  // Gets specified matrix value
  public double get(int row, int col) { 
    return elements[row][col]; 
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
        values[i][i] = 1;
      }
      }
    return new SquareMatrix(values);
  }
  
// Returns true if current matrix has same hash code as argument
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.deepHashCode(elements);
    result = prime * result + size;
    return result;
  }

  // Returns true if current matrix equal to argument
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SquareMatrix other = (SquareMatrix) obj;
    if (!Arrays.deepEquals(elements, other.elements))
      return false;
    if (size != other.size)
      return false;
    return true;
  }
  
  // Adds 2 SquareMatrix objects (sm1+sm2)
  public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
    if(sm1.size != sm2.size) {
      throw new Exception("Matrices must be of equal size");
    }
    double[][] result = new double[sm1.elements.length][sm1.elements.length]; // Stores result in array
    
    // Adds each corresponding element
    for (int i = 0; i < sm1.size; i++) {
      for (int j = 0; j < sm1.size; j++) {
      result[i][j] = sm1.elements[i][j] + sm2.elements[i][j];
      }
    }
    return new SquareMatrix(result); // Returns new SquareMatrix from result
  }
  
  // Subtracts 2 SquareMatrix objects (sm1-sm2)
  public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
    if(sm1.size != sm2.size) {
      throw new Exception("Matrices must be of equal size");
    }
    double[][] result = new double[sm1.elements.length][sm1.elements.length]; // Stores result in array
    
    // Adds each corresponding element
    for (int i = 0; i < sm1.size; i++) {
      for (int j = 0; j < sm1.size; j++) {
      result[i][j] = sm1.elements[i][j] - sm2.elements[i][j];
      }
    }
    return new SquareMatrix(result); // Returns new SquareMatrix from result
  }
  
  // Multiples 2 matrices (sm1*sm2)
  public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
    if (sm1.size != sm2.size) {
      throw new Exception("Matrices must be of equal size");
    }
    double[][] result = new double[sm1.elements.length][sm1.elements.length]; // Stores result in array

    for (int i = 0; i < sm1.elements.length; i++) {
      for (int j = 0; j < sm1.elements.length; j++) {
        for (int k = 0; k < sm1.elements.length; k++) {
          result[i][j] += (sm1.elements[i][k] * sm2.elements[k][j]);
        }   
      }  
    }
    return new SquareMatrix(result);     
}
  
  // Non-static version of add
  public SquareMatrix add(SquareMatrix other) throws Exception {
    if(this.size != other.size) {
      throw new Exception("Matrices must be of equal size");
    }
    return add(this, other);
  }
  
//Non-static version of subtract
 public SquareMatrix subtract(SquareMatrix other) throws Exception {
   if(this.size != other.size) {
     throw new Exception("Matrices must be of equal size");
   }
   return subtract(this, other);
 }
 
//Non-static version of multiply
public SquareMatrix multiply(SquareMatrix other) throws Exception {
  if(this.size != other.size) {
    throw new Exception("Matrices must be of equal size");
  }
  return multiply(this, other);
}
  }