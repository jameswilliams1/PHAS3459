package pastpaper2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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
    // HashMap<String, Player> players = new HashMap<String, Player>();
    ArrayList<Player> players = new ArrayList<Player>();

    try {
      players = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
      // System.out.println(players.size());

    } catch (IOException e) {
      System.out.println(e + " Page does not exist");
    }
    Iterator<Player> it = players.iterator();

  }

}
