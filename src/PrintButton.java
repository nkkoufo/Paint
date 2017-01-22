
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
public class PrintButton extends JButton{
    private BufferedImage print;
     public PrintButton() {
        try {
            //sets the image
            this.print = ImageIO.read(new File("E:\\NetBeans\\Final\\src/print.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        //draws image
        g.drawImage(this.print, 0, 0, this.getWidth() - 1, this.getHeight() - 1, 0, 0, 512, 512, null);
    }
    
}
