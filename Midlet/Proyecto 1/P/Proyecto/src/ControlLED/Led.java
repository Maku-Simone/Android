package ControlLED;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.bluetooth.*;
import java.io.*;
import javax.microedition.io.*;


public class Led extends MIDlet implements CommandListener, DiscoveryListener {

    private Display display;
    private Command conectar, desconectar, ok, comenzar,salir;
    private Form bienvenida;
    private List comandos;
    private StreamConnection con;
    private OutputStream outs;
    private InputStream ins;
    private LocalDevice localDevice = null;
    private DiscoveryAgent discoveryAgent = null;
    private ServiceRecord[] serviciosEncontrados = null;
    private String URL = "btspp://98D33381093F:1;authenticate=false;encrypt=false;master=false";


    public void startApp() 
		{
			display = Display.getDisplay(this);
			ok = new Command("OK", Command.OK, 1);
			comenzar = new Command("Comenzar", Command.OK, 1);
			salir = new Command("Salir", Command.EXIT, 1);

			bienvenida = new Form("Bienvenido");
			comandos = new List("Escoja una accion", List.EXCLUSIVE);

			bienvenida.addCommand(comenzar);
			bienvenida.setCommandListener(this);

			comandos.addCommand(ok);
			comandos.addCommand(salir);
			comandos.append("Encender LED", null);
			comandos.append("Apagar LED", null);
			comandos.setCommandListener(this);

			display.setCurrent(bienvenida);
			conectar();
		}


    public void commandAction(Command c, Displayable d) 
		{
			if (c == comenzar)
				{
					comenzar();
				}
			else if(c == salir)
				{
					  destroyApp(false);
					  notifyDestroyed();
				}
			else if (c == ok)
				{
					enviar();
				}
		}

    public void pauseApp() {    }

    public void destroyApp(boolean unconditional) {    }

    private void comenzar() 
		{
			try 
				{
					localDevice = LocalDevice.getLocalDevice();
					localDevice.setDiscoverable(DiscoveryAgent.GIAC);
					Display.getDisplay(this).setCurrent(comandos);
				}
			catch (BluetoothStateException e) 
				{
					e.printStackTrace();
					Alert alerta = new Alert("Error", "No se puede hacer uso de Bluetooth", null, AlertType.ERROR);
					alerta.setTimeout(Alert.FOREVER);
					Display.getDisplay(this).setCurrent(alerta);
				}
		}



    private  void conectar()
		{
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
		}

    private void enviar()
	{
       int i = comandos.getSelectedIndex();
       String comando_elegido = comandos.getString(i);
       if(comando_elegido == "Encender LED")
		   {
			   char com = 'a';
			   try 
				   {
					   outs.write((byte)com);
					   mostrarAlarma(null, comandos, 5);
				   }
			   catch(IOException e)
				   {
					   mostrarAlarma(e, comandos,2);
				   }
		   }
       else
		   {
			   char com = 'b';
			   try 
				{
					outs.write((byte)com);
					mostrarAlarma(null, comandos, 6);
				}
			   catch(IOException e)
				{
				   mostrarAlarma(e, comandos,2);
				}
		   }   
    }



    public void mostrarAlarma(Exception e, Screen s, int tipo) 
	{
        Alert alerta = null;
        if (tipo == 0) 
			{
				alerta = new Alert("Excepcion", "Se ha producido la excepcion " + e.getClass().getName(), null,	AlertType.ERROR);
			}
		else if (tipo == 1) 
			{
				alerta = new Alert("Info", "Se completo la busqueda de servicios", null, AlertType.INFO);
			}
		else if (tipo == 2) 
			{
				alerta = new Alert("ERROR", "No se pudo enviar", null, AlertType.ERROR);
			}
		else if (tipo == 3) 
			{
				alerta = new Alert("ERROR", "No se pudo establecer conexion" + e.getClass().getName(), null, AlertType.ERROR);
			}
		else if (tipo == 4)
			{
				alerta = new Alert("ERROR", "No se pudo desconectar" , null, AlertType.INFO);
			}
		else if (tipo == 5)
			{
				alerta = new Alert("INFO", "LED encendido :3" , null, AlertType.INFO);
			}
        else if (tipo == 6) 
			{
				alerta = new Alert("INFO", "LED Apagado :3" , null, AlertType.INFO);
			}        
        alerta.setTimeout(Alert.FOREVER);
        display.setCurrent(alerta, s);
    }

}


