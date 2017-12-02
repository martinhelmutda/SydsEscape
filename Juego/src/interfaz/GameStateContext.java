package interfaz;

import java.awt.Graphics;

public class GameStateContext {	
	private GameState currentState;
	private ImageLoader loader;
	
	public GameStateContext() {
		loader = new ImageLoader();
		currentState = StateFactory.getState(1, this, loader);
	}
	
	public void setState(GameState s) {
		currentState = s;
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


