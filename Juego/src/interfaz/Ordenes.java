package interfaz;

import java.awt.Graphics;

public abstract class Ordenes {
	protected Director director;
	
	public Ordenes(Director director){
		this.director=director;//el director que entra deste otra clase se instala en esta con el mismo nombre
		empezar();
	}
	
	public abstract void empezar();
	public abstract void tick();
	public abstract void pinturitas(Graphics dgb);
	public abstract void keyPressed(int oo);
	public abstract void keyReleased(int oo);
}
