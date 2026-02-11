import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  // Variables (instance & static)
  private String[] placePictures;
  private String[] placesCaptions = {
    "Brothers at the beach!",
    "Yogurtland!",
    "My first concert!",
    "The Six Flags Trio!",
    "Santa Monica Pier!",
  };
  
  // Constuctors

  // Non parameterized constructor
  public LastYear() {
    placePictures = FileReader.toStringArray("2025pictures.txt");
  }

  // Parameterized constructor 
  public LastYear(String[] placePictures) {
    this.placePictures = placePictures; 
  }


  // draws the titleScreen() 
  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("green");
    drawText("Pictures", 100, 175);
    drawText("from", 140, 225);
    drawText("2025!", 125, 275);
    
  }

  // draws the images with captions
  public void drawImagesWithCaptions() {
    setCaptionStyle();
    for (int index = 0; index < placePictures.length; index++) {
      // arguments: image, xPosi tion, yPosition, width, height, rotation
      drawImage(placePictures[index], 0, 0, 400, 400, 0.0);
      // arguments: text, xPosition, yPosition
      drawCaptionBox(80, 350, 250, 50, placesCaptions[index]);
      // arguments: seconds
      pause(2.0);
    }
  }

// draws the transition screen 
  public void drawTransitionScreen() {
    setTransitionScreenStyle();
    drawTransitionBanner();
  }
    /**
   * Draws text coming in from right side of screen to left, 
   * Text should all leave screen based on calculator of help method
   */
  public void drawTransitionBanner() {
    setTextHeight(50);

    int xPos = 400; // start on right side of screen
    int textWidth = getEstimateLengthInPixels("Now to 2026!", 50);

    while (xPos > -textWidth) {
      clear("black"); // can change to different color or image
      
      drawText("Now to 2026!", xPos, 200);
      pause(0.1); // this is the fastest it can be, can slow down
      
      xPos -= 10; // shift over by 10px, can change
    }
  }

  /**
   * Helper method, estimates the with of text in pixels
   */
  public static int getEstimateLengthInPixels(String text, int textSize) {
    // the average width per character at size 22 is ~15px, which is about 70%
    double avgWidthPerChar = 0.7 * textSize;
    // add 15% buffer to overestimate
    return (int) (text.length() * avgWidthPerChar * 1.15);
  }


  // sets the title screen style
  public void setTitleScreenStyle() {
    setTextHeight(50);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
  }

  // sets the caption style
  public void setCaptionStyle() {
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
  }

  // sets the end screen style 
  public void setTransitionScreenStyle() {
    setTextHeight(50);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD_ITALIC);
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
   * Top level drawScene method
   */
  public void drawScene() {
   drawTitleScreen();
    // pause here before Images
    pause(2.0);
    // Images With Captions (pause in method)
    drawImagesWithCaptions();
    // Transiiton Screen
    drawTransitionScreen();
    pause(2.0);
  }

}