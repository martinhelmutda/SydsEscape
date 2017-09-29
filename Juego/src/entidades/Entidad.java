package entidades;

import java.awt.*;

public class Entidad {
	private int vida; 
	private int posX=50; 
	private int posY=50;
	private Image imagen;
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public void draw(Graphics g) {
	    g.fillOval(posX, posY, 15, 15);                         
	}
}
