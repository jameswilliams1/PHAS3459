package module1;

/**
 * Stores and prints different variables
 */
public class DataTypes {

  public static void main(String[] args) {

    //defines number 10 as 5 different data types
    double doubVar=10.0;
    System.out.println("doubVar = "+doubVar);
    float floatVar=10;
    System.out.println("floatVar = "+floatVar);
    int intVar=10;
    System.out.println("intVar = "+intVar);
    long longVar=10;
    System.out.println("longVar = "+longVar);
    byte byteVar=10;
    System.out.println("byteVar = "+byteVar);
    //new line on console
    System.out.println();

    //squares each value and prints
    System.out.println("doubVar^2 = "+(doubVar*doubVar));
    System.out.println("floatVar^2 = "+(floatVar*floatVar));
    System.out.println("intVar^2 = "+(intVar*intVar));
    System.out.println("longVar^2 = "+(longVar*longVar));
    System.out.println("byteVar^2 = "+(byteVar*byteVar));
    System.out.println();

    //saves variables using mixed data types
    int integer='z';
    System.out.println("Storing a letter as an int gives its numerical value:");
    System.out.println("Letter z = "+integer);
    System.out.println();
    char letter = 'd'+20;
    System.out.println("Adding a number to a char variable increases its value:");
    System.out.println("d+20="+letter);
    System.out.println();
    double decimal = '3';
    System.out.println("Storing a number as a string gives its numerical vlaue");
    System.out.println("'3' = "+decimal);
    System.out.println();

    //can not run:
    //int j=1; 
    //int i; 
    //j=i+1;
    System.out.println("Using an uninitialised varible gives an error");
    System.out.println();

    //inputs float and converts to integer
    double anotherdecimal=4.99;
    System.out.println("Casting  a double to an int drops everything after the decimal point:");
    System.out.println("4.99 as an integer is "+(int) anotherdecimal);
  }
}
