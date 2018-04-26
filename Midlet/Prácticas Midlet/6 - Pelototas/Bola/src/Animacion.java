

// Animacion class ejecuta los hilos AnimaBola o AnimaImagen:
import bola.AnimaImagen;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Animacion extends MIDlet implements CommandListener{
    Display     d;
    AnimaBola   ab;
    AnimaImagen ai;
    Command opc, img;
    Form f = new Form("");
    public void CommandAction(Command c, Displayable dd)
        {
        
        }
    public void startApp() {
        d = Display.getDisplay(this);
        
        opc = new Command("Bola", Command.SCREEN, 1);
        img = new Command("Imagen", Command.SCREEN, 1);
        f.append("Animaciones :3");
        f.addCommand(opc);
        f.addCommand(img);
        f.setCommandListener(this);
        d.setCurrent(f);
    }
    
    public void pauseApp() {    }
    public void destroyApp(boolean unconditional) {    }

    public void commandAction(Command c, Displayable di) {
        if(c == opc)
            {
                ab = new AnimaBola();	// probar con AnimaBola()
                d.setCurrent(ab);	// para mostrar ab.       
            }
        if(c == img)
            {
                ai = new AnimaImagen();	// probando AnimaImagen()
                d.setCurrent(ai);	// para mostrar ai.
            }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}

////////////////////////////////////////////


////////////////////////////////////////////
