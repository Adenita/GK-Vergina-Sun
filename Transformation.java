import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
// import java.awt.RadialGradientPaint;

public class Transformation
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TRS());
        frame.setVisible(true);
        frame.pack();
        
    }
}

class TRS extends JPanel
{
    public TRS()
    {
        this.setPreferredSize(new Dimension(600, 600));
        this.setOpaque(true);
        this.setBackground(Color.white);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));

        
        Shape rectangle = new Rectangle2D.Double(0,0,600,600);
        g2.setColor(Color.white);
        g2.fill(rectangle);

        g2.translate(100, 100);

        Shape circle = new Ellipse2D.Double(182, 182, 50, 50);
            g2.draw(circle);

        float [] dist = {0.15f, 1.0f};
        Color [] colors = {Color.orange, Color.darkGray};

        RadialGradientPaint gradient = new RadialGradientPaint(205.0f, 205.0f, 50.0f, dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);
            g2.setPaint(gradient);
            g2.fill(circle);


        int centerx = 205;
        int centery = 50;
        int leftx = 195;
        int lefty = 170;
        int rightx = 215;
        int righty = 170;

        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RadialGradientPaint grad = new RadialGradientPaint(205.0f, 205.0f, 170.0f, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);

        Line2D line1 = new Line2D.Double(centerx, centery, rightx, righty);
        Line2D line2 = new Line2D.Double(centerx, centery, leftx, lefty);
        QuadCurve2D curve = new QuadCurve2D.Double(leftx, lefty, 205, 183, rightx, righty);
        g2.setPaint(Color.black);
            g2.draw(line1);
            g2.draw(line2);
            g2.draw(curve);
        g2.setPaint(grad);
       
        Polygon poly = new Polygon(new int[] {205, 195, 215}, new int[] {50, 170, 170}, 3);
        
        g2.fill(poly);
       // g2.fillArc(195, 158, 20, 20, 180, 180);
        RadialGradientPaint grad1 = new RadialGradientPaint(205.0f, 205.0f, 210.0f, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);

        Line2D line3 = new Line2D.Double(centerx + 65, centery + 15, rightx + 23, righty - 20);
        Line2D line4 = new Line2D.Double(centerx + 65, centery + 15, leftx + 28, lefty - 25);
        QuadCurve2D curve1 = new QuadCurve2D.Double(leftx + 28, lefty - 25, 227, 158, rightx + 23, righty - 20);

        Polygon poly1 = new Polygon(new int[] {centerx + 65, leftx + 28, rightx + 23}, new int[] {centery + 15, lefty -25, righty - 20}, 3);

            g2.draw(line3);
            g2.draw(line4);
            g2.draw(curve1);
            g2.setPaint(grad1);
            g2.fill(poly1);

        double pivot = 207;
        for (int i = 0; i < 8; i++) 
        {
           AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);

             g2.setPaint(Color.black);
            g2.draw(tr.createTransformedShape(line1));
            g2.draw(tr.createTransformedShape(line2));
            g2.draw(tr.createTransformedShape(curve));
            g2.draw(tr.createTransformedShape(poly));
         
            g2.setPaint(grad);
            g2.fill(tr.createTransformedShape(poly));
            g2.fill(tr.createTransformedShape(curve));
           
            g2.setPaint(Color.black);
            g2.draw(tr.createTransformedShape(line3));
            g2.draw(tr.createTransformedShape(line4));
            g2.draw(tr.createTransformedShape(curve1));

            g2.setPaint(grad1);
            g2.fill(tr.createTransformedShape(poly1));
            g2.fill(tr.createTransformedShape(curve1));
        }
        

        
    }

    
}