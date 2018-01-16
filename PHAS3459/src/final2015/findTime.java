package final2015;

import java.util.HashMap;

/**
 * Represents algorithm for finding time taken by a given particle with max amplitude maxAmp to reach a detector (HashMap contains {time, amplitude} for each reading)
 * @author James
 *
 */
public interface findTime {
  
  int findT(HashMap<Integer, Double> pulse, Double maxAmp);

}
