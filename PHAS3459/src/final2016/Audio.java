package final2016;

/**
 * Represents an audio recording of a musical instrument with methods to
 * calculate time etc.
 * 
 * @author James
 *
 */

public class Audio {

  private String filename; // name of file
  private String instrument; // instrument used for recording
  private int f; // sampling frequency in Hz
  private int N; // total number of samples in recording
  private int maxA; // maximum possible amplitude of signal

  // create blank Audio object (strings="", numbers=0)
  public Audio() {
    this.filename = "";
    this.instrument = "";
    this.f = 0;
    this.N = 0;
    this.maxA = 0;
  }

  // returns filename
  public String getFilename() {
    return this.filename;
  }

  // returns name of instrument
  public String getInstrument() {
    return this.instrument;
  }

  // returns sampling frequency in Hz
  public int getF() {
    return this.f;
  }

  // returns number of samples
  public int getN() {
    return this.N;
  }

  // returns maximum possible amplitude of file
  public int getMaxA() {
    return this.maxA;
  }

  // sets filename
  public void setFilename(String filename) {
    this.filename = filename;
  }

  // sets name of instrument
  public void setInstrument(String instrument) {
    this.instrument = instrument;
  }

  // sets sampling frequency in Hz
  public void setF(int f) {
    this.f = f;
  }

  // sets number of samples
  public void setN(int N) {
    this.N = N;
  }

  // sets maximum possible amplitude of file
  public void setMaxA(int maxA) {
    this.maxA = maxA;
  }

}
