package module2;

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
    m = 0.0;
    d = 0.0;
  }
  
  public FallingParticle(double m, double d) {
    this.m = m;
    this.d = d;
  }
  
  public void setH(double h) {
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
    return this.v;
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
    this.z = this.h;
    //Simulates descent of particle till it reaches bottom (z=0)
    while(z > 0) {
      t += deltaT;
      doTimeStep(deltaT);
    }
  }
  
  

}

