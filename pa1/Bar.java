// Name:Chuanli Wei
// USC NetID:6222006323
// CS 455 PA1
// Spring 2017

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 *
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 *
 */
public class Bar {

    private int bottom;
    private int left;
    private int width;
    private int barHeight;
    private double scale;
    private Color color;
    private String label;
    //To make the label appear in the middle of the bar
    private static final int LABEL_OFFSET = 30;
    //height of the bar equals the scale times the barHeight
    int height;
    /**
     Creates a labeled bar.  You give the height of the bar in application
     units (e.g., population of a particular state), and then a scale for how
     tall to display it on the screen (parameter scale).

     @param bottom  location of the bottom of the label
     @param left  location of the left side of the bar
     @param width  width of the bar (in pixels)
     @param barHeight  height of the bar in application units
     @param scale  how many pixels per application unit
     @param color  the color of the bar
     @param label  the label at the bottom of the bar
     */
    public Bar(int bottom, int left, int width, int barHeight,
               double scale, Color color, String label) {

        this.bottom = bottom;
        this.left = left;
        this.width = width;
        this.barHeight = barHeight;
        this.scale = scale;
        this.color = color;
        this.label = label;
        height = (int)(scale*barHeight);

    }

    /**
     Draw the labeled bar.
     @param g2  the graphics context
     */

    public void draw(Graphics2D g2) {

        //the height of the bar equals barHeight*scale
        int height = (int)(scale*barHeight);

        //initialize the rectangle to be the bar
        Rectangle rec = new Rectangle(left,bottom-height,width,height);
        g2.setColor(color);
        g2.fill(rec);

        Font font= g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(label, context);

        //get the height of the label
        int heightOfLabel = (int)labelBounds.getHeight();

        //draw the label
        g2.setColor(Color.black);
        g2.drawString(label,left-LABEL_OFFSET,bottom+heightOfLabel);

    }
}


