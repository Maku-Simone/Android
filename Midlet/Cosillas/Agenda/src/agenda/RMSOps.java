package agenda;

import java.io.*;
import javax.microedition.rms.*;
public class RMSOps {
    RecordStore rs;
    public RMSOps(){
        
    }
    public boolean abrir(String nombreZona){
        try{
            rs=RecordStore.openRecordStore(nombreZona, true);
            return true;
            }catch(RecordStoreException e){
            e.toString();
            return false;
            }
    }
    public boolean adicionarRegistro(ByteArrayOutputStream baos){
        byte[] mensaje;
        mensaje =baos.toByteArray();
        try{
            rs.addRecord(mensaje, 0,mensaje.length);
            return true;
        }catch (RecordStoreException e){
            e.toString();
            return false;
        }
    }
    
    public boolean adicionarRegistro(String valor){
        byte[] mensaje;
        mensaje=valor.getBytes();
        try{
            rs.addRecord(mensaje,0,mensaje.length);
            return true;
        }
        catch (RecordStoreException e){
            e.toString();
            return false;
        }
    }
    
    public String listarRegistro(){
        byte []reg= new byte[100];
        int tam,id;
        String buffer="";
        try{
           for(int i=1; i<=rs.getNumRecords();i++){
               tam=rs.getRecordSize(i);
               reg=rs.getRecord(i);
               buffer += "\n" + i + new String(reg,0,tam);
           }
            System.out.println("El buffer: "+buffer);
        }catch(RecordStoreException e){
            System.out.println("Error de lectura");
        }
            return buffer;
    }
    
    public String[] listarRegistro(int r){
        byte[] reg = new byte[100];
        ByteArrayInputStream bais; 
        DataInputStream dis;
        String [] datos= new String [3];
        try{
            reg=rs.getRecord(r);
            bais = new ByteArrayInputStream(reg);
            dis=new DataInputStream((bais));
            datos[0]= dis.readUTF();
            datos[1]= dis.readUTF();
            datos[2]= dis.readUTF()+"";
        }catch (RecordStoreException e){
            System.out.println("error de lectura");
        }catch (IOException e){
            e.printStackTrace();
        }
        return datos;
    }
    
    public  boolean cerrar(){
        try{
            rs.closeRecordStore();
            return true;
        }catch (RecordStoreException e){
            e.toString();
            return false;    
        }
    }
    public void destruirRecordStore(){
            try{
               RecordStore.deleteRecordStore("BASE");
            }
            catch (RecordStoreException e){
               System.out.println("Error al eliminar el Record Store");
            }
    }
    public void borrarRecordStore(){
                try {
                        for(int i=1;i<rs.getNumRecords()+1;i++){
                                rs.deleteRecord(i);
                        }
                } catch (RecordStoreNotOpenException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (InvalidRecordIDException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (RecordStoreException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
    }
    public void eliminarRecordStore(int i){
                try {
                        rs.deleteRecord(i);
                } catch (RecordStoreNotOpenException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (InvalidRecordIDException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (RecordStoreException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
    
}
