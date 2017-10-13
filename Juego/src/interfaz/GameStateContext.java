package interfaz;

import java.awt.Graphics;

public class GameStateContext {
	
	private GameStateMenu menu;
	private GameStateNivel nivel;
	private GameStatePaused pausa;
	private GameStateOver over;
	
	private GameState currentState;
	
	public GameStateContext() {
		menu = new GameStateMenu(this);
		nivel = new GameStateNivel(this);
		pausa = new GameStatePaused(this);
		over = new GameStateOver(this);
		currentState = menu;
	}
	
	public GameState getMenu(){
		return menu;
	}
	
	public GameState getNivel(){
		return nivel;
	}
	
	public GameState getPaused(){
		return pausa;
	}
	
	public GameState getOver(){
		nivel = new GameStateNivel(this);
		return over;
	}
	
	public void setState(GameState s){
		currentState = s;
	}
	
	public void menu(){
		currentState.menu();
	}
	
	public void nivel(){
		currentState.nivel();
	}

	public void tick() {
		currentState.tick();
	}
	
	public void pinturitas(Graphics dgb) {
		currentState.pinturitas(dgb);
	}

	public void keyPressed(int keyCode) {
		currentState.keyPressed(keyCode);
	}

	public void keyReleased(int keyCode) {
		currentState.keyReleased(keyCode);
	}
}


