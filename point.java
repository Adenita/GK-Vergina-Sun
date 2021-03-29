import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class point
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setTitle("Detyra1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new pointPanel());
        frame.setVisible(true);
        frame.pack();
    }
}

class pointPanel extends JPanel
{
    public pointPanel()
    {
        setPreferredSize(new Dimension(700, 700));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));

        g2.translate(50,50);

        int centerx = 250;
        int centery = 250;
        int leftx;
        int lefty;
        int rightx;
        int righty;

        int x2;
        int y2;
        int x3;
        int y3;
     
        // for (int i = 0; i < 8; i++) 
        // {      
        //     x2 = (int)(Math.cos(Math.toRadians(45)) * centerx - Math.sin(Math.toRadians(45)) * centery);
        //     y2 = (int)(Math.cos(Math.toRadians(45)) * centerx - Math.sin(Math.toRadians(45)) * centery);
        //    x3 = (int)(centery +  40 * Math.cos(Math.toRadians(45)));
        //    y3 = (int)(centerx + 40 * Math.sin(Math.toRadians(45))); 
           
        //    leftx = x3 - 10;
        //    rightx = x3 + 10;

        //    centerx = x2;
        //    centery = y2;

        //    g2.drawLine(x2, y2, x2, y2);
        //    //g2.drawLine(x2, y2, rightx, y3);;

        //    g2.setColor(Color.PINK);
        //    g2.drawLine(x2, y2, x2, y2);
        //    g2.setColor(Color.yellow);
        //    g2.drawLine(rightx, y3, rightx, y3);
        //    g2.setColor(Color.red);
        //    g2.drawLine(leftx, y3, leftx, y3);
     
        // }

        for (int i = 0; i < 8; i++) 
        {
            g2.drawLine(centerx, centery, centerx, centery);
            centerx = (int)(Math.cos(Math.toRadians(45)) * (centerx - 100)- Math.sin(Math.toRadians(45)) * (centery - 100)) + 100;
            centery = (int)(Math.cos(Math.toRadians(45)) * (centerx - 100) + Math.sin(Math.toRadians(45)) * (centery - 100)) + 100;
        }
       
       
            //  centerx = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);
            // centery = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);


            // centerx = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);
            // centery = (int)(Math.cos(Math.toRadians(30)) * centerx - Math.sin(Math.toRadians(30)) * centery);

            // leftx = (int)(Math.cos(Math.toRadians(30)) * leftx - Math.sin(Math.toRadians(30)) * lefty);
            // lefty = (int)(Math.cos(Math.toRadians(30)) * leftx - Math.sin(Math.toRadians(30)) * lefty);

            // rightx = (int)(Math.cos(Math.toRadians(30)) * rightx - Math.sin(Math.toRadians(30)) * righty);
            // righty = (int)(Math.cos(Math.toRadians(30)) * rightx - Math.sin(Math.toRadians(30)) * righty);
    
    }
    
}