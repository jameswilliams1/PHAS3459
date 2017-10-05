package module1;

/**
 * Defines looping functions
 */
public class AlgorithmControl {

  public static void main(String[] args) {

    AlgorithmControl ac = new AlgorithmControl();

    //calls functions defined below
    ac.loop();
    ac.decrement();
    ac.increment();

    //stores iteration counts
    int n1 = ac.timer(8000,1000);
    int n2 = ac.timer(8000,40000);
    //
    System.out.println(" Number of iterations (printing every 1000) was: "+n1);
    System.out.println(" Number of iterations (printing every 40000) was: "+n2);
    System.out.println(" Setting the step to 40000 instead of 1000 increases the number of iterations by "+(n2-n1));
    System.out.println(" Printing to the screen uses processing power and slows down the iterations so less are performed");
  }


  //prints integers 1 to 10
  void loop() {
    int i = 1;
    int max = 10;
    for ( i = 1 ; i <= max ; i++) {
      System.out.println(" i = "+i);
    }
  }

  //prints integers 5 to -12
  void decrement() {
    boolean i = true;
    int x = 5;
    while ( i ) {
      System.out.println(" x = "+x);
      x--;
      i = (x>=-12);
    }
  }

  //prints from 2.4 to 8.8 in steps of 0.2
  void increment() {
    int y = 24;
    int max = 88;
    //using integer counter avoids floating point artifacts
    for ( y = 24 ; y <= max ; y += 2 ) {
      double z=(y/10.0);
      System.out.println(" y = "+z);
    }
  }

  //
  int timer(long time, int steps) {
    //stores start time as local variable
    long t0 = System.currentTimeMillis();
    boolean x = true;
    int n = 1;
    while( x ) {
      //finds difference from initial time
      long difference = System.currentTimeMillis()-t0;
      n++;
      x = (difference <= time);
      //prints cycle count according to step argument
      if ( n%steps == 0 && n!=0) {
        System.out.println(n);
      }

    }
    return n;
  }


}
