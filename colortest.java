import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class colortest
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("DETYRA 29");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ct());
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.pack();
        
    }
}

class ct extends JPanel
{
    public ct()
    {
        this.setPreferredSize(new Dimension(420, 410));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        Shape circle = new Ellipse2D.Double(182, 182, 50, 50);
        g2.draw(circle);


        float [] dist1 = {0.01f, 1.0f};
        Color [] colors1 = {new Color(243,211,12), new Color(171,154,38)};
        RadialGradientPaint gradient1 = new RadialGradientPaint(205.0f, 205.0f,40, dist1, colors1, MultipleGradientPaint.CycleMethod.REFLECT);
        
        g2.setPaint(gradient1);
        g2.fill(circle);


        float [] dist = {0.01f, 0.5f, 0.9f};
        //Color [] colors = {Color.red, Color.blue, Color.pink};
        Color [] colors = {Color.white, new Color(243,211,12), new Color(134,119,33)};
        RadialGradientPaint gradient = new RadialGradientPaint (
            205.0f, 205.0f, 
            95.0f,
            dist,
            colors,
            MultipleGradientPaint.CycleMethod.NO_CYCLE
        );  

        RadialGradientPaint gradient2 = new RadialGradientPaint (
            205.0f, 205.0f, 
            120.0f,
            dist,
            colors,
            MultipleGradientPaint.CycleMethod.NO_CYCLE
        ); 

    
        int centerx = 205;
        int centery = 50;
        int leftx = 195;
        int lefty = 170;
        int rightx = 215;
        int righty = 170;

         //Kontruktojme konin e madh
         Polygon poly = new Polygon(new int[] {centerx, leftx, rightx}, new int[] {centery, lefty, righty}, 3);
         QuadCurve2D curve = new QuadCurve2D.Double(leftx, lefty, 205, 183, rightx, righty);

         g2.setColor(Color.black);
         g2.draw(poly);
         g2.draw(curve);
         g2.setPaint(gradient);
         g2.fill(poly);
         g2.fill(curve);
         
         //Konstruktojme konin e vogel
         Polygon poly1 = new Polygon(new int[] {centerx + 65, leftx + 28, rightx + 23}, new int[] {centery + 15, lefty -25, righty - 20}, 3);
         QuadCurve2D curve1 = new QuadCurve2D.Double(leftx + 28, lefty - 25, 227, 158, rightx + 23, righty - 20);
 
       
         double pivot = 207;
         for (int i = 0; i < 8; i++) 
         {
            AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);
 
            g2.setPaint(Color.black);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                 g2.draw(tr.createTransformedShape(poly));
                 g2.draw(tr.createTransformedShape(curve));

                 g2.draw(tr.createTransformedShape(poly1));
                 g2.draw(tr.createTransformedShape(curve1));
          
                 g2.setPaint(gradient);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                 g2.fill(tr.createTransformedShape(poly));
                 g2.fill(tr.createTransformedShape(curve));       
 
            g2.setPaint(gradient2);
                 g2.fill(tr.createTransformedShape(poly1));
                 g2.fill(tr.createTransformedShape(curve1));
         }

         AffineTransform tx = new AffineTransform();
         tx.scale(0.9, 0.9);

         Line2D l = new Line2D.Double(205, 80, 205, 170);


        //  g2.setStroke(new BasicStroke(1));
        //  g2.setColor(Color.black);
        //  g2.draw(l);
         
    }   
}