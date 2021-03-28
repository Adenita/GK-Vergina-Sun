import java.awt.*;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.geom.*;

public class Sun
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SunPanel());
        frame.setVisible(true);
        frame.pack();
    }
}

class SunPanel extends JPanel
{
    public SunPanel()
    {
        setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g) 
    {
        
        Graphics2D gr2D = (Graphics2D) g;
        Shape circle = new Ellipse2D.Double(250, 250, 50, 50);
        Shape lineL = new Line2D.Double(275, 140, 265, 240);
        Shape lineR = new Line2D.Double(275, 140, 285, 240);
        Shape curve = new QuadCurve2D.Double(265, 240, 275, 250, 285, 240);


        drawCone(275, 140, 10, 100, gr2D);
        drawCone(275, 140 + 270, 10, -100, gr2D);
        drawCone(275, 140, 10, 100, gr2D);
        drawCone(275, 140, 10, 100, gr2D);


        gr2D.draw(circle);
        // gr2D.draw(lineL);
        // gr2D.draw(lineR);
        // gr2D.draw(curve);

    }

    public void drawOutline(int startx, int starty, int a, int b, int d, Graphics2D g2)
    {
        Shape lineL;
        Shape lineR;
        Shape arc;
        for (int i = 0; i < 2; i++) 
        {
            if (i == 0 || i == 4)
            {
                drawCone(startx, starty, a, b, g2);
            } 
            else if (i == 2 || i == 6)
            {
                
            } 
            else 
            {
                drawCone(startx, starty, a, b, g2);
            }
            
            // lineL = new Line2D.Double(startx, starty, startx - a, starty + b);
            // lineR = new Line2D.Double(startx, starty, startx + a, starty + b);
            // arc = new QuadCurve2D.Double(startx - a, starty + b, startx, starty + a + b,  startx + a, starty + b);
            
            // gr2D.draw(lineL);
            // gr2D.draw(lineR);
            // gr2D.draw(arc);

            startx += 100;
            starty += 30;
        

        }
       
    }

    public void drawCone(int startx, int starty, int a, int b, Graphics2D g2)
    {
        Shape lineL;
        Shape lineR;
        Shape arc;
 
        int rt = a + b;
        if (b < 0)
            rt = - (a - b);
       
        lineL = new Line2D.Double(startx, starty, startx - a, starty + b);
        lineR = new Line2D.Double(startx, starty, startx + a, starty + b);
        arc = new QuadCurve2D.Double(startx - a, starty + b, startx, starty + rt,  startx + a, starty + b);
        
        g2.draw(lineL);
        g2.draw(lineR);
        g2.draw(arc);
     
    }


}