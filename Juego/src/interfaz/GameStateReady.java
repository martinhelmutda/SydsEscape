package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameStateReady implements GameState{
	GameStateContext director;
	private ImageLoader loader;
	private BufferedImage spriteSheet, fondodia, fondonoche, fondoLargo, inicio;
	
	private String[] opcion = {"Inicio","Salir"};
	private int seleccion=0;
	
	public GameStateReady(GameStateContext dir, ImageLoader loader) {
		this.director = dir;	
		this.loader = loader; //para cargar el fondo y los sprites
		try{
			spriteSheet = loader.loadImage("/images/mapa.png");
			fondodia = loader.loadImage("/images/fondo-c.png");
			fondonoche = loader.loadImage("/images/fondo-d.png");
			fondoLargo = loader.loadImage("/images/fondo-largo.png");
			inicio = loader.loadImage("/images/PantallaInicio.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		loader.setImage(spriteSheet, 0);
		loader.setImage(fondodia, 1);
		loader.setImage(fondonoche, 2);
		loader.setImage(fondoLargo, 3);
		loader.setImage(inicio, 4);
		
	}
	
	public void ready(){
		
	}
	
	public void nivel(){
<<<<<<< HEAD
		director.setState(StateFactory.getState(2, director, loader));
=======
		director.setState(StateFactory.getState(2, director));
>>>>>>> master
	}
	
	public void pause(){
		
	}
	
	public void over(){
		
	}

	public void tick() {
		
	}

	public void pinturitas(Graphics dgb) {
		dgb.drawImage(inicio, 0, 0, null);


		//Aquí mostraremos el efecto de selección entre las opciones
		for(int i=0;i<opcion.length;i++) { 	//Recorre e imprime todas las opciones
			if(i==seleccion) {
				dgb.setColor(Color.blue);
			}else{
				dgb.setColor(Color.black);
			}
			
			dgb.setFont(new Font("Arial", Font.PLAIN, 40));
			dgb.drawString(opcion[i], GamePanel.PWIDTH/2 -50, 250 + i*100); //Esto dibuja una palabra en la coordenada deseada
			//Tomamos la anchura de la clase GAME PANEL y la dividimos entre 2 para centrar el texto
		}//Tomamos el número de opciones
	}


	public void keyPressed(int key) {//PODEMOS CAMBIAR A UN SWITCH
		if(key == KeyEvent.VK_DOWN) {
			seleccion++; //Si se presiona alguna de las teclas, la selección cambia
			if(seleccion >= opcion.length) {	//Si la seleccion se pasa del numero de opciones, regresa al inicio
				seleccion=0;
			}
		}else if(key == KeyEvent.VK_UP){
			seleccion--;
			if(seleccion<0) {
				seleccion = opcion.length-1;
			}
		}else if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
			if(seleccion==0) {	//Inicio
				nivel();
			}
			else if(seleccion==1) {	//Salir
				System.exit(0);
			}
		}
	}

	public void keyReleased(int key) {
		
	}
}


