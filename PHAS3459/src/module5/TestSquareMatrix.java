package module5;

public class TestSquareMatrix {

  public static void main(String[] args) {
    
    // Defines all matrices used
    SquareMatrix A = new SquareMatrix();
    double[][] Avals = { {1, 2, 0}, {0, 2, 0}, {-2, 0, 1} };
    try {
      A = new SquareMatrix(Avals);
    }
    catch (Exception E) {
      System.out.println(E);
    }
    SquareMatrix B = new SquareMatrix();
    double[][] Bvals = { {2, 1, 0}, {0, 1, 0}, {-1, 0, 1} };
    try {
      B = new SquareMatrix(Bvals);
    }
    catch (Exception E) {
      System.out.println(E);
    }
    SquareMatrix C = new SquareMatrix();
    double[][] Cvals = { {4, 3}, {3, 2} };
    try {
      C = new SquareMatrix(Cvals);
    }
    catch (Exception E) {
      System.out.println(E);
    }
    SquareMatrix D = new SquareMatrix();
    double[][] Dvals = { {-2, 3}, {3, -4} };
    try {
      D = new SquareMatrix(Dvals);
    }
    catch (Exception E) {
      System.out.println(E);
    }
    try {
      System.out.println("A+B:");
      System.out.println(A.add(B));
      System.out.println("A-B:");
      System.out.println(A.subtract(B));
    }
    catch (Exception E) {
      System.out.println(E);
    }
    try {
      SquareMatrix AB = A.multiply(B);
      SquareMatrix BA = B.multiply(A);
      System.out.println("AB:");
      System.out.println(AB);
      System.out.println("BA:");
      System.out.println(BA);
      System.out.println("[A,B]:");
      System.out.println(AB.subtract(BA));
    }
    catch (Exception E) {
      System.out.println(E);
    }
    try {
      SquareMatrix CD = C.multiply(D);
      System.out.println("CD:");
      System.out.println(CD);
      System.out.println("Is CD==I:");
      System.out.println(CD.equals(SquareMatrix.unitMatrix(2)));
    }
    catch (Exception E) {
      System.out.println(E);
    }
    



  }

}
