package interfaz;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


import entidades.*;

public class GameStateNivel implements GameState{
	GameStateContext director;
	
	private Syd syd;
	private Obstaculo obstaculo;
	private BufferedImage fondo;

	public GameStateNivel(GameStateContext dir) {
		this.director = dir;
		syd = new Syd();
		obstaculo = new Obstaculo();
		
		BufferedImageLoader loader = new BufferedImageLoader(); //para cargar el fondo
		try{
			fondo = loader.loadImage("/images/fondo.png"); 
		}catch(IOException e){
			e.printStackTrace();
		}	
	}

	public void menu(){
		
	}
	
	public void nivel(){

	}
	
	public void over() {
		director.setState(StateFactory.getState(4, director));
	}
	
	public void tick() {
		syd.tick();
		obstaculo.tick();
		
		if(syd.collision(obstaculo.getHitbox()) || obstaculo.collision(syd.getHitbox()))
		{
			over();
		}
	}

	public void pinturitas(Graphics dgb, SpriteSheet ss) {
		dgb.drawImage(fondo, 0, 0, null);
		syd.pinturita(dgb, ss);
		obstaculo.pinturita(dgb, ss);
	}
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_ESCAPE ) {
			director.setState(StateFactory.getState(3, director));
		}
		syd.keyPressed(key);
	}

	public void keyReleased(int key) {
		syd.keyReleased(key);
	}
}

