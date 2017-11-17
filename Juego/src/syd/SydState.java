package syd;

import java.awt.Graphics;

interface SydState {
	
	public void tick();
	public void pinturitas(Graphics dgb);
	public void keyPressed(int key);
	public void keyReleased(int key);

	public void state1();
}
