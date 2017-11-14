package pastpaper2016;

/*
 * Represents an MBL player and includes method to parse a line of data into Player object
 */

public class Player {

  private String playerName; // Player name in form [LastName, FirstInitial]
  private String team; // Player's team
  private String position; // Players position
  private int games; // Number of games played
  private int atBats; // Total times over all games player came up to bat
  private int runs; // Total runs scored
  private int hits; // Number of times player hit the ball and reached 1st base
  private int doubles; // Number of times player reached 2nd base from a hit
  private int triples; // Number of times player reached 3rd base from a hit
  private int homeRuns; // Number of home runs
  private int runsBattedIn; // Number of runs scored due to batters' action
  private double battingAverage; // (hits / atBats)
  private double onBase; // On-Base percentage: fraction of times player reached base (either from a hit,
                         // walk or hit-by-pitch)

}