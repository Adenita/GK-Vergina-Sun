import javax.swing. *;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom. *;
import java.awt.Color;
import java.awt.RadialGradientPaint;
import java.awt.MultipleGradientPaint;

public class PaintTest7 extends JPanel {

  public static void main (String [] args) {
    JFrame frame = new JFrame ();

    PaintTest7 app = new PaintTest7 ();
    frame.getContentPane (). add (app);

    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setBounds (10, 10, 300, 200);
    frame.setTitle ("Title");
    frame.setVisible (true);
  }

  public void paintComponent (Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    float [] dist = {0.0f, 0.4f, 1.0f};
    Color [] colors = {Color.RED, Color.WHITE, Color.BLUE};

    RadialGradientPaint gradient = new RadialGradientPaint (
        100.0f, 80.0f, 
        60.0f,
        dist,
        colors,
       MultipleGradientPaint.CycleMethod.NO_CYCLE
        // MultipleGradientPaint.CycleMethod.REFLECT
       //  MultipleGradientPaint.CycleMethod.REPEAT
    );
    g2.setPaint (gradient);

    g2.fill (new Rectangle2D.Double (20, 20, 200, 130));
  }
}