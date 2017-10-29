package interfaz;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	public static final int PWIDTH = 720;
	public static final int PHEIGHT = 480;
=======
	public static final int PWIDTH = 800;
	public static final int PHEIGHT = 600;
	
>>>>>>> master
	
	private boolean corredor=false;
	private Thread animator; // Controla animaciï¿½n
	
	private int FPS=60;
	private long tiempoObj= 1000/FPS;
	private GameStateContext director;

	
	public GamePanel() {
		setPreferredSize(new Dimension (PWIDTH,PHEIGHT));
		setFocusable(true);
		addKeyListener(this);
		requestFocus();
		
		director = new GameStateContext();	
	}
	
	public void init(){ //inicializa el ImageLoager
	}
	

	public void addNotify(){
		super.addNotify();
		start();
	}
	
	public void start() {
		corredor=true;
		animator = new Thread(this);
		animator.start();
	}
	
	
	 public void run() {
		 init();
		 long inicio, transcurso, espera;
		 while(corredor) {
			 inicio=System.nanoTime();	//Le pedimos al sistema la hora			 
			 transcurso=System.nanoTime()-inicio;
			 espera = tiempoObj - transcurso / 1000000;
			 
			 tick();
			 repaint();
			 
			 if (espera <= 0) {
<<<<<<< HEAD
				 espera=5;
			 }	//No permitimos que la computadora procese tan rï¿½pido
=======
				 espera=10;
			 }	//No permitimos que la computadora procese tan rápido
>>>>>>> master
			 
			 try {
				 Thread.sleep(espera);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	  

	public void tick(){
		 director.tick(); 
	 }
	 
	 public void paintComponent(Graphics dbg) {
		 super.paintComponent(dbg);
		 dbg.clearRect(0, 0, PWIDTH, PHEIGHT-120);	//Limpia todo, menos la base
		 director.pinturitas(dbg); 	//Pintamos las imï¿½genes que el director administra
	 }

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		director.keyPressed(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		director.keyReleased(e.getKeyCode());
	}
}


