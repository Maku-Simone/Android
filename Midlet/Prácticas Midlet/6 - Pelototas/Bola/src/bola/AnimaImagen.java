package bola;


import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;


public class AnimaImagen extends GameCanvas implements Runnable{
    Graphics    g;
    Thread      t;
    Image       base, bola;
    public AnimaImagen(){
        super(true);
        g = getGraphics();
        try{
            base = Image.createImage("fondo.jpg");
            bola = Image.createImage("bola.png");
        }catch(Exception e){}
        t = new Thread(this);
        t.start();
    }
    public void run(){
        int x=0, y=0;
        int vx = 5;
        int vy = 5;
        int alto = getHeight();
        int ancho = getWidth();
        while(true){
            g.drawImage(base, 0, 0, Graphics.TOP|Graphics.LEFT);
            g.drawImage(bola, x, y, Graphics.TOP|Graphics.LEFT);
            try{
                t.sleep(50);
            }catch(InterruptedException ie){}
            x = x + vx;
            y = y + vy;
            if( (x+bola.getWidth())>ancho || (x<0))
                vx = -vx;
            if( (y+bola.getHeight())>alto || (y<0))
                vy = -vy;
            flushGraphics();
        }
    }
}