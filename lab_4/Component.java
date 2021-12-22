package lab_4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Currency;

public class Component extends JComponent {
    String Operation;
    String TypeOfTime;
    ArrayList<Integer> Time;
    ArrayList<Integer> Count;
    Integer CountDivider;
    Integer TimeDivider;
    public Component(String Operation_, String TypeOfTime_, ArrayList<Integer> Time_, ArrayList<Integer> Count_, Integer CountDivider_, Integer TimeDivider_) {
        Operation=Operation_;
        TypeOfTime=TypeOfTime_;
        Time=Time_;
        Count=Count_;
        CountDivider=CountDivider_;
        TimeDivider=TimeDivider_;
    }

    private static final int DEF_WIDTH=200;
    private static final int DEF_HEIGHT=100;

    public void paintComponent(Graphics g) {
        double originX=50;
        double originY=600;
        g.drawString(Operation+TypeOfTime,350, 40);
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.drawString("Time",(int)originX,30);
        g2.drawString("Count",1220,(int)originY);
        Line2D axisY=new Line2D.Double(originX, originY,50, 50);
        Line2D axisX=new Line2D.Double(originX, originY,1200, 600);
        g2.draw(axisX);
        g2.draw(axisY);
        g2.setColor(Color.RED);
        double currentX=originX;
        double currentY=originY;
        for(int i=0; i<Time.size(); ++i) {
            double nextX=(double) Count.get(i) /CountDivider+originX;
            double nextY=originY-(double)Time.get(i)/TimeDivider;
            Line2D partOfFunction = new Line2D.Double(currentX, currentY, nextX, nextY);
            g2.draw(partOfFunction);
            g2.drawString(Integer.toString(Count.get(i)),(int)currentX, (int)originY+10);
            g2.drawString(Integer.toString(Time.get(i)),(int)originX-40,(int)currentY);
            currentY=nextY;
            currentX=nextX;
        }
    }

    public Dimension getPreferredDimension(){
        return new Dimension(DEF_WIDTH, DEF_HEIGHT);
    }
}
