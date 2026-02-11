import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create scene objects
    LastYear lastYear = new LastYear();
    ThisYear thisYear = new ThisYear();

    // Call top level methods
    lastYear.drawScene();
    thisYear.drawScene();

    // Play scenes (in order of arguments)
    Theater.playScenes(lastYear, thisYear);
    
  }
}