package interfaz;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.*;
import entidades.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private static final long serialVersionUID = 1L;
	public static final int PWIDTH = 800;
	public static final int PHEIGHT = 800;
	
	private boolean gameOver = false, isPaused = false, running = false, corredor=false;
	private Graphics dbg;
	//private Image dbImage = null;
	//private Syd syd = new Syd();
	
	private Thread animator; // controla animacion
	
	private int FPS=60;
	private long tiempoObj= 1000/FPS;
	private Director director;
	
	public GamePanel() {
		setPreferredSize(new Dimension (PWIDTH,PHEIGHT));
		addKeyListener(this);
		setFocusable(true);//puede ser sobrescrito un elemento
		start();
		
	}

	public void start() {
		corredor=true;
		animator = new Thread(this);
		animator.start();
	}
	
	
	 public void run() {
		 long inicio, transcurso, espera;
		 director = new Director();
		 
		 while(corredor) {
			 inicio=System.nanoTime();//le pedimos al sistema la hora
			 	 tick();
			 repaint();
			 
			 
			 transcurso=System.nanoTime()-inicio;
			 espera = tiempoObj - transcurso / 1000000;
			 
			 if (espera <= 0) {
				 espera=5;
			 }//no permitimos que la computaodra procese tan rápido
			 
			 try {
				 Thread.sleep(espera);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 

	
	 
	 public void tick(){
		// System.out.println("Science Bitch");
		 director.tick(); //Lógica de la administración
		 
	 }//Aquí está la lógica
	 
	 private void draw() {
		 director.pinturitas(dbg);
	 }
	 
	 public void paintComponent(Graphics dbg) {
		 super.paintComponent(dbg);
		 dbg.clearRect(0, 0, PWIDTH, PHEIGHT-120);//Limpia todo, menos la base
		 director.pinturitas(dbg); //Pintamos las imágenes que el director administra
	 }
	 

	



	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		director.keyPressed(e.getKeyCode());//llamará los métodos dentro del director. Pedimos el cídigo de la tecla "e" que se presiona
	}

	public void keyReleased(KeyEvent e) {
		director.keyReleased(e.getKeyCode());//llamará los métodos dentro del director. Pedimos el código de la tecla que se soltó
	}
	
	public void mouseClicked(MouseEvent e){
		
	}
}
