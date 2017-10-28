package interfaz;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entidades.*;

public class GameStateNivel implements GameState{
	GameStateContext director;
	
	private Syd syd;
	private Obstaculo obstaculo;
	//private Enemigo enemigo;

	public GameStateNivel(GameStateContext dir) {
		this.director = dir;
		
		syd = new Syd(40,40);
		obstaculo = new Obstaculo(100, 100);
		//enemigo = new Enemigo(40, 40);
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
		//enemigo.tick();
		
		if(syd.collision(obstaculo.getHitbox()) || obstaculo.collision(syd.getHitbox()))
		{
			over();
		}
	}

	public void pinturitas(Graphics dgb) {
		syd.pinturita(dgb);
		obstaculo.pinturita(dgb);
		//enemigo.pinturita(dgb);
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

