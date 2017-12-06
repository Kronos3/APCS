import objectdraw.*;
import java.awt.*;

/**
 * A class for checking the review from unit 1 of Programming 1
 */
public class ProgReview1 extends FrameWindowController
{

    /**
     * Draws the figure for number 12 on the canvas
     */
    public void begin()
    {
        new Line(150,0,150,300,canvas);
        new Line(0,150,150,150,canvas);
        new FilledRect(225,75,75,150,canvas);
        new FramedOval(0,150,150,150,canvas);
    }
}
