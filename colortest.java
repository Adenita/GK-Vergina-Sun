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

    // ngjyrat mire jone its a 7/10
    // boje lidhjen e vijave me stroke ato metodat qe jone.

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
        Color [] colors = {new Color(255, 255, 255, 100), new Color(243,211,12), new Color(134,119,33)};
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

        int centerx = 207;
        int centery = 40;
        int leftx = 197;
        int lefty = 165;
        int rightx = 217;
        int righty = 165;

        int centerx1 = 272;
        int centery1 = 55;
        int leftx1 = 226;
        int lefty1 = 146;
        int rightx1 = 239;
        int righty1 = 152;

        //Outline per konin e madh
        Shape lineL = new Line2D.Double(centerx, centery, leftx, lefty);
        Shape lineR = new Line2D.Double(centerx, centery, rightx, righty);
        Arc2D arc = new Arc2D.Double(197, 155, 20, 20, 180, 180, Arc2D.OPEN);

        //Outline per konin e vogel
        Shape lineL1 = new Line2D.Double(centerx1, centery1, leftx1, lefty1);
        Shape lineR1 = new Line2D.Double(centerx1, centery1, rightx1, righty1);
        Arc2D arc1 = new Arc2D.Double(226, 141, 14, 14, 160, 180, Arc2D.OPEN);

        //Kontruktojme konin e madh dhe te vogel ne menyre qe te mund t'i ngjyrosim 
        Polygon poly = new Polygon(new int[] {centerx, leftx, rightx}, new int[] {centery, lefty, righty}, 3);
        Polygon poly1 = new Polygon(new int[] {centerx1, leftx1, rightx1}, new int[] {centery1, lefty1, righty1}, 3);

       
         double pivot = 207;
         for (int i = 0; i < 8; i++) 
         {
            AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);
 
            g2.setPaint(Color.black);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                 g2.draw(tr.createTransformedShape(lineL));
                 g2.draw(tr.createTransformedShape(lineR));
                 g2.draw(tr.createTransformedShape(arc));

                 g2.draw(tr.createTransformedShape(lineL1));
                 g2.draw(tr.createTransformedShape(lineR1));
                 g2.draw(tr.createTransformedShape(arc1));
          
                 g2.setPaint(gradient);
                 g2.fill(tr.createTransformedShape(poly));
                 g2.fill(tr.createTransformedShape(arc));       
 
            g2.setPaint(gradient2);
                 g2.fill(tr.createTransformedShape(poly1));
                 g2.fill(tr.createTransformedShape(arc1));
         }
    }   
}