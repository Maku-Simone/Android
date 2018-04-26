import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class HelloMIDlet extends MIDlet implements CommandListener {
    RMSOps rmso =new RMSOps();
    private boolean midletPaused = false;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command Salir;
    private Command Nuevo;
    private Command Ver;
    private Command Borrar;
    private Command Modificar;
    private Command exitCommand1;
    private Command Agregar;
    private Command Atras;
    private Command okCommand;
    private Command exitCommand2;
    private Command Atras1;
    private Command exitCommand3;
    private Command Guardar1;
    private Command exitCommand4;
    private Command Guardar;
    private Command Guardar2;
    private Form form;
    private ImageItem imageItem;
    private Form Ver1;
    private StringItem mostrar1;
    private Form Borrar1;
    private TextField indiceborrar;
    private StringItem mostrar2;
    private Form Agregar1;
    private TextField nom;
    private TextField ape;
    private TextField tel;
    private TextField cel;
    private TextField dom;
    private Form Modificar1;
    private TextField textField1;
    private StringItem stringItem;
    private Alert alert;
    private Image image1;
//</editor-fold>//GEN-END:|fields|0|

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
if (displayable == Agregar1) {//GEN-BEGIN:|7-commandAction|1|65-preAction
            if (command == Guardar1) {//GEN-END:|7-commandAction|1|65-preAction
               // write pre-action user code here
               rmso.abrir("BASE1");
               try{
                   ByteArrayOutputStream baos=new ByteArrayOutputStream();
                   DataOutputStream dos=new DataOutputStream(baos);
                   dos.writeUTF(nom.getString());
                   dos.writeUTF(ape.getString());
                   dos.writeUTF(tel.getString());
                   dos.writeUTF(cel.getString());
                   dos.writeUTF(dom.getString());
                   dos.close();
                   rmso.adicionarRegistro(baos);
                   //rmso.cerrar();
               }catch(IOException ioe){
                   ioe.printStackTrace();
               }
            nom.setString("");
            ape.setString("");
            tel.setString("");
            cel.setString("");
            dom.setString("");
                switchDisplayable(getAlert(), getForm());//GEN-LINE:|7-commandAction|2|65-postAction
                // write post-action user code here
} else if (command == exitCommand3) {//GEN-LINE:|7-commandAction|3|63-preAction
                // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|4|63-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|76-preAction
} else if (displayable == Borrar1) {
    if (command == Guardar) {//GEN-END:|7-commandAction|5|76-preAction
        // write pre-action user code here
        int i;
        String indice="";
        rmso.abrir("BASE1");
        indice=indiceborrar.getString();
        i=Integer.parseInt(indice);
        rmso.eliminarRecordStore(i);
        rmso.cerrar();
        switchDisplayable(getAlert(), getForm());//GEN-LINE:|7-commandAction|6|76-postAction
        // write post-action user code here
} else if (command == exitCommand2) {//GEN-LINE:|7-commandAction|7|50-preAction
        // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|8|50-postAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|9|81-preAction
} else if (displayable == Modificar1) {
    if (command == Guardar2) {//GEN-END:|7-commandAction|9|81-preAction
        // write pre-action user code here
switchDisplayable(getAlert(), getModificar1());//GEN-LINE:|7-commandAction|10|81-postAction
        // write post-action user code here
} else if (command == exitCommand4) {//GEN-LINE:|7-commandAction|11|72-preAction
        // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|12|72-postAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|13|38-preAction
} else if (displayable == Ver1) {
    if (command == exitCommand1) {//GEN-END:|7-commandAction|13|38-preAction
 // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|14|38-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|15|32-preAction
} else if (displayable == form) {
    if (command == Borrar) {//GEN-END:|7-commandAction|15|32-preAction
 // write pre-action user code here
            
 
        switchDisplayable(null, getBorrar1());//GEN-LINE:|7-commandAction|16|32-postAction
 // write post-action user code here
           rmso.abrir("BASE1");
            String lista="";
            lista=rmso.listarRegistro();
            mostrar2.setLabel(lista);
            System.out.println("Registros: "+lista);
            rmso.cerrar();
    } else if (command == Modificar) {//GEN-LINE:|7-commandAction|17|34-preAction
                // write pre-action user code here
switchDisplayable(null, getModificar1());//GEN-LINE:|7-commandAction|18|34-postAction
                // write post-action user code here
} else if (command == Nuevo) {//GEN-LINE:|7-commandAction|19|28-preAction
                // write pre-action user code here
switchDisplayable(null, getAgregar1());//GEN-LINE:|7-commandAction|20|28-postAction
                // write post-action user code here
} else if (command == Salir) {//GEN-LINE:|7-commandAction|21|19-preAction
                // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|22|19-postAction
                // write post-action user code here
} else if (command == Ver) {//GEN-LINE:|7-commandAction|23|30-preAction
                // write pre-action user code here           
switchDisplayable(null, getVer1());//GEN-LINE:|7-commandAction|24|30-postAction
 // write post-action user code here
            rmso.abrir("BASE1");
            String lista="";
            lista=rmso.listarRegistro();
            mostrar1.setLabel(lista);
            System.out.println("Registros: "+lista);
            rmso.cerrar();
            
            }//GEN-BEGIN:|7-commandAction|25|7-postCommandAction
        }//GEN-END:|7-commandAction|25|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|26|
//</editor-fold>//GEN-END:|7-commandAction|26|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Salir ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of Salir component.
     *
     * @return the initialized component instance
     */
    public Command getSalir() {
        if (Salir == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
Salir = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return Salir;
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
form = new Form("", new Item[]{getImageItem()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getSalir());
            form.addCommand(getNuevo());
            form.addCommand(getVer());
            form.addCommand(getBorrar());
            form.addCommand(getModificar());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Nuevo ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initialized instance of Nuevo component.
     *
     * @return the initialized component instance
     */
    public Command getNuevo() {
        if (Nuevo == null) {
//GEN-END:|27-getter|0|27-preInit
 // write pre-init user code here
Nuevo = new Command("Nuevo", Command.OK, 0);//GEN-LINE:|27-getter|1|27-postInit
 // write post-init user code here
}//GEN-BEGIN:|27-getter|2|
        return Nuevo;
    }
//</editor-fold>//GEN-END:|27-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Ver ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initialized instance of Ver component.
     *
     * @return the initialized component instance
     */
    public Command getVer() {
        if (Ver == null) {
//GEN-END:|29-getter|0|29-preInit
 // write pre-init user code here
Ver = new Command("Ver", Command.OK, 0);//GEN-LINE:|29-getter|1|29-postInit
 // write post-init user code here
}//GEN-BEGIN:|29-getter|2|
        return Ver;
    }
//</editor-fold>//GEN-END:|29-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Borrar ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of Borrar component.
     *
     * @return the initialized component instance
     */
    public Command getBorrar() {
        if (Borrar == null) {
//GEN-END:|31-getter|0|31-preInit
 // write pre-init user code here
Borrar = new Command("Borrar", Command.OK, 0);//GEN-LINE:|31-getter|1|31-postInit
 // write post-init user code here
}//GEN-BEGIN:|31-getter|2|
        return Borrar;
    }
//</editor-fold>//GEN-END:|31-getter|2|









//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Ver1 ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of Ver1 component.
     *
     * @return the initialized component instance
     */
    public Form getVer1() {
        if (Ver1 == null) {
//GEN-END:|22-getter|0|22-preInit
 // write pre-init user code here
Ver1 = new Form("Ver", new Item[]{getMostrar1()});//GEN-BEGIN:|22-getter|1|22-postInit
            Ver1.addCommand(getExitCommand1());
            Ver1.setCommandListener(this);//GEN-END:|22-getter|1|22-postInit
 // write post-init user code here
}//GEN-BEGIN:|22-getter|2|
        return Ver1;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Modificar ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initialized instance of Modificar component.
     *
     * @return the initialized component instance
     */
    public Command getModificar() {
        if (Modificar == null) {
//GEN-END:|33-getter|0|33-preInit
 // write pre-init user code here
Modificar = new Command("Modificar", Command.OK, 0);//GEN-LINE:|33-getter|1|33-postInit
 // write post-init user code here
}//GEN-BEGIN:|33-getter|2|
        return Modificar;
    }
//</editor-fold>//GEN-END:|33-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {
//GEN-END:|37-getter|0|37-preInit
 // write pre-init user code here
exitCommand1 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|37-getter|1|37-postInit
 // write post-init user code here
}//GEN-BEGIN:|37-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|37-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Agregar ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initialized instance of Agregar component.
     *
     * @return the initialized component instance
     */
    public Command getAgregar() {
        if (Agregar == null) {
//GEN-END:|39-getter|0|39-preInit
 // write pre-init user code here
Agregar = new Command("Ok", Command.OK, 0);//GEN-LINE:|39-getter|1|39-postInit
 // write post-init user code here
}//GEN-BEGIN:|39-getter|2|
        return Agregar;
    }
//</editor-fold>//GEN-END:|39-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Atras ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initialized instance of Atras component.
     *
     * @return the initialized component instance
     */
    public Command getAtras() {
        if (Atras == null) {
//GEN-END:|41-getter|0|41-preInit
 // write pre-init user code here
Atras = new Command("Ok", Command.OK, 0);//GEN-LINE:|41-getter|1|41-postInit
 // write post-init user code here
}//GEN-BEGIN:|41-getter|2|
        return Atras;
    }
//</editor-fold>//GEN-END:|41-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|43-getter|0|43-preInit
 // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|43-getter|1|43-postInit
 // write post-init user code here
}//GEN-BEGIN:|43-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|43-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Borrar1 ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initialized instance of Borrar1 component.
     *
     * @return the initialized component instance
     */
    public Form getBorrar1() {
        if (Borrar1 == null) {
//GEN-END:|45-getter|0|45-preInit
 // write pre-init user code here
Borrar1 = new Form("Borrar", new Item[]{getIndiceborrar(), getMostrar2()});//GEN-BEGIN:|45-getter|1|45-postInit
            Borrar1.addCommand(getExitCommand2());
            Borrar1.addCommand(getGuardar());
            Borrar1.setCommandListener(this);//GEN-END:|45-getter|1|45-postInit
 // write post-init user code here
}//GEN-BEGIN:|45-getter|2|
        return Borrar1;
    }
//</editor-fold>//GEN-END:|45-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: indiceborrar ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initialized instance of indiceborrar component.
     *
     * @return the initialized component instance
     */
    public TextField getIndiceborrar() {
        if (indiceborrar == null) {
//GEN-END:|47-getter|0|47-preInit
 // write pre-init user code here
indiceborrar = new TextField("Ingrese el indice del registro:", "", 32, TextField.ANY);//GEN-LINE:|47-getter|1|47-postInit
 // write post-init user code here
}//GEN-BEGIN:|47-getter|2|
        return indiceborrar;
    }
//</editor-fold>//GEN-END:|47-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initialized instance of exitCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {
//GEN-END:|49-getter|0|49-preInit
 // write pre-init user code here
exitCommand2 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|49-getter|1|49-postInit
 // write post-init user code here
}//GEN-BEGIN:|49-getter|2|
        return exitCommand2;
    }
//</editor-fold>//GEN-END:|49-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Atras1 ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initialized instance of Atras1 component.
     *
     * @return the initialized component instance
     */
    public Command getAtras1() {
        if (Atras1 == null) {
//GEN-END:|51-getter|0|51-preInit
 // write pre-init user code here
Atras1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|51-getter|1|51-postInit
 // write post-init user code here
}//GEN-BEGIN:|51-getter|2|
        return Atras1;
    }
//</editor-fold>//GEN-END:|51-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand3 ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initialized instance of exitCommand3 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand3() {
        if (exitCommand3 == null) {
//GEN-END:|62-getter|0|62-preInit
 // write pre-init user code here
exitCommand3 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|62-getter|1|62-postInit
 // write post-init user code here
}//GEN-BEGIN:|62-getter|2|
        return exitCommand3;
    }
//</editor-fold>//GEN-END:|62-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Guardar1 ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initialized instance of Guardar1 component.
     *
     * @return the initialized component instance
     */
    public Command getGuardar1() {
        if (Guardar1 == null) {
//GEN-END:|64-getter|0|64-preInit
 // write pre-init user code here
Guardar1 = new Command("Guardar", Command.OK, 0);//GEN-LINE:|64-getter|1|64-postInit
 // write post-init user code here
}//GEN-BEGIN:|64-getter|2|
        return Guardar1;
    }
//</editor-fold>//GEN-END:|64-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initialized instance of imageItem component.
     *
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {
//GEN-END:|60-getter|0|60-preInit
 // write pre-init user code here
imageItem = new ImageItem("Agenda", getImage1(), ImageItem.LAYOUT_DEFAULT, "<Missing Image>");//GEN-LINE:|60-getter|1|60-postInit
 // write post-init user code here
}//GEN-BEGIN:|60-getter|2|
        return imageItem;
    }
//</editor-fold>//GEN-END:|60-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Agregar1 ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initialized instance of Agregar1 component.
     *
     * @return the initialized component instance
     */
    public Form getAgregar1() {
        if (Agregar1 == null) {
//GEN-END:|53-getter|0|53-preInit
 // write pre-init user code here
Agregar1 = new Form("Agregar", new Item[]{getNom(), getApe(), getTel(), getCel(), getDom()});//GEN-BEGIN:|53-getter|1|53-postInit
            Agregar1.addCommand(getExitCommand3());
            Agregar1.addCommand(getGuardar1());
            Agregar1.setCommandListener(this);//GEN-END:|53-getter|1|53-postInit
 // write post-init user code here
}//GEN-BEGIN:|53-getter|2|
        return Agregar1;
    }
//</editor-fold>//GEN-END:|53-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: nom ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initialized instance of nom component.
     *
     * @return the initialized component instance
     */
    public TextField getNom() {
        if (nom == null) {
//GEN-END:|55-getter|0|55-preInit
 // write pre-init user code here
nom = new TextField("Nombre:", "", 32, TextField.ANY);//GEN-LINE:|55-getter|1|55-postInit
 // write post-init user code here
}//GEN-BEGIN:|55-getter|2|
        return nom;
    }
//</editor-fold>//GEN-END:|55-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: ape ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initialized instance of ape component.
     *
     * @return the initialized component instance
     */
    public TextField getApe() {
        if (ape == null) {
//GEN-END:|56-getter|0|56-preInit
 // write pre-init user code here
ape = new TextField("Apellido:", "", 32, TextField.ANY);//GEN-LINE:|56-getter|1|56-postInit
 // write post-init user code here
}//GEN-BEGIN:|56-getter|2|
        return ape;
    }
//</editor-fold>//GEN-END:|56-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: tel ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initialized instance of tel component.
     *
     * @return the initialized component instance
     */
    public TextField getTel() {
        if (tel == null) {
//GEN-END:|57-getter|0|57-preInit
 // write pre-init user code here
tel = new TextField("Telefono", "", 32, TextField.ANY);//GEN-LINE:|57-getter|1|57-postInit
 // write post-init user code here
}//GEN-BEGIN:|57-getter|2|
        return tel;
    }
//</editor-fold>//GEN-END:|57-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cel ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initialized instance of cel component.
     *
     * @return the initialized component instance
     */
    public TextField getCel() {
        if (cel == null) {
//GEN-END:|58-getter|0|58-preInit
 // write pre-init user code here
cel = new TextField("Celular:", "", 32, TextField.ANY);//GEN-LINE:|58-getter|1|58-postInit
 // write post-init user code here
}//GEN-BEGIN:|58-getter|2|
        return cel;
    }
//</editor-fold>//GEN-END:|58-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: dom ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initialized instance of dom component.
     *
     * @return the initialized component instance
     */
    public TextField getDom() {
        if (dom == null) {
//GEN-END:|59-getter|0|59-preInit
 // write pre-init user code here
dom = new TextField("Domicilio:", "", 32, TextField.ANY);//GEN-LINE:|59-getter|1|59-postInit
 // write post-init user code here
}//GEN-BEGIN:|59-getter|2|
        return dom;
    }
//</editor-fold>//GEN-END:|59-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand4 ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initialized instance of exitCommand4 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand4() {
        if (exitCommand4 == null) {
//GEN-END:|71-getter|0|71-preInit
 // write pre-init user code here
exitCommand4 = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|71-getter|1|71-postInit
 // write post-init user code here
}//GEN-BEGIN:|71-getter|2|
        return exitCommand4;
    }
//</editor-fold>//GEN-END:|71-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Modificar1 ">//GEN-BEGIN:|68-getter|0|68-preInit
    /**
     * Returns an initialized instance of Modificar1 component.
     *
     * @return the initialized component instance
     */
    public Form getModificar1() {
        if (Modificar1 == null) {
//GEN-END:|68-getter|0|68-preInit
 // write pre-init user code here
Modificar1 = new Form("Modificar", new Item[]{getTextField1(), getStringItem()});//GEN-BEGIN:|68-getter|1|68-postInit
            Modificar1.addCommand(getExitCommand4());
            Modificar1.addCommand(getGuardar2());
            Modificar1.setCommandListener(this);//GEN-END:|68-getter|1|68-postInit
 // write post-init user code here
}//GEN-BEGIN:|68-getter|2|
        return Modificar1;
    }
//</editor-fold>//GEN-END:|68-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Guardar ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initialized instance of Guardar component.
     *
     * @return the initialized component instance
     */
    public Command getGuardar() {
        if (Guardar == null) {
//GEN-END:|75-getter|0|75-preInit
 // write pre-init user code here
Guardar = new Command("Guardar", Command.OK, 0);//GEN-LINE:|75-getter|1|75-postInit
 // write post-init user code here
}//GEN-BEGIN:|75-getter|2|
        return Guardar;
    }
//</editor-fold>//GEN-END:|75-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: Guardar2 ">//GEN-BEGIN:|80-getter|0|80-preInit
    /**
     * Returns an initialized instance of Guardar2 component.
     *
     * @return the initialized component instance
     */
    public Command getGuardar2() {
        if (Guardar2 == null) {
//GEN-END:|80-getter|0|80-preInit
 // write pre-init user code here
Guardar2 = new Command("Guardar", Command.OK, 0);//GEN-LINE:|80-getter|1|80-postInit
 // write post-init user code here
}//GEN-BEGIN:|80-getter|2|
        return Guardar2;
    }
//</editor-fold>//GEN-END:|80-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|79-getter|0|79-preInit
 // write pre-init user code here
textField1 = new TextField("Ingresa el indice del registro a modificar:", "", 32, TextField.ANY);//GEN-LINE:|79-getter|1|79-postInit
 // write post-init user code here
}//GEN-BEGIN:|79-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|79-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initialized instance of alert component.
     *
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {
//GEN-END:|82-getter|0|82-preInit
 // write pre-init user code here
alert = new Alert("Alerta", "Datos Guardados.", null, null);//GEN-BEGIN:|82-getter|1|82-postInit
            alert.setTimeout(Alert.FOREVER);//GEN-END:|82-getter|1|82-postInit
 // write post-init user code here
}//GEN-BEGIN:|82-getter|2|
        return alert;
    }
//</editor-fold>//GEN-END:|82-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: mostrar1 ">//GEN-BEGIN:|84-getter|0|84-preInit
    /**
     * Returns an initialized instance of mostrar1 component.
     *
     * @return the initialized component instance
     */
    public StringItem getMostrar1() {
        if (mostrar1 == null) {
//GEN-END:|84-getter|0|84-preInit
 // write pre-init user code here
mostrar1 = new StringItem("Los registros son:", "");//GEN-LINE:|84-getter|1|84-postInit
 // write post-init user code here
}//GEN-BEGIN:|84-getter|2|
        return mostrar1;
    }
//</editor-fold>//GEN-END:|84-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: mostrar2 ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initialized instance of mostrar2 component.
     *
     * @return the initialized component instance
     */
    public StringItem getMostrar2() {
        if (mostrar2 == null) {
//GEN-END:|86-getter|0|86-preInit
 // write pre-init user code here
mostrar2 = new StringItem("Registros:", "");//GEN-LINE:|86-getter|1|86-postInit
 // write post-init user code here
}//GEN-BEGIN:|86-getter|2|
        return mostrar2;
    }
//</editor-fold>//GEN-END:|86-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|87-getter|0|87-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|87-getter|0|87-preInit
 // write pre-init user code here
stringItem = new StringItem("Registros:", "");//GEN-LINE:|87-getter|1|87-postInit
 // write post-init user code here
}//GEN-BEGIN:|87-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|87-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initialized instance of image1 component.
     *
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {
//GEN-END:|89-getter|0|89-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|89-getter|1|89-@java.io.IOException
                image1 = Image.createImage("/Imagenes/Agenda.png");
            } catch (java.io.IOException e) {//GEN-END:|89-getter|1|89-@java.io.IOException
    e.printStackTrace();}//GEN-LINE:|89-getter|2|89-postInit
 // write post-init user code here
}//GEN-BEGIN:|89-getter|3|
        return image1;
    }
//</editor-fold>//GEN-END:|89-getter|3|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}
