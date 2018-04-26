//import javax.microedition.midlet.*;
/*import javax.microedition.lcdui.*;
public class CubitoME extends Canvas{
	int centerX, centerY, maxX, maxY, minMaxXY;
	Dimension dim;
	Obj obj = new Obj();
	public CubitoME(){
		dim = getSize();
		centerX = maxX/2;
		centerY = maxY/2;
		addMouseMotionListener(this);
	}
	int iX(float x){
		return Math.round(centerX + x);
	}
	int iY(float y){
		return Math.round(centerY - y);
	}
	void line(Graphics g, int i, int j){
		Point2D p = obj.vScr[i], q = obj.vScr[j];
		g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
	}
	public void paint(Graphics g){
		dim = getSize();
		maxX = dim.width-1; maxY = dim.height-1; minMaxXY=Math.min(maxX, maxY);
		centerX = maxX/2;
		centerY = maxY/2;
		obj.d = obj.rho*minMaxXY/obj.objSize;
		obj.eyeAndScreen();
		line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
		line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
		line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
	}
	public void mouseDragged(MouseEvent e){
		obj.theta	= (float) getSize().width/e.getX();
		obj.phi		= (float) getSize().height/e.getY();
		obj.rho		= (obj.phi/obj.theta)*getSize().height;
		centerX		= e.getX();
		centerY		= e.getY();
		repaint();
	}
}
class Obj{	// Posee los datos del objeto 3D
	float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
	Point3D [] w;	// coordenadas universales
	Point2D [] vScr; // coordenadas de la pantalla
	Obj(){
		w	= new Point3D[8];
		vScr	= new Point2D[8];
		w[0]	= new Point3D(1, -1, -1); // desde la base
		w[1]	= new Point3D(1, 1, -1);
		w[2]	= new Point3D(-1, 1, -1);
		w[3]	= new Point3D(-1, -1, -1);
		w[4]	= new Point3D(1, -1, 1);
		w[5]	= new Point3D(1, 1, 1);
		w[6]	= new Point3D(-1, 1, 1);
		w[7]	= new Point3D(-1, -1, 1);
		objSize = (float) Math.sqrt(12F); // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
		rho	= 5*objSize;		// para cambiar la perspectiva
	}
	void initPersp(){
		float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
		v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
		v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
		v32 = sinph; v33 = cosph; v43 = -rho;
	}
	void eyeAndScreen(){
		initPersp();
		for(int i=0; i<8; i++){
			Point3D p = w[i];
			float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
			vScr[i] = new Point2D(-d*x/z, -d*y/z);
		}
	}
}
class Point2D{
	float x, y;
	Point2D(float x, float y){
		this.x = x;
		this.y = y;
	}
}
class Point3D{
	float x, y, z;
	Point3D(double x, double y, double z){
		this.x = (float) x;
		this.y = (float) y;
		this.z = (float) z;
	}
}


*/

///////////////////////////////////////////////////////////////////////////////////

import javax.microedition.lcdui.*;//import java.util.*; //import java.awt.*;
public class CubitoME extends Canvas implements CommandListener{
    int         centerX, centerY, maxX, maxY, minMaxXY;
    Dimension   dim;
    Obje        obj;
   // D3          d3;
    public CubitoME(){
        dim = new Dimension(getWidth(), getHeight());
     //   this.d3 = d3;
        obj     = new Obje();
        dim.tam = dim.getSize();
        centerX = maxX/2;
        centerY = maxY/2;
    }
    int iX(float x){
        return (int) (centerX + x);
    }
    int iY(float y){
        return (int) (centerY - y);
    }
    void line(Graphics g, int i, int j){
        Point2Di p = obj.vScr[i], q = obj.vScr[j];
        g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }
    public void paint(Graphics g){
        dim.tam = dim.getSize();
        maxX = dim.getWidth()-1; maxY = dim.getHeight()-1; minMaxXY=Math.min(maxX, maxY);
        centerX = maxX/2;
        centerY = maxY/2;
        obj.d = obj.rho*minMaxXY/obj.objSize;
        obj.eyeAndScreen();
        line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
        line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
        line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
    	}
    /*protected void keyPressed(int keyCode){
        switch(getGameAction(keyCode)){
            case DOWN:   { if((p.y+20)<dim.getHeight()) p.y = p.y+1; break; }
            case LEFT:   { if(p.x>0) p.x = p.x-1; break; }
            case UP:     { if(p.y>0) p.y = p.y-1; break; }
            case RIGHT:  { if((p.x+20) < dim.getWidth()) p.x = p.x+1; break; }
        }
        this.repaint();
    }*/
    public void commandAction(Command co, Displayable di)
    {
    }
	/*public void mouseDragged(MouseEvent e){
		obj.theta   = (float) getSize().width/e.getX();
		obj.phi     = (float) getSize().height/e.getY();
		obj.rho     = (obj.phi/obj.theta)*getSize().height;
		centerX     = e.getX();
		centerY     = e.getY();
		repaint();*/
	}
//}
class Obje{	// Posee los datos del objeto 3D
	float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
	Point3Di [] w;	// coordenadas universales
	Point2Di [] vScr; // coordenadas de la pantalla
	Obje(){
		w	= new Point3Di[8];
		vScr	= new Point2Di[8];
		w[0]	= new Point3Di(1, -1, -1); // desde la base
		w[1]	= new Point3Di(1, 1, -1);
		w[2]	= new Point3Di(-1, 1, -1);
		w[3]	= new Point3Di(-1, -1, -1);
		w[4]	= new Point3Di(1, -1, 1);
		w[5]	= new Point3Di(1, 1, 1);
		w[6]	= new Point3Di(-1, 1, 1);
		w[7]	= new Point3Di(-1, -1, 1);
		objSize = (float) Math.sqrt(12F); // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
		rho	= 5*objSize;		// para cambiar la perspectiva
	}
	void initPersp(){
		float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
		v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
		v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
		v32 = sinph; v33 = cosph; v43 = -rho;
	}
	void eyeAndScreen(){
		initPersp();
		for(int i=0; i<8; i++){
			Point3Di p = w[i];
			float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
			vScr[i] = new Point2Di(-d*x/z, -d*y/z);
		}
	}
}
class Point2Di{
	float x, y;
	Point2Di(float x, float y){
		this.x = x;
		this.y = y;
	}
}
class Point3Di{
	float x, y, z;
	Point3Di(double x, double y, double z){
		this.x = (float) x;
		this.y = (float) y;
		this.z = (float) z;
	}
}
class Dimension{
    int ancho, alto, tam;
    public Dimension(int w, int h){
        this.ancho = w;
        this.alto  = h;
    }
    int getWidth(){
        return ancho;
    }
    int getHeight(){
        return alto;
    }
    int getSize(){
        return ancho*alto;
    }
}


/*
    Objeto      obj = new Objeto();
    int         centerX, centerY;
    D3          d3;
    Point3Di    p;
    public CubitoME2(D3 d3){
        this.d3 = d3;
    }
    public void line(Graphics g, int i, int j){
        Point2Di p = obj.vScr[i];
        Point2Di q = obj.vScr[j];
        g.setColor(255, 255, 255);
        g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }
    public void paint(Graphics g){
        int maxX = getWidth() - 1, maxY = getHeight() - 1, minMaxXY = Math.min(maxX, maxY);
        centerX = maxX/2; centerY = maxY/2;
        obj.d = obj.rho * minMaxXY / obj.objSize;
        obj.perspectiva();
        line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); //aristas horizontales inferiores
        line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); //aristas horizontales superiores
        line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); //aristas verticales
    }
    protected void keyPressed(int keyCode){
        switch(getGameAction(keyCode)){
            case DOWN:   { if((p.y+20)<getHeight()) p.y = p.y+1; break; }
            case LEFT:   { if(p.x>0) p.x = p.x-1; break; }
            case UP:     { if(p.y>0) p.y = p.y-1; break; }
            case RIGHT:  { if((p.x+20) < getWidth()) p.x = p.x+1; break; }
        }
        this.repaint();
    }
    public void commandAction(Command co, Displayable di){
    }
    int iX(float x){
        return (int)(centerX + x);
    }
    int iY(float y){
        return (int)(centerY - y);
    }
}
class Objeto{	// Posee los datos del objeto 3D
    float rho, theta = 0.3F, phi = 1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; //Elementos de la matriz V
    Point3Di [] w;	//Coordenadas universales
    Point2Di [] vScr;	//Coordenadas de la pantalla
    Objeto(){
        w =  new Point3Di[8];
        vScr = new Point2Di[8];
        w[0] = new Point3Di( 1, -1, -1);	// Desde la base
        w[1] = new Point3Di( 1,  1, -1);
        w[2] = new Point3Di(-1,  1, -1);
        w[3] = new Point3Di(-1, -1, -1);
        w[4] = new Point3Di( 1, -1,  1);	// Desde la tapa
        w[5] = new Point3Di( 1,  1,  1);
        w[6] = new Point3Di(-1,  1,  1);
        w[7] = new Point3Di(-1, -1,  1);
        objSize = (float) Math.sqrt(12F);	//= sqrt(2*2 + 2*2 + 2*2) = Distancia entre dos vertices opuestos
        rho = 2 * objSize;			//Para efecto de una perspectiva razonable
    }
    public void initPersp(){
        float costh = (float) Math.cos(theta), sinth = (float) Math.sin(theta), cosph = (float) Math.cos(phi), sinph = (float) Math.sin(phi);
        v11 = -sinth;   v12 = -cosph*costh; v13 = sinph*costh;
        v21 = costh;    v22 = -cosph*sinth; v23 = sinph*sinth;
        v43 = -rho;     v32 = sinph;        v33 = cosph;
    }
    public void perspectiva(){
        initPersp();
        for(int i = 0; i < 8; i++){
            Point3Di p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2Di(-d*x/z, -d*y/z);
        }
    }
}
class Point2Di{
    float x, y;
    Point2Di(float x, float y){
        this.x = x;
        this.y = y;
    }
}
class Point3Di{
    float x, y, z;
    Point3Di(double x, double y, double z){
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }
}
 * *****************************************************************************
*/
/*
class Perspectiva extends Canvas implements MouseMotionListener{
	int centerX, centerY, maxX, maxY, minMaxXY;
	Dimension dim;
	Obj obj = new Obj();
	public Perspectiva(){
		dim = getSize();
		centerX = maxX/2;
		centerY = maxY/2;
		addMouseMotionListener(this);
	}
	void line(Graphics g, int i, int j){
		Point2D p = obj.vScr[i], q = obj.vScr[j];
		g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
	}
	public void paint(Graphics g){
		dim = getSize();
		maxX = dim.width-1; maxY = dim.height-1; minMaxXY=Math.min(maxX, maxY);
		centerX = maxX/2;
		centerY = maxY/2;
		obj.d = obj.rho*minMaxXY/obj.objSize;
		obj.eyeAndScreen();
		line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
		line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
		line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
	}
	public void mouseDragged(MouseEvent e){
		obj.theta	= (float) getSize().width/e.getX();
		obj.phi		= (float) getSize().height/e.getY();
		obj.rho		= (obj.phi/obj.theta)*getSize().height;
		centerX		= e.getX();
		centerY		= e.getY();
		repaint();
	}
}
 */