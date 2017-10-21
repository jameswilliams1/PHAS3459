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
  
  System.out.println("Unit vector of v1 = "+v1.unitVector());
  System.out.println("Unit vector of v2 = "+v2.unitVector());
  System.out.println("Unit vector of v3 = "+v3.unitVector());

  System.out.println("v1.v2 (static) = "+ ThreeVector.scalarProduct(v1, v2));
  System.out.println("v1.v3 (static) = "+ ThreeVector.scalarProduct(v1, v3));
  System.out.println("v1.v2 (non-static) = "+ v1.scalarProduct(v2));
  System.out.println("v1.v3 (non-static) = "+ v1.scalarProduct(v3));
  
  System.out.println("v1*v2 (static) = "+ ThreeVector.vectorProduct(v1, v2));
  System.out.println("v1*v3 (static) = "+ ThreeVector.vectorProduct(v1, v3));
  System.out.println("v1*v2 (non-static) = "+ v1.vectorProduct(v2));
  System.out.println("v1*v3 (non-static) = "+ v1.vectorProduct(v3));
  
  System.out.println("Angle between v1 and v2 (static) = "+ ThreeVector.angle(v1, v2) + " radians");
  System.out.println("Angle between v1 and v3 (static) = "+ ThreeVector.angle(v1, v3) + " radians");
  System.out.println("Angle between v1 and v2 (non-static) = "+ v1.angle(v2) + " radians");
  System.out.println("Angle between v1 and v3 (non-static) = "+ v1.angle(v3) + " radians");
  
  System.out.println("Printing an object without a toString function displays the object type and its hashcode in hexadecimal.");
  }

}
