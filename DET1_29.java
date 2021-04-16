import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class DET1_29
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("DETYRA 29");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Panel29());
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.pack(); 
    }
}

class Panel29 extends JPanel
{
    public Panel29()
    {
        this.setPreferredSize(new Dimension(420, 410));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        Stroke stroke = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Kontruktojme rrethin
        Shape circle = new Ellipse2D.Double(181, 181, 55, 55);
        g2.draw(circle);

        float [] distC = {0.01f, 0.5f, 1.0f};
        Color [] colorsC = {new Color(243,211,12), new Color(171,154,38), new Color(134,119,33)};
        RadialGradientPaint gradientC = new RadialGradientPaint(207.0f, 207.0f, 55, distC, colorsC, MultipleGradientPaint.CycleMethod.NO_CYCLE);
        
        g2.setPaint(gradientC);
        g2.fill(circle);

        int centerx = 207;
        int centery = 40;
        int leftx = 197;
        int lefty = 163;
        int rightx = 217;
        int righty = 163;
        
        //Outline per konin e madh
        Shape lineL = new Line2D.Double(centerx, centery, leftx, lefty);
        Shape lineR = new Line2D.Double(centerx, centery, rightx, righty);
        Arc2D arc = new Arc2D.Double(197, 153, 20, 20, 180, 180, Arc2D.OPEN);
        
        int centerx1 = 272;
        int centery1 = 55;
        int leftx1 = 226;
        int lefty1 = 146;
        int rightx1 = 239;
        int righty1 = 152;
        
        //Outline per konin e vogel
        Shape lineL1 = new Line2D.Double(centerx1, centery1, leftx1, lefty1);
        Shape lineR1 = new Line2D.Double(centerx1, centery1, rightx1, righty1);
        Arc2D arc1 = new Arc2D.Double(226, 141, 14, 14, 160, 180, Arc2D.OPEN);
        
        //Kontruktojme trekendshin brenda koneve perkates
        Polygon poly = new Polygon(new int[] {centerx, leftx, rightx}, new int[] {centery, lefty, righty}, 3);
        Polygon poly1 = new Polygon(new int[] {centerx1, leftx1, rightx1}, new int[] {centery1, lefty1, righty1}, 3);
        
        // Kontruktojme pjesen e ndritshme brenda konit te madh
        Polygon poly2 = new Polygon(new int[] {204, 199, 215, 210}, new int[] {100, 164, 164, 100}, 4);
        Arc2D arc2a = new Arc2D.Double(199, 155, 16, 17, 180, 180, Arc2D.OPEN);
        Arc2D arc2b = new Arc2D.Double(204, 98, 6, 10, 360, 180, Arc2D.OPEN);    
 
        float [] dist = {0.01f, 0.35f, 0.85f};
        Color [] colors = {new Color(255, 255, 255, 0), new Color(243,211,12), new Color(134,119,33)};
        
        RadialGradientPaint gradientN = new RadialGradientPaint (207.0f, 207.0f, 110.0f, dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);  
        RadialGradientPaint gradientKv = new RadialGradientPaint (205.0f, 205.0f, 145.0f, dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE); 
        
        float [] dista = {0.1f, 0.45f, 0.95f};
        Color [] colorsa = { new Color(243,211,12), new Color(171,154,38, 250), new Color(134,119,33)};
       
        RadialGradientPaint gradientKm = new RadialGradientPaint (207.0f, 207.0f, 80.0f, dista, colorsa, MultipleGradientPaint.CycleMethod.NO_CYCLE);  

        //Rrotullojme konet e konstruktuar tete here
         double pivot = 208;
         for (int i = 0; i < 8; i++) 
         {
            AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);
            
            g2.setPaint(Color.black);
                g2.draw(tr.createTransformedShape(lineL));
                g2.draw(tr.createTransformedShape(lineR));
                g2.draw(tr.createTransformedShape(arc));

                g2.draw(tr.createTransformedShape(lineL1));
                g2.draw(tr.createTransformedShape(lineR1));
                g2.draw(tr.createTransformedShape(arc1));
 
            g2.setPaint(gradientKm);
                 g2.fill(tr.createTransformedShape(poly));
                 g2.fill(tr.createTransformedShape(arc));
                 
           g2.setPaint(gradientKv);
                 g2.fill(tr.createTransformedShape(poly1));
                 g2.fill(tr.createTransformedShape(arc1));  
                
           g2.setPaint(gradientN);
                 g2.fill(tr.createTransformedShape(poly2));
                 g2.fill(tr.createTransformedShape(arc2a));
                 g2.fill(tr.createTransformedShape(arc2b)); 
         }   
    }   
}
