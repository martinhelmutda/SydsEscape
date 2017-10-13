package entidades;

import java.awt.*;

public abstract class Entidad{
	
	private int vida; 
	private int posX=50; 
	private int posY=50;
	private Image imagen;
	protected Rectangle hitbox;	//Colisiones
	
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
	
	public boolean collision(Rectangle r){
		
		Rectangle rec = this.getHitbox();
		
		return rec.contains(r.getX(),r.getY());
	}
	
	public Rectangle getHitbox(){
		return hitbox;
	}
}
