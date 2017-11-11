package module5;

public class TestSquareMatrix {

  public static void main(String[] args) {
    
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
    
    System.out.println(A);
    System.out.println(B);
    System.out.println(C);
    System.out.println(D);


  }

}
