import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class PaintTest8 extends JPanel {

  public static void main (String [] args) {
    JFrame frame = new JFrame ();

    PaintTest8 app = new PaintTest8 ();
    frame.getContentPane (). add (app);

    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setBounds (10, 10, 300, 200);
    frame.setTitle ("Title");
    frame.setVisible (true);
  }

  public void paintComponent (Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    float [] dist = {0.0f, 0.4f, 1.0f};
    //Color [] colors = {Color.red, Color.blue, Color.pink};
    Color [] colors = {new Color(235,205,13),  new Color(104,100,35), new Color(134,119,33)};
    RadialGradientPaint gradient = new RadialGradientPaint (
        100.0f, 80.0f, 
        60.0f,
        85.0f, 90.0f, 
        dist,
        colors,
        MultipleGradientPaint.CycleMethod.NO_CYCLE
        // MultipleGradientPaint.CycleMethod.REFLECT
        // MultipleGradientPaint.CycleMethod.REPEAT
    );

    g2.setPaint (gradient);

    g2.fill (new Rectangle2D.Double (20, 20, 200, 130));

    g2.setPaint (Color.black);
    g2.draw (new Ellipse2D.Double (95, 75, 10, 10));
    g2.draw (new Ellipse2D.Double (55, 55, 10, 10));

  
  }

 
}
