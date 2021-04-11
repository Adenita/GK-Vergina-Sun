import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Transformation
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TRS());
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.pack();
        
    }
}

class TRS extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TRS()
    {
        this.setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.translate(100, 100);

        Shape circle = new Ellipse2D.Double(182, 182, 50, 50);
            g2.draw(circle);

        float [] dist = {0.01f, 1.0f};
        Color [] colors = {new Color(243,211,12), new Color(171,154,38)};
        RadialGradientPaint gradient = new RadialGradientPaint(205.0f, 205.0f,40, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);
               
        g2.setPaint(gradient);
        g2.fill(circle);

        float [] dist1 = {0.01f, 1.0f};
        Color [] colors1 = {new Color(237,208,10), new Color(76,75,46)};
        RadialGradientPaint grad = new RadialGradientPaint(205.0f, 205.0f, 200f, dist1, colors1, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        int centerx = 205;
        int centery = 50;
        int leftx = 195;
        int lefty = 170;
        int rightx = 215;
        int righty = 170;

        //Kontruktojme konin e madh
        Polygon poly = new Polygon(new int[] {centerx, leftx, rightx}, new int[] {centery, lefty, righty}, 3);
        QuadCurve2D curve = new QuadCurve2D.Double(leftx, lefty, 205, 183, rightx, righty);
        
        //Konstruktojme konin e vogel
        Polygon poly1 = new Polygon(new int[] {centerx + 65, leftx + 28, rightx + 23}, new int[] {centery + 15, lefty -25, righty - 20}, 3);
        QuadCurve2D curve1 = new QuadCurve2D.Double(leftx + 28, lefty - 25, 227, 158, rightx + 23, righty - 20);

        double pivot = 207;
        for (int i = 0; i < 8; i++) 
        {
           AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);

            g2.setPaint(Color.black);
                g2.draw(tr.createTransformedShape(poly));
                g2.draw(tr.createTransformedShape(curve));
         
            g2.setPaint(grad);
                g2.fill(tr.createTransformedShape(poly));
                g2.fill(tr.createTransformedShape(curve));

            g2.setPaint(Color.black);
                g2.draw(tr.createTransformedShape(poly1));
                g2.draw(tr.createTransformedShape(curve1));

            g2.setPaint(grad);
                g2.fill(tr.createTransformedShape(poly1));
                g2.fill(tr.createTransformedShape(curve1));
        }


        Shape e1 = new Ellipse2D.Double(198.5, 120, 13, 57);
        // g2.setColor(Color.BLACK);
        // g2.draw(e1);
        Point2D a = new Point2D.Double(205, 150);
        Point2D b = new Point2D.Double(215, 150);
        LinearGradientPaint grad1 = new LinearGradientPaint(a, b, dist1, colors, MultipleGradientPaint.CycleMethod.REFLECT);
        //ConicalGradientPaint as = new ConicalGradientPaint()
 
        g2.setPaint(grad1);
        g2.fill(e1);
        

        
    }

    
}