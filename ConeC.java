import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class ConeC {
    public static void main(String[] args)  {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CC());
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.pack();   
    }
}

class CC extends JPanel
{

    public CC() {
        this.setPreferredSize(new Dimension(510, 500));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.translate(50, 50);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape circle = new Ellipse2D.Double(182, 182, 50, 50);
        g2.draw(circle);

        float [] dist = {0.01f, 1.0f};
        Color [] colors = {new Color(243,211,12), new Color(171,154,38)};
        RadialGradientPaint gradient1 = new RadialGradientPaint(205.0f, 205.0f,40, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);
        
        g2.setPaint(gradient1);
        g2.fill(circle);

        float [] dist1 = {0.01f, 1.0f};

        Color [] colors1 = {new Color(237,208,10), new Color(134,119,33)};
        RadialGradientPaint grad = new RadialGradientPaint(205.0f, 205.0f, 110, dist1, colors1, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        float [] dist4 = {0.01f, 0.5f, 0.9f};
        Color [] colors4 = {new Color(255, 255, 255, 30), new Color(243,211,12), new Color(134,119,33)};

        RadialGradientPaint gradient2 = new RadialGradientPaint (
            205.0f, 205.0f, 
            110.0f,
            dist4,
            colors4,
            MultipleGradientPaint.CycleMethod.NO_CYCLE
        ); 

        Polygon poly = new Polygon(new int[] {205, 195, 215}, new int[] {50, 170, 170}, 3);
        QuadCurve2D curve = new QuadCurve2D.Double(195, 170, 205, 183, 215, 170);
        Shape lineL = new Line2D.Double(205, 50, 195, 170);
        Shape lineR = new Line2D.Double(205, 50, 215, 170);

        Shape lineL1 = new Line2D.Double(270, 65, 223, 145);
        Shape lineR1 = new Line2D.Double(270, 65, 238, 150);

        Polygon poly1 = new Polygon(new int[] {205 + 65, 195 + 28, 215 + 23}, new int[] {50 + 15, 170 -25, 170 - 20}, 3);
        QuadCurve2D curve1 = new QuadCurve2D.Double(195 + 28, 170 - 25, 227, 158, 215 + 23, 170 - 20);

        float [] dist2 = {0.25f, 0.4f, 1.0f};
        Color [] colors2 = {new Color(255, 255, 255, 80), new Color(239,210,13, 90), new Color(134,119,33)};

        Polygon poly2 = new Polygon(new int[] {202, 197, 213, 208}, new int[] {115, 170, 170, 115}, 4);
        QuadCurve2D curve2 = new QuadCurve2D.Double(197, 170, 205, 180, 213, 170);
        QuadCurve2D curve2b = new QuadCurve2D.Double(202, 115, 205, 108, 208, 115);
    
        RadialGradientPaint grad1 = new RadialGradientPaint(205.0f, 205f, 150f, dist2, colors2, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        double pivot = 207;
        for (int i = 0; i < 8; i++)  {
           AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);
            
           g2.setPaint(Color.black);
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.draw(tr.createTransformedShape(curve1));
                g2.draw(tr.createTransformedShape(curve));
                g2.draw(tr.createTransformedShape(lineL));
                g2.draw(tr.createTransformedShape(lineR));
                g2.draw(tr.createTransformedShape(lineL1));
                g2.draw(tr.createTransformedShape(lineR1));

         
            g2.setPaint(grad);
                g2.fill(tr.createTransformedShape(poly));
                g2.fill(tr.createTransformedShape(curve));

            g2.setPaint(gradient2);
                g2.fill(tr.createTransformedShape(poly1));
                g2.fill(tr.createTransformedShape(curve1));

            g2.setPaint(grad1);
                g2.fill(tr.createTransformedShape(poly2));
                g2.fill(tr.createTransformedShape(curve2));
                g2.fill(tr.createTransformedShape(curve2b));
        }   
    }
}