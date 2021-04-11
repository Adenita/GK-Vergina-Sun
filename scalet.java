import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class scalet {
    public static void main(String[] args)  {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new sct());
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.pack();   
    }
}

class sct extends JPanel
{
    /** * */
    private static final long serialVersionUID = 1L;

    public sct() {
        this.setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.translate(100, 100);

        Shape circle = new Ellipse2D.Double(182, 182, 50, 50);
        g2.draw(circle);


        float [] dist = {0.01f, 1.0f};
        Color [] colors = {new Color(243,211,12), new Color(171,154,38)};
        RadialGradientPaint gradient1 = new RadialGradientPaint(205.0f, 205.0f,40, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);
        
        g2.setPaint(gradient1);
        g2.fill(circle);

        float [] dist1 = {0.01f, 1.0f};
        Color [] colors1 = {new Color(237,208,10), new Color(76,75,46)};
        RadialGradientPaint grad = new RadialGradientPaint(205.0f, 205.0f, 150, dist1, colors1, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        Polygon poly = new Polygon(new int[] {205, 195, 215}, new int[] {50, 170, 170}, 3);
        QuadCurve2D curve = new QuadCurve2D.Double(195, 170, 205, 183, 215, 170);

        Polygon poly1 = new Polygon(new int[] {205 + 65, 195 + 28, 215 + 23}, new int[] {50 + 15, 170 -25, 170 - 20}, 3);
        QuadCurve2D curve1 = new QuadCurve2D.Double(195 + 28, 170 - 25, 227, 158, 215 + 23, 170 - 20);

        double pivot = 207;
        for (int i = 0; i < 8; i++)  {
           AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);
            
           AffineTransform sc = AffineTransform.getScaleInstance(0.89, 0.89);
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

            g2.setColor(Color.black);
            g2.translate(23, 22);
            g2.draw(sc.createTransformedShape(tr.createTransformedShape(poly)));
            g2.translate(-23, -22);
     
        }
    }
}