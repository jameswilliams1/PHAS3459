package pastpaper2016;

import java.util.Scanner;

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

  // Empty constructor sets all numbers to 0 and Strings to ""
  public Player() {
    this.playerName = "";
    this.team = "";
    this.position = "";
    this.games = 0;
    this.atBats = 0;
    this.runs = 0;
    this.hits = 0;
    this.doubles = 0;
    this.triples = 0;
    this.homeRuns = 0;
    this.runsBattedIn = 0;
    this.battingAverage = 0.0;
    this.onBase = 0.0;
  }

  // Constructor sets all variables same as input
  public Player(String playerName, String team, String position, int games, int atBats, int runs, int hits, int doubles,
      int triples, int homeRuns, int runsBattedIn, double battingAverage, double onBase) {
    this.playerName = playerName;
    this.team = team;
    this.position = position;
    this.games = games;
    this.atBats = atBats;
    this.runs = runs;
    this.hits = hits;
    this.doubles = doubles;
    this.triples = triples;
    this.homeRuns = homeRuns;
    this.runsBattedIn = runsBattedIn;
    this.battingAverage = battingAverage;
    this.onBase = onBase;
  }

  // Parses a tab-separated line of data about player into Player object
  public static Player parseLine(String line) {
    Player p = new Player();
    Scanner s = new Scanner(line).useDelimiter("\t");
    // Iterates while next token present
    while (s.hasNext()) {
      p.playerName = s.next();
      p.team = s.next();
      p.position = s.next();
      p.games = s.nextInt();
      p.atBats = s.nextInt();
      p.runs = s.nextInt();
      p.hits = s.nextInt();
      p.doubles = s.nextInt();
      p.triples = s.nextInt();
      p.homeRuns = s.nextInt();
      p.runsBattedIn = s.nextInt();
      p.battingAverage = s.nextDouble();
      p.onBase = s.nextDouble();
    }
    s.close();
    return p;
  }
}