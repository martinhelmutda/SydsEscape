package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameStatePaused implements GameState{
	GameStateContext director;
	private ImageLoader loader;
	
	private String[] opcion = {"Continuar","Salir"};
	private int seleccion=0;

	public GameStatePaused(GameStateContext dir, ImageLoader loader) {
		this.loader = loader;
		this.director = dir;
	}

	public void ready(){
		
	}
	
	public void nivel(){
		director.setState(StateFactory.getState(2, director, loader));
	}
	
	public void pause(){
		
	}
	
	public void over(){
		director.setState(StateFactory.getState(4, director, loader));
	}
	
	public void tick() {

	}

	public void pinturitas(Graphics dgb) {
		dgb.drawImage(loader.getImage(4), 0, 0, null);
		
		for(int i=0;i<opcion.length;i++) {
			if(i==seleccion) {
				dgb.setColor(Color.blue);
			}else{
				dgb.setColor(Color.black);
			}
			
			dgb.setFont(new Font("Arial", Font.PLAIN, 40));
			dgb.drawString(opcion[i], GamePanel.PWIDTH/2 -50, 250 + i*100); 
			
		}
	}
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_DOWN) {
			seleccion++;
			if(seleccion >= opcion.length) {
				seleccion=0;
			}
		}else if(key == KeyEvent.VK_UP){
			seleccion--;
			if(seleccion<0) {
				seleccion = opcion.length-1;
			}
		}else if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
			if(seleccion==0) {
				nivel();
			}
			else if(seleccion==1) {
				over();
			}
		}
	}

	public void keyReleased(int key) {
		
	}
}
