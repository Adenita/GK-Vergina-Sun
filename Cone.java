import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Cone
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ConePanel());
        frame.setVisible(true);
        frame.pack();
    }
}

class ConePanel extends JPanel
{
    public ConePanel()
    {
        setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        int centerx = 275;
        int centery = 140;
        int leftx = 265;
        int lefty = 240;
        int rightx = 285;
        int righty = 240;

        Shape lineL;
        Shape lineR;
        Shape arc;
 
        lineL = new Line2D.Double(centerx, centery, leftx, lefty);
        lineR = new Line2D.Double(centerx, centery, rightx, righty);
        arc = new QuadCurve2D.Double(leftx, lefty, (leftx + rightx)/2, (lefty + righty) - Math.toRadians(30) , rightx, righty);
       
        g2.draw(lineL);
        g2.draw(lineR);
        g2.draw(arc);

            // centerx = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);
            // centery = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);

            // leftx = (int)(Math.cos(Math.toRadians(30)) * leftx - Math.sin(Math.toRadians(30)) * lefty);
            // lefty = (int)(Math.cos(Math.toRadians(30)) * leftx - Math.sin(Math.toRadians(30)) * lefty);

            // rightx = (int)(Math.cos(Math.toRadians(30)) * rightx - Math.sin(Math.toRadians(30)) * righty);
            // righty = (int)(Math.cos(Math.toRadians(30)) * rightx - Math.sin(Math.toRadians(30)) * righty);
        
            g2.draw(lineL);
        g2.draw(lineR);
        g2.draw(arc);


        //general formula:
        // x' = cos(angle of rotation) * x - sin(angle of rotation) * y
        // y' = cos(angle of rotation) * x + sin(angle of rotation) * y
        // for (int i = 0; i < 8; i++) 
        // {
         
        //     centerx = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);
        //     centery = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);

        //     leftx = (int)(Math.cos(Math.toRadians(30)) * leftx - Math.sin(Math.toRadians(30)) * lefty);
        //     lefty = (int)(Math.cos(Math.toRadians(30)) * leftx - Math.sin(Math.toRadians(30)) * lefty);

        //     rightx = (int)(Math.cos(Math.toRadians(30)) * rightx - Math.sin(Math.toRadians(30)) * righty);
        //     righty = (int)(Math.cos(Math.toRadians(30)) * rightx - Math.sin(Math.toRadians(30)) * righty);

        // }
    }
    
}