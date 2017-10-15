package module2;

public class TestThreeVector {
  


  public static void main(String[] args) {
  
  ThreeVector v1 = new ThreeVector(3, 5, 2);
  ThreeVector v2 = new ThreeVector(2, 4, 1);
  ThreeVector v3 = new ThreeVector(0, 0, 0);
  double u12 = v1.unitVector().x;
  double v12 = v1.unitVector().y;
  double w12 = v1.unitVector().z;
  System.out.println(u12);
  System.out.println(v12);
  System.out.println(w12);
  
  
  
  }

}
