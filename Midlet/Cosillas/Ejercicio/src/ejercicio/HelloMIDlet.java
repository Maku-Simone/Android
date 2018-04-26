/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Maku
 */
public class HelloMIDlet extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    Display d;
    Form f;
    TextField nume;
    Command ok;
    int op = 0;
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Form form;
    private StringItem stringItem;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
                    
    String label = command.getLabel();
    if(label.equals("OK"))
        {
            System.out.println("ok");
            f.deleteAll();
            if(op == 1)
                { 
                    datos();                
                }
            else
            {
                limpio();
            }
        }      
        
        
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|19-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|3|7-postCommandAction
        }//GEN-END:|7-commandAction|3|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|4|
//</editor-fold>//GEN-END:|7-commandAction|4|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
form = new Form("Welcome", new Item[]{getStringItem()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
stringItem = new StringItem("Hello", "Hello, World!");//GEN-LINE:|16-getter|1|16-postInit
            // write post-init user code here
}//GEN-BEGIN:|16-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|16-getter|2|

     public Display getDisplay() 
        {
            return Display.getDisplay(this);
        }

    public void exitMIDlet() 
        {
            switchDisplayable(null, null);
            destroyApp(true);
            notifyDestroyed();
        }
    
    
    
    
    
    public void startApp() 
    {                                
        limpio();
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {

    }

   
    public void destroyApp(boolean unconditional) {
        f.deleteAll();
        limpio();
    }
    
    //mis funciones :3
    
    private void limpio()
    {
        d = Display.getDisplay(this);
        f = new Form("\n");
        nume = new TextField("Numero: ", "", 30, TextField.ANY);
        ok = new Command("OK", Command.OK, 2);        
        
        f.append(nume);
        f.addCommand(ok);   
        f.setCommandListener(this);
        d.setCurrent(f);
        op = 1;
    }
    private void datos()
    {
        d = Display.getDisplay(this);
        int num = Integer.parseInt(nume.getString());        
             
        String cadena, maravill;
        cadena = "no está en la serie de Fibonacci";
        maravill = "No es maravilloso\n";
        f.append("El factorial es: "+ factorial(num) + "\n");
        if(Fibo(num))
            {
                cadena = "Está en la serie de Fibonacci";
            }
        if(maravilloso(num))
            {
                maravill = "Es maravilloso";                
            }                                 
        f.addCommand(ok);   
        f.setCommandListener(this);
        f.append(num + " " + cadena);
        f.append(num + " " + maravill);           
        d.setCurrent(f);
        op = 0;
    }
    
    
    private int factorial(int f)
    {
        int contador = f - 1;
        while(contador > 0)
            {
                f *= contador;
                contador--;
            }
        return f;
    }
    
    
    private boolean Fibo(int n)
        {
          int f[] = new int[n + 1]; //+1 por el mes 0
          for(int i = 0; i < n; i++)
            {
              if(i == 0)
                {
                  f[0] = 0;
                }
              else
                {
                  if(i == 1)
                    {
                      f[1] = 1;
                    }
                  else
                    {
                      f[i] = f[i-1] + f[i-2];
                    }
                }//else
              if(n == f[i])
                {
                    return true;
                }              
            }//for
          return false;
        }
    
    private boolean maravilloso(int m)
    {
        while(m > 1)
        {
            if(m%2 == 0)
                {
                    m /= 2;
                }   
            else
                {
                    m = 3*m + 1;
                }
            if(m == 1)
                {
                    return true;
                }
        } 
        return false;
    }
    
 
    
}
