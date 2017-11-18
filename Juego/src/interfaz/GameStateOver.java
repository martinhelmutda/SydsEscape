package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameStateOver implements GameState{
	GameStateContext director;
	
	private String[] opcion = {"Reintentar","Salir"};
	private int seleccion=0;

	public GameStateOver(GameStateContext dir) {
		this.director = dir;
	}

	public void ready(){
		
	}
	
	public void nivel(){
		director.setState(StateFactory.getState(2, director));
	}
	
	public void pause(){
		
	}
	
	public void over() {
		
	}
	
	public void tick() {

	}

	public void pinturitas(Graphics dgb) {
		dgb.setColor(Color.white);
		dgb.fillRect(0,0,GamePanel.PWIDTH, GamePanel.PHEIGHT);
		
		dgb.setFont(new Font("Arial", Font.PLAIN, 60));
		dgb.setColor(Color.black);
		dgb.drawString(String.valueOf(GameStateNivel.score), 550, 180);
		dgb.drawString("Game Over", 200, 180);
		
		for(int i=0;i<opcion.length;i++) {
			if(i==seleccion) {
				dgb.setColor(Color.blue);
			}else{
				dgb.setColor(Color.black);
			}
			
			dgb.setFont(new Font("Arial", Font.PLAIN, 40));
			dgb.drawString(opcion[i], GamePanel.PWIDTH/2 -60, 250 + i*100); 
			
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
				System.exit(0);
			}
		}
	}

	public void keyReleased(int key) {
		
	}
}
