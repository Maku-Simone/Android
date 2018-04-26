import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MoverLinea extends MIDlet implements CommandListener {
    private Display	d;
    private Command	c; 
    private Canvas	k; 
    public MoverLinea() {
	d = Display.getDisplay(this);
	k = new Canvas() {
	      private double x1 = 0;
	      private double y1 = 0;
              private double angle = ((30*Math.PI) / 180); 
	      private double x2 = 50*Math.sin(angle);
	      private double y2 = 50*Math.cos(angle);
   	      public void paint (Graphics g){
		  g.setColor(255, 255, 255);
                  g.fillRect(0, 0, getWidth(), getHeight());
		  g.setColor(0, 0, 0);
		  g.setStrokeStyle(Graphics.SOLID);
		  g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
		  System.out.println("Pintando en: (" + x1 + ", " + y1 + ") a  (" + x2 + ", " + y2 + "), Pantalla (" +  getWidth() + ", " + getHeight() + ")");
	      }
	      protected void keyPressed(int keyCode) {
		  int arriba = getKeyCode(UP);
		  int abajo = getKeyCode(DOWN);
		  int izq = getKeyCode(LEFT);
		  int dcha = getKeyCode(RIGHT);
		  if (keyCode == arriba)     { if(y1>0 && y2>0) y1-=1; y2-=1; repaint(); }
		  else if (keyCode == abajo) { if(y1<getWidth() && y2<getWidth()) y1+=1; y2+=1; repaint();}
		  else if (keyCode == izq  ) { if(x1>0 && x1>0) x1-=1; x2-=1; repaint();}
		  else if (keyCode == dcha ) { if(x1<getHeight() && x1<getHeight()) x1+=1; x2+=1; repaint();}
	      }
        };
	c = new Command("Salir", Command.EXIT, 3);
	k.addCommand(c);
	k.setCommandListener(this);
    }
    protected void startApp(  ) {
        d.setCurrent(k);
    }
    protected void pauseApp(  ) {    }
    protected void destroyApp(boolean incondicional) {    }
    public void commandAction(Command co, Displayable d) {
	if (co==c) {
	   destroyApp(true);
	   notifyDestroyed();
        }
   } 
}
