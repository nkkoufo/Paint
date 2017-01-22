
import java.awt.Graphics;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NAK5297
 */
public class RectangleButton extends JButton{
    public void paint(Graphics g){
        super.paint(g);
        //draws the rectangle on the button
        g.drawRect(this.getWidth() / 2 - (this.getWidth() - 10) / 2, this.getHeight() / 2 - (this.getHeight() - 10) / 2, this.getWidth() - 10, this.getHeight() - 10);
    }
    
}
