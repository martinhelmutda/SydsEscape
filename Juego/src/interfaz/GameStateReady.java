package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameStateReady implements GameState{
	GameStateContext director;
	
	private String[] opcion = {"Inicio","Salir"};
	private int seleccion=0;
	
	public GameStateReady(GameStateContext dir) {
		this.director = dir;	
	}
	
	public void menu(){
		
	}
	
	public void nivel(){
		
	}

	public void tick() {
		
	}

	public void pinturitas(Graphics dgb, SpriteSheet ss) {
		dgb.setColor(Color.black);
		dgb.fillRect(0,0,GamePanel.PWIDTH, GamePanel.PHEIGHT);
		//Aquí mostraremos el efecto de selección entre las opciones
		for(int i=0;i<opcion.length;i++) { 	//Recorre e imprime todas las opciones
			if(i==seleccion) {
				dgb.setColor(Color.blue);
			}else{
				dgb.setColor(Color.white);
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
				director.setState(StateFactory.getState(2, director));
			}
			else if(seleccion==1) {	//Salir
				System.exit(0);
			}
		}
	}

	public void keyReleased(int key) {
		
	}
}


