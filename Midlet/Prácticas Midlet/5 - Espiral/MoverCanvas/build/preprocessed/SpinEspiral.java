import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class SpinEspiral extends MIDlet implements CommandListener {
    private Display	d;
    private Command	c; 
    private Canvas	k; 
    public SpinEspiral() {
	d = Display.getDisplay(this);
	k = new Canvas() {
            int x = getWidth() / 2 - 10;
            int y = getHeight()/ 2 - 10;
            int width = 1;
            int height = 1;
            int startAngle = 0;
            int arcAngle = 20;
            int depth = 1;          
   	      public void paint (Graphics g){
		  g.setColor(255, 255, 255);
                  g.fillRect(0, 0, getWidth(), getHeight());
		  g.setColor(0, 0, 0);
		  g.setStrokeStyle(Graphics.SOLID);
        for (int i = 0; i < 400; i++) {
         g.drawArc(x, y, width, height, startAngle, arcAngle);
         x = x - depth;
         y = y - depth;
         width += 2 * depth;
         height += 2 * depth;
         startAngle = startAngle - arcAngle;
        }  
		 // System.out.println("Pintando en: (" + x1 + ", " + y1 + ") a  (" + x2 + ", " + y2 + "), Pantalla (" +  getWidth() + ", " + getHeight() + ")");
	      }
	      protected void keyPressed(int keyCode) {
		  int arriba = getKeyCode(UP);
		  int abajo = getKeyCode(DOWN);
		  int izq = getKeyCode(LEFT);
		  int dcha = getKeyCode(RIGHT);
		  if (keyCode == arriba)     { 
                      x = getWidth() / 2 - 10;
                      y = getHeight()/ 2 - 10;
                      width = 1;
                      height = 1;
                      depth = 1; 
                      startAngle-=1;
                      repaint(); 
                  }
		//  else if (keyCode == abajo) { if(y1<getWidth() && y2<getWidth()) y1+=1; y2+=1; repaint();}
		//  else if (keyCode == izq  ) { if(x1>0 && x1>0) x1-=1; x2-=1; repaint();}
		//  else if (keyCode == dcha ) { if(x1<getHeight() && x1<getHeight()) x1+=1; x2+=1; repaint();}
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
