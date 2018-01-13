package final2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Contains method for reading URL data about sound recordings
 * 
 * @author James
 *
 */

public class ExamPart1 {

  // returns ArrayList of Audio objects from directory of data
  public static ArrayList<Audio> dataFromURL(String dir) throws IOException {
    ArrayList<Audio> sounds = new ArrayList<Audio>();
    URL u = new URL(dir + "index.txt");
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    while ((line = br.readLine()) != null) {
      // parses each line into names
      Audio a = Audio.parseNames(line);
      // adds each to list
      sounds.add(a);
    }
    
    for ( Audio sound:sounds) {
      ArrayList<Integer> data = Audio.parseData(dir + sound.getFilename());
      sound.setF(data.get(0));
      sound.setN(data.get(1));
      sound.setMaxA(data.get(2));

      for(int i = 0 ; i < 3; i++) {
        data.remove(0);
      }
      sound.setData(data);
    }
    return sounds;
  }
    
  public static void main(String[] args) {

    ArrayList<Audio> sounds = new ArrayList<Audio>();

    try {
      sounds = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/");
      
    } catch (IOException e) {
      System.out.println(e);
    }

    for(Audio sound:sounds) {
      System.out.println(sound);
    }

  }

}
