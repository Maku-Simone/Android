// Animacion class ejecuta los hilos AnimaBola o AnimaImagen:
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Animacion extends MIDlet {
    Display     d;
    AnimaBola   ab;
    AnimaImagen ai;
    public void startApp() {
        d = Display.getDisplay(this);
        //ab = new AnimaBola();	// probar con AnimaBola()
        //d.setCurrent(ab);	// para mostrar ab.
        ai = new AnimaImagen();	// probando AnimaImagen()
        d.setCurrent(ai);	// para mostrar ai.
    }
    public void pauseApp() {    }
    public void destroyApp(boolean unconditional) {    }
}

////////////////////////////////////////////

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
public class AnimaBola extends GameCanvas implements Runnable{
    Graphics    g;
    Thread      t;
    public AnimaBola(){
	super(true);
	g = getGraphics();
        t = new Thread(this);
        t.start();
    }
    public void run() {
        int x=0, y=0;
	int vx = 5;
	int vy = 5;
	int ancho = getWidth();
	int alto = getHeight(); 
	while(true) {
	    g.setColor(0x000000); //color negro
	    g.fillRect(0, 0, ancho, alto);
	    g.setColor(0x0000FF); //color azul   
	    g.fillArc(x, y, 20, 20, 0, 360);
	    try {
		t.sleep(30);
	    } catch (InterruptedException e) { }
	    x = x + vx;
	    y = y + vy;
	    if ((x + 20) > ancho || (x < 0 ))
		vx = -vx; 
	    if ((y + 20) > alto || (y < 0 )) 
		vy = -vy; 
		flushGraphics(); 
	} 
    }
}

////////////////////////////////////////////

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
public class AnimaImagen extends GameCanvas implements Runnable{
    Graphics    g;
    Thread      t;
    Image       base, bola;
    public AnimaImagen(){
        super(true);
        g = getGraphics();
        try{
            base = Image.createImage("/base.jpg");
            bola = Image.createImage("/bola.png");
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

/////////////////////////////////////////
CONFIGURACION:
Proyecto:	Animaciones
Paquetes:		Source Packages
				<default package>
					AnimaBola.java
					AnimaImagen.java
					Animacion.java
					base.jpg
					bola.png
			Resources
			Project Configurations
GUARDAR IMAGENES EN: C:\Users\escom\Documents\NetBeansProjects\Animaciones\src\bola.png y base.jpg
