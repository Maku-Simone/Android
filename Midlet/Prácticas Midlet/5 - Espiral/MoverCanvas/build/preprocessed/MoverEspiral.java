import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MoverEspiral extends MIDlet implements CommandListener {
    private Display	d;
    private Command	c; 
    private Canvas	k; 
    public MoverEspiral() {
	d = Display.getDisplay(this);
	k = new Canvas() {
            int x = getWidth() / 2 - 10;
            int y = getHeight()/ 2 - 10;
            int width = 20;
            int height = 20;
            int startAngle = 0;
            int arcAngle = 180;
            int depth = 10;          
   	      public void paint (Graphics g){
                  System.out.println("Pintando en: (" + x + ", " + y +"), Pantalla (" +  getWidth() + ", " + getHeight() + ")");
		  g.setColor(255, 255, 255);
                  g.fillRect(0, 0, getWidth(), getHeight());
		  g.setColor(0, 0, 0);
		  g.setStrokeStyle(Graphics.SOLID);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                //   g.drawArc(x + 10, y + 10, width, height, startAngle + 10, -arcAngle);
                //  x = x - 5;
                y = y - depth;
                width = width + 2 * depth;
                height = height + 2 * depth;
                g.drawArc(x, y, width, height, startAngle, -arcAngle);
            } else {
                //  g.drawArc(x + 10, y + 10, width, height, startAngle + 10, arcAngle);
                x = x - 2 * depth;
                y = y - depth;
                width = width + 2 * depth;
                height = height + 2 * depth;
                g.drawArc(x, y, width, height, startAngle, arcAngle);
            }
        }  
		 // System.out.println("Pintando en: (" + x1 + ", " + y1 + ") a  (" + x2 + ", " + y2 + "), Pantalla (" +  getWidth() + ", " + getHeight() + ")");
	      }
	      protected void keyPressed(int keyCode) {
		  int arriba = getKeyCode(UP);
		  int abajo = getKeyCode(DOWN);
		  int izq = getKeyCode(LEFT);
		  int dcha = getKeyCode(RIGHT);
		  if (keyCode == arriba)     { if(y>0) y-=0.1; }
		  else if (keyCode == abajo) { if(y<getWidth()) y+=0.1; }
		  else if (keyCode == izq  ) { if(x>0) x-=0.1;  }
		  else if (keyCode == dcha ) { if(x<getHeight()) x+=0.1; }
                  repaint();
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
