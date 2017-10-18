package module2;

public class TestThreeVector {
  
  public static void main(String[] args) {
  //Creates 3 new ThreeVector objects
  ThreeVector v1 = new ThreeVector(3, 5, 2);
  ThreeVector v2 = new ThreeVector(2, 4, 1);
  ThreeVector v3 = new ThreeVector(0, 0, 0);
  System.out.println("v1 = "+v1);
  System.out.println("v2 = "+v2);
  System.out.println("v3 = "+v3);
  
  System.out.println(ThreeVector.angle(v1, v2));
  System.out.println(v1.angleN(v2));

  
  
  
  
  
  
  
  
  
  
  
  
  
  }

}
