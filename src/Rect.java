
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NAK5297
 */
public class Rect extends BaseShape{
    public void drawS(Graphics g, int x, int y, int wid, int hig, Color c, BasicStroke bas, boolean fill, float tran, GradientPaint gp, TexturePaint tx){
        Graphics2D g2d = (Graphics2D)g; 
        //this class draws oval
        //by overriding baseshape
        g2d.setColor(c);
        g2d.setStroke(bas);
        AlphaComposite ac = AlphaComposite.getInstance(3, tran);
        g2d.setComposite(ac);
        if(gp != null)
            g2d.setPaint(gp);
        if(tx != null)
            g2d.setPaint(tx);
        if(!fill)
            g2d.drawRect(x, y, wid, hig);
        else
            g2d.fillRect(x, y, wid, hig);
        
    }
    
}
