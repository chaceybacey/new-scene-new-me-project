import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  // Variables (instance & static)
  private String[] newYearPictures;
  private String[] newCaptions = {
    "Yosemite",
    "Universal Studios",
    "Catalina Island",
    "Rome, Italy",
    "Beaches in Thailand",
  };
  private static final String blackBoarder = "blackSquare.png";
  
  // Constuctor

  // This is the unparamaterized constructor
  public ThisYear() {
    newYearPictures = FileReader.toStringArray("2026pictures.txt");
  }

  // This is the parameterized constructor 
  public ThisYear(String[] newYearPictures) {
    this.newYearPictures = newYearPictures; 
  }

  // sets the title screen style
  public void setThisYearTitleScreenStyle() {
    setTextHeight(37);
    setTextColor("pink");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
  }

   // sets the caption style
  public void setCaptionStyle() {
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
  }

  // sets the end screen style
  public void setThisYearEndScreenStyle() {
    setTextHeight(30);
    setTextColor("red");
    setTextStyle(Font.)
  }

   // draws the images with captions
  public void drawImagesWithCaptions() {
    setCaptionStyle();
    for (int index = 0; index < newYearPictures.length; index++) {
      // arguments: image, xPosi tion, yPosition, width, height, rotation
      drawImage(newYearPictures[index], 0, 0, 400, 400, 0.0);
      // arguments: text, xPosition, yPosition
      drawCaptionBox(80, 350, 250, 50, newCaptions[index]);
      // arguments: seconds
      pause(2.0);
    }
  }

     /**
   * Draws a white box with a shadow to display text
   */
  public void drawCaptionBox(int xPos, int yPos, int width, int height, String text) {
    // shadow box, 5px offset
    setFillColor("black");
    drawRectangle(xPos + 5, yPos + 5, width, height);
    
    // front box
    setFillColor("white");
    drawRectangle(xPos, yPos, width, height);

    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 24;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 10;
    int yLinePos = yPos + fontSize;
    drawText(text, xLinePos, yLinePos);
  }
  
  /**
   * This is Mr.Aiello's method for drawing the stack
   **/
    public void drawStack(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String picture : newYearPictures) {
      // choose a random degree to rotate (0-45)
      int angle = (int) (Math.random() * 46);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      // black boarder - 5px offset all around
      if (hasBoarder) {
        double boarderHalfSize = (size + 10) / 2.0;
        int boarderX = (int)(centerX - (boarderHalfSize * Math.cos(radians) - boarderHalfSize * Math.sin(radians)));
        int boarderY = (int)(centerY - (boarderHalfSize * Math.sin(radians) + boarderHalfSize * Math.cos(radians)));
        drawImage(blackBoarder, boarderX, boarderY, size + 10, dAngle);
      }
      
      // image on top of black boarder (if drawn)
      drawImage(picture, adjustedX, adjustedY, size, dAngle);
      pause(1.5);
    }
  }

  /*
   * Draws the thisYear title screen
   */
  public void drawThisYearTitleScreen() {
    setThisYearTitleScreenStyle();
    clear("blue");
    drawText("Places I want to visit this Year!", 20, 399, -45);
  }

  /**
   * Top level drawScene method
   */
  public void drawScene() {
  drawThisYearTitleScreen();
  pause(2.0);
  clear("white");
  drawStack(false);
  drawImagesWithCaptions();
  pause(1.5);
  
  }
 
}