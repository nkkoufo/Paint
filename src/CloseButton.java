
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
public class CloseButton extends JButton{
    private BufferedImage close; //uses bufferedimage to allow custom image on button
    
    public CloseButton() throws IOException{
        //this opens the image and sets bufferedimage to it
        
       try{
           //this file path works for me not sure what will happen
           //when it gets uploaded and you try it but right now the 
           //button shows for me with the correct image
           this.close = ImageIO.read(new File("E:\\NetBeans\\Final\\src/close.png"));
           
       } catch(IOException e){
           //catch
           e.printStackTrace();
       }
    }
    public void paint(Graphics g){
        //this draws the image on the button
        super.paint(g);
        g.drawImage(this.close,1,1,this.getWidth()-1,this.getHeight()-1,0,0,128,128,null);
        
    }
    
    
}
