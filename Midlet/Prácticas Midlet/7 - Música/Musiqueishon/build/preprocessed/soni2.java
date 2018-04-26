import javax.microedition.midlet.*; 
import javax.microedition.lcdui.*; 
import javax.microedition.media.*; 
import javax.microedition.media.control.*; 
import java.io.*; 
public class soni2 extends MIDlet implements CommandListener { 
	Display	d;  
	Form	f;  
	Command	c;  
	Command wav, nta, sec;  
	public soni2() {  
		d	= Display.getDisplay(this); 
		c	= new Command("Salir",	Command.EXIT, 1); 
		wav	= new Command("WAV",	Command.SCREEN, 2); 
		nta	= new Command("Nota",	Command.SCREEN, 2); 
		sec	= new Command("Secuencia", Command.SCREEN, 2); 
		f	= new Form("Reproducir."); 
		f.addCommand(c); 
		f.addCommand(wav); 
		f.addCommand(nta); 
		f.addCommand(sec); 
		f.setCommandListener(this); 
	} 
	public void startApp() { 
		d.setCurrent(f); 
	} 
	public void pauseApp() {} 
	public void destroyApp(boolean unconditional) {} 
	public void commandAction(Command co, Displayable di) { 
		if (co == c) {  
			destroyApp(false); 
			notifyDestroyed(); 
		}else{
			if (co == wav)	playWav(); 
			if (co == nta)	playNta(); 
			if (co == sec)	playSec(); 
		} 
	} 
	public void playWav(){
		try { 
			InputStream is = getClass().getResourceAsStream("rombosman.wav");
			Player p = Manager.createPlayer(is, "audio/x-wav");
			p.start();
		}catch (Exception e){
			Alert a = new Alert("Error", "Sin sonido.", null, AlertType.ERROR); 
			a.setTimeout(Alert.FOREVER); 
			d.setCurrent(a, f); 
		} 
	} 
	public void playNta(){ 
		try {
			Manager.playTone(ToneControl.C4-12, 1000, 100);  
                        System.out.println("nota");
		}catch (MediaException e){} 
	} 
	public void playSec() { 
		byte tempo = 30, d = 8; 
		byte C4 = ToneControl.C4; // Nota DO
		byte D4 = (byte)(C4 + 2); // RE
		byte E4 = (byte)(C4 + 4); // MI
		byte F4 = (byte)(C4 + 5); // FA
		byte G4 = (byte)(C4 + 7); // SOL
		byte silencio = ToneControl.SILENCE; 
		byte[] secuencia = {
					ToneControl.VERSION, 1, ToneControl.TEMPO, tempo, 
					ToneControl.BLOCK_START, 0, C4,d, F4,d, F4,d, C4,d, F4,d, F4,d, C4,d, F4,d, 
					ToneControl.BLOCK_END, 0,    
					ToneControl.BLOCK_START, 1, C4,d, E4,d, E4,d, C4,d, E4,d, E4,d, C4,d, E4,d, 
					ToneControl.BLOCK_END, 1,
					ToneControl.PLAY_BLOCK, 0,   
					ToneControl.PLAY_BLOCK, 1,   
					ToneControl.PLAY_BLOCK, 0,   
				};
		try{ 
			Player p = Manager.createPlayer(Manager.TONE_DEVICE_LOCATOR); 
			p.realize(); 
			ToneControl tc = (ToneControl)p.getControl("ToneControl"); 
			tc.setSequence(secuencia); 
			p.start(); 
		} catch (IOException ioe) {}
		catch (MediaException me) {} 
	}
}
