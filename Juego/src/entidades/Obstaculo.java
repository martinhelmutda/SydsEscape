package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Obstaculo extends Entidad{
	private int x,y;
	private BufferedImage image;
	
	private boolean outOfBounds;
	
	public Obstaculo(SpriteSheet ss) {
		image = ss.grabImage(5, 1, 100, 100);
		x = GamePanel.PWIDTH;
		y = GamePanel.PHEIGHT-220;
		
		this.hitbox = new Rectangle(x,y,100,10);
		
		outOfBounds = false;
	}
	
	public void tick() {
		outOfBounds = checkBounds();
	}
	
	public boolean checkBounds(){
		if(x < 0 || y < 0 || x > GamePanel.PWIDTH || y > GamePanel.PHEIGHT){
			return true;
		}
		return false;
	}
	
	public boolean getOutOfBounds(){
		return outOfBounds;
	}
	
	public void move(){
		x -= 5;
		
		hitbox = new Rectangle(x-25, y-25, 85, 70);
	}
	
	public String getType(){
		return "obstaculo";
	}
	
	public void pinturita(Graphics dbg) {	
		dbg.drawImage(image, x-30, y-40, null);
	}
	
}