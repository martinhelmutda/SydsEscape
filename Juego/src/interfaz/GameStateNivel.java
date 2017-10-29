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
<<<<<<< HEAD
	//private Enemigo enemigo;
=======
	private BufferedImage fondo;
	private BufferedImage spriteSheet;
	private SpriteSheet ss;
>>>>>>> master

	public GameStateNivel(GameStateContext dir) {
		this.director = dir;		
		BufferedImageLoader loader = new BufferedImageLoader(); //para cargar el fondo y los sprites
		try{
			spriteSheet = loader.loadImage("/images/mapa.png");
			fondo = loader.loadImage("/images/fondo.png"); 
		}catch(IOException e){
			e.printStackTrace();
		}
		ss = new SpriteSheet(spriteSheet);
		
<<<<<<< HEAD
		syd = new Syd(40,40);
		obstaculo = new Obstaculo(100, 100);
		//enemigo = new Enemigo(40, 40);
=======
		syd = new Syd(ss);
		obstaculo = new Obstaculo(ss);
>>>>>>> master
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
<<<<<<< HEAD
		//enemigo.tick();
=======
>>>>>>> master
		
		if(syd.collision(obstaculo.getHitbox()) || obstaculo.collision(syd.getHitbox()))
		{
			over();
		}
		
	}

	public void pinturitas(Graphics dgb) {
		dgb.drawImage(fondo, 0, 0, null);
		syd.pinturita(dgb);
		obstaculo.pinturita(dgb);
<<<<<<< HEAD
		//enemigo.pinturita(dgb);
=======
>>>>>>> master
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

