import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class MoverImagen extends MIDlet {
    private Imagen img;
    private Display d;
    public MoverImagen() {
        d = Display.getDisplay(this);
        img = new Imagen(this);
    }
    public void startApp() {
        d.setCurrent(img);
    }
    public void pauseApp() {    }
    public void destroyApp(boolean b) {    }
    public void salir() {
        destroyApp(false);
        notifyDestroyed();
    }
}