package module3;

public class FallingParticle {
  //Represents a particle falling through fluid
  private double m; //Particle mass in kg
  private double d; //Fluid drag coefficient in kg/m
  private double t = 0; //Time since particle was dropped
  private double z; //Vertical position of particle from vessel base
  private double h; //Initial height of particle from vessel base
  private double v; //Particle Velocity measured upwards from vessel
  public static final double g = 9.80665; //Acceleration due to gravity in m/s/s
  
  public FallingParticle() {
    m = 1.0;
    d = 1.0;
    System.out.println("Defaulted to m = 1.0 kg, d = 1.0 kg/m");
  }
  
  public FallingParticle(double m, double d) throws Exception {
    if(0 >= m) {
      throw new Exception("Mass must be positive");
    }
    if(0 >= d) {
      throw new Exception("Drag Coefficient must be positive");
    }

    this.m = m;
    this.d = d;
  }
  
  public void setH(double h) throws Exception {
    if(0 > h) {
      throw new Exception("Initial height must be positive");
    }
    //Sets height in m
    this.h = h;
  }
  
  public void setV(double v) {
    //Sets velocity of particle in m/s
    this.v = v;
  }
  
  public double getZ() {
    //Returns current vertical position of particle from vessel base in m
    return this.z;
  }
  
  public double getV() {
    //Returns current velocity of particle in m/s
    return -this.v;
  }
  
  public double getT() {
    //Returns elapsed time in s
    return this.t;
  }
  
  public void doTimeStep(double deltaT) {
    //Finds current acceleration & updates position & velocity
    double a = (this.d*Math.pow(this.v, 2)/this.m) - g;
    v -= a*deltaT;
    z -= v*deltaT;
  }
  
  public void drop(double deltaT) {
    //Sets initial position same as initial height
    this.z = this.h;
    //Simulates descent of particle till it reaches bottom (z=0)
    while(z > 0) {
      //Updates current time
      t += deltaT;
      doTimeStep(deltaT);
    }
  }
  
  

}

