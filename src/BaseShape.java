
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
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
public abstract class BaseShape {
    //base shape class
    int x,y,width,height;
    //method that draws shape
    //ment to be overriden
    public abstract void drawS(Graphics d,int xo, int yo, int w, int h, Color col, BasicStroke base, boolean f, float tran, GradientPaint grad, TexturePaint tex);
    
}
