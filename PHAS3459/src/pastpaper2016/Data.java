package pastpaper2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Data {

  // Returns ArrayList object from web page input
  public static ArrayList<Player> dataFromURL(String urlName) throws IOException {
    // Creates empty ArrayList
    ArrayList<Player> players = new ArrayList<Player>();
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    // Skips 2 rows
    for (int i = 0; i < 2; i++) {
      br.readLine();
    }
    // Iterates while next token present
    while ((line = br.readLine()) != null) {
      // Parses each line into Player object
      Player p = Player.parseLine(line);
      // Adds each Player to ArrayList
      players.add(p);
    }
    return players;
  }

  public static void main(String[] args) {

    ArrayList<Player> players = new ArrayList<Player>(); // List of players (unsorted)

    try {
      players = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
    } catch (IOException e) {
      System.out.println(e + " Page does not exist");
    }

    HashMap<String, ArrayList<Player>> teams = new HashMap<String, ArrayList<Player>>(); // HashMap of ArrayLists of
    // players sorted by team
    // Iterates over list of players & sorts into ArrayList objects by team
    for (Player player : players) {
      String currentTeam = player.getTeam(); // Gets team of current player
      ArrayList<Player> currentPlayers = teams.get(currentTeam);
      if (currentPlayers == null) {
        teams.put(currentTeam, new ArrayList<Player>()); // Creates team if empty
      }
      teams.get(currentTeam).add(player);
    }

    // Initialises max number of home runs and index of player who scored them
    int maxRuns = 0;
    int playerMaxRunsIndex = 0;
    // Iterates over players ArrayList to get key value associated with maxRuns
    for ( int i = 0; i < players.size(); i++ ) {
      if ( maxRuns < players.get(i).getHomeRuns() ) { // Updates maxRuns and playerMaxRunsIndex with highest value
        maxRuns = players.get(i).getHomeRuns();
        playerMaxRunsIndex = i;
      }
    }
    System.out.println("Total number of players: " + players.size());
    System.out.println();
    System.out.println("Most home runs scored in 2001 was: " + maxRuns);
    System.out.println("Player details:");
    System.out.println(players.get(playerMaxRunsIndex));
    HashMap<String, ArrayList<Player>> tenPlusAtBats = new HashMap<String, ArrayList<Player>>();
    
    for(String team: teams.keySet()) { // Iterates over each team in HashMap
      for(Player player: teams.get(team)) { // Iterates over each player in team
        ArrayList<Player> currentPlayers = tenPlusAtBats.get(team); // Creates new list of players
        if (currentPlayers == null) {
          tenPlusAtBats.put(team, new ArrayList<Player>()); // Creates team if not already present
        }
        if ( player.getAtBats() >= 10 ) { // Determines whether player has 10+ atBats
          tenPlusAtBats.get(team).add(player);
        }
      }
    }
    System.out.println();
   for ( String team: tenPlusAtBats.keySet() ) {// Iterates over each team in HashMap
     int total = tenPlusAtBats.get(team).size(); // Finds size of each teams value array (i.e. total atBats)
     System.out.println("Total at Bats for " + team + ": " + total);
     double slugPC = 0.0;
     for ( Player player: tenPlusAtBats.get(team)) { // Iterates over each player in team
       if ( Player.slugPC(player) > slugPC ) {
         slugPC = Player.slugPC(player);
       }
     }
     System.out.println("Highest SLG was: " + slugPC);
     System.out.println();
   }
  
  
  
  
  
  }
}
