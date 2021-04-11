import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class TestArc {

    public static void main(String[] args) {
        new TestArc();
    }

    public TestArc() {
    
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
    }

 class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int radius = Math.min(getWidth(), getHeight());
            int x = (getWidth() - radius) / 2;
            int y = (getHeight() - radius) / 2;

            RadialGradientPaint rgp = new RadialGradientPaint(
                            new Point(getWidth() / 2, getHeight() / 2),
                            radius,
                            new float[]{0f, 1f},
                            new Color[]{new Color(243,211,12), new Color(171,154,38)}
                            );
            g2d.setPaint(rgp);
            g2d.fill(new Arc2D.Float(x, y, radius, radius, 0, 45, Arc2D.PIE));
            g2d.dispose();
        }

    }



