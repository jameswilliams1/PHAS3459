package module3;
import java.util.Random;
import java.lang.StringBuilder;
import java.lang.Character;
import java.lang.Integer;

public class Alphabet {
  
  public static char randomCharacter() {
    //Creates empty Random object
    Random r = new Random();
    //Generates random integer 0 - 127
    int integer =  r.nextInt(128);
    //Converts int to char
    char c = (char) integer;
    return c;
  }
  
  public static void main(String[] args) {
    
    StringBuilder characters = new StringBuilder(250);
    int total = 0;
    int exceptions = 0;
    
    for(int x = 0; x < 250; x += 1) {
      char character = randomCharacter();
      
      if(Character.isLetterOrDigit(character)) {
        characters.append(character);
        try {
         total += Integer.parseInt(Character.toString(character));
        }
        catch (Exception e) {
          exceptions += 1;
        }
      }
    }
    System.out.println("Contents of StringBuilder: " + characters);
    System.out.println("Number of Characters in StringBuilder: " + characters.length());
    System.out.println("Total sum of integers was  " + total);
    System.out.println("Number of exceptions was " + exceptions);
    
    
    
    
    
  }

}
