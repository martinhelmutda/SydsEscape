package entidades;

import java.awt.*;

import interfaz.GamePanel;

public abstract class Entidad{
	
	private int vida; 
	private int x; 
	private int y;
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
		return y;
	}
	
	public void setPosY(int posY) {
		this.y = posY;
	}
	
	public int getPosX() {
		return x;
	}
	
	public void setPosX(int posX) {
		this.x = posX;
	}
	
	public void draw(Graphics g) {
	    g.fillOval(x, y, 15, 15);                         
	}
	
	public boolean collision(Rectangle r){
		
		Rectangle rec = this.getHitbox();
		
		return rec.contains(r.getX(),r.getY());
	}
	
	public Rectangle getHitbox(){
		return hitbox;
	}
	
	public boolean checkBounds(){
		return false;
	}
	
	public boolean getOutOfBounds(){
		if(x < 0 || y < 0 || x > GamePanel.PWIDTH || y > GamePanel.PHEIGHT){
			return true;
		}
		return false;
	}
	
	public void move(){

	}
	
	public String getType(){
		return null;
	}
	
	public void tick() {
		
	}
	
	public void pinturita(Graphics dbg) {	
		
	}
}
