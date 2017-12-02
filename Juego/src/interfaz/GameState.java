package interfaz;

import java.awt.Graphics;

interface GameState {
	
	public void tick();
	public void pinturitas(Graphics dgb);
	public void keyPressed(int oo);
	public void keyReleased(int oo);

	public void ready();
	public void nivel();
	public void pause();
	public void over();
}
