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
	private BufferedImage fondo, color, fondoLargo, arboles;
	private BufferedImageLoader loader;
	private BufferedImage spriteSheet;
	private SpriteSheet ss;

	public GameStateNivel(GameStateContext dir) {
		this.director = dir;		
		loader = new BufferedImageLoader(); //para cargar el fondo y los sprites
		try{
			spriteSheet = loader.loadImage("/images/mapa.png");
			fondo = loader.loadImage("/images/fondo-c.png");
			fondoLargo = loader.loadImage("/images/fondo-largo.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		ss = new SpriteSheet(spriteSheet);
		
		syd = new Syd(ss);
		obstaculo = new Obstaculo(ss);
		arboles = loader.grabBackground(fondoLargo);
		
	}

	public void menu(){
		
	}
	
	public void nivel(){

	}
	
	public void over() {
		director.setState(StateFactory.getState(4, director));
	}
	
	public void tick() {
		arboles = loader.grabBackground(fondoLargo);
		syd.tick();
		obstaculo.tick();
		
		if(syd.collision(obstaculo.getHitbox()) || obstaculo.collision(syd.getHitbox()))
		{
			over();
		}
		
	}

	public void pinturitas(Graphics dgb) {
		dgb.drawImage(fondo, 0, 0, null);
		dgb.drawImage(arboles, 0, 0, null);
		syd.pinturita(dgb);
		obstaculo.pinturita(dgb);
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

