package interfaz;

import java.awt.Graphics;

interface GameState {
	
	public void tick();
	public void pinturitas(Graphics dgb, SpriteSheet ss);
	public void keyPressed(int oo);
	public void keyReleased(int oo);

	public void menu();
	public void nivel();
}
