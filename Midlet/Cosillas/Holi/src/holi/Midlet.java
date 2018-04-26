/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holi;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;

/**
 * @author Maku
 */
public class Midlet extends MIDlet {
    private Display display;
    private MyCanvas mycanvas;
    
    public void startApp()    throws MIDletStateChangeException {        
  display = Display.getDisplay(this);
  this.mycanvas = new MyCanvas();		
  display.setCurrent(mycanvas);
}
    
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
    class MyCanvas extends Canvas {
      protected void paint(Graphics g) {
        g.setColor(255,255,255);
        g.drawString("HOLA MUNDO", this.getWidth()/2, this.getHeight()/2,
                       Graphics.BASELINE|Graphics.HCENTER);
      }
    }
