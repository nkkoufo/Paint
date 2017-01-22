
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
public class FreeButton extends JButton{
    private BufferedImage free;

    public FreeButton() {
        try {
            this.free = ImageIO.read(new File("E:\\NetBeans\\Final\\src/pencil.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.free, 0, 0, this.getWidth() - 1, this.getHeight() - 1, 0, 0, 626, 626, null);
    }
    
}
