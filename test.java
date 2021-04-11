import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class test {
    public static void main(String[] args)  {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new t());
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.pack();   
    }
}

class t extends JPanel
{
    /** * */
    private static final long serialVersionUID = 1L;

    public t() {
        this.setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.translate(100, 100);

        float [] dist2 = {0.25f, 1.0f};
        Color [] colors2 = {new Color(239,210,13), new Color(135,117,32, 140)};
        RadialGradientPaint grad1 = new RadialGradientPaint(205f, 205f, 150f, dist2, colors2, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        Polygon poly2 = new Polygon(new int[] {202, 197, 213, 208}, new int[] {115, 170, 170, 115}, 4);
        QuadCurve2D curve2 = new QuadCurve2D.Double(197, 170, 205, 180, 213, 170);
        QuadCurve2D curve2b = new QuadCurve2D.Double(202, 115, 205, 108, 208, 115);

        double pivot = 207;
        for (int i = 0; i < 8; i++)  {
           AffineTransform tr = AffineTransform.getRotateInstance(Math.toRadians(360.0 / 8 * i), pivot, pivot);
     

           g2.setPaint(grad1);
           g2.fill(tr.createTransformedShape(poly2));
           g2.fill(tr.createTransformedShape(curve2));
           g2.fill(tr.createTransformedShape(curve2b));
        }
    }
}