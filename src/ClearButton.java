
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class ClearButton extends JButton{
    private BufferedImage clear;
    
     public ClearButton() {
        try {//sets the image
            this.clear = ImageIO.read(new File("E:\\NetBeans\\Final\\src/clear.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        //draws the image
        g.drawImage(this.clear, 0, 0, this.getWidth() - 1, this.getHeight() - 1, 0, 0, 200, 200, null);
    }
    
}
