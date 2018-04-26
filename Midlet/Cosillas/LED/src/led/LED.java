package led;

import javax.microedition.midlet.*;
import java.io.*;
import javax.bluetooth.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;


public class LED extends MIDlet implements CommandListener, Runnable {

    private Display display;
    private Command ok, comenzar,salir;
    private TextField  tf = new TextField("Mensaje:", "", 40, TextField.ANY);
    private Form bienvenida, f;
    private List comandos;
    private StreamConnection con;
    private OutputStream outs;
    private InputStream ins;
    private LocalDevice localDevice = null;
    private DiscoveryAgent discoveryAgent = null;
    private ServiceRecord[] serviciosEncontrados = null;
    private String URL = "btspp://98D33381093F:1;authenticate=false;encrypt=false;master=false";
    private Thread t;

    public void startApp() {
        display = Display.getDisplay(this);                
        comenzar = new Command("Comenzar", Command.OK, 1);
        salir = new Command("Salir", Command.EXIT, 1);

        bienvenida = new Form("Bienvenido");
        bienvenida.addCommand(comenzar);
        bienvenida.setCommandListener(this);             
        display.setCurrent(bienvenida);        
    }

    
    public void run() {
        try {
            f = new Form("Cliente: Conectado al servidor");
            f.append(tf);
            f.setCommandListener(this);
            display = Display.getDisplay(this);
            display.setCurrent(f);
            try
               {
                    con = (StreamConnection) Connector.open(URL);
                    outs = con.openOutputStream();
                    ins = con.openInputStream();
               }
            catch(IOException e)
                {
                    mostrarAlarma(e, comandos, 3);
                }
            while (con != null) {
                byte buffer[] = new byte[10];
                ins.read(buffer);
                f.insert(1, new StringItem("\nRPM: ", new String(buffer)));
                display = Display.getDisplay(this);
                display.setCurrent(f);
            }
        } catch (IOException e) {
            f.append("Error : " + e);
        }
    }    

    public void commandAction(Command c, Displayable d) {
        if (c == comenzar){
            comenzar();
        }  else if(c == salir){
              destroyApp(false);
              notifyDestroyed();
        } 

    }


    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    private void comenzar() {
        try {
            localDevice = LocalDevice.getLocalDevice();
            localDevice.setDiscoverable(DiscoveryAgent.GIAC);
            t = new Thread(this);
            t.start();
        } catch (BluetoothStateException e) {
            e.printStackTrace();
            Alert alerta = new Alert("Error", "No se puede hacer uso de Bluetooth", null, AlertType.ERROR);
            alerta.setTimeout(Alert.FOREVER);
            Display.getDisplay(this).setCurrent(alerta);
        }
    }


    public void mostrarAlarma(Exception e, Screen s, int tipo) {
        Alert alerta = null;
        if (tipo == 0) {
            alerta = new Alert("Excepcion", "Se ha producido la excepcion " + e.getClass().getName(), null,
                    AlertType.ERROR);
        } else if (tipo == 1) {
            alerta = new Alert("Info", "Se completo la busqueda de servicios", null, AlertType.INFO);
        } else if (tipo == 2) {
            alerta = new Alert("ERROR", "No se pudo enviar", null, AlertType.ERROR);
        } else if (tipo == 3) {
            alerta = new Alert("ERROR", "No se pudo establecer conexion" + e.getClass().getName(), null, AlertType.ERROR);
        } else if (tipo == 4) {
            alerta = new Alert("ERROR", "No se pudo desconectar" , null, AlertType.INFO);
        }  else if (tipo == 5) {
            alerta = new Alert("INFO", "LED encendido :3" , null, AlertType.INFO);
        }
          else if (tipo == 6) {
            alerta = new Alert("INFO", "LED Apagado :3" , null, AlertType.INFO);
        }        
        alerta.setTimeout(Alert.FOREVER);
        display.setCurrent(alerta, s);
    }

}


