
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NAK5297
 */
public class Printer implements Printable{
    //
    Image i;
    public Printer(Image i){
        //sets image to the background
        this.i = i;
        
    }
    public int print(Graphics g, PageFormat page, int n) throws PrinterException{
        //draws
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.i,0,0,null);
        return 0;
    }
}
