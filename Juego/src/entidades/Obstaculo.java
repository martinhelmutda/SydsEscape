package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Obstaculo extends Entidad{
	private int x,y, randomObs;
	private BufferedImage image;
	
	private boolean outOfBounds;
	
	public Obstaculo(SpriteSheet ss) {
<<<<<<< HEAD
		randomObs = (int)Math.round(Math.random()*4+1);;
		
		switch(randomObs){
			case 1:
				image = ss.grabImage(5, 1, 100, 100);
				break;
			case 2:
				image = ss.grabImage(7, 1, 100, 100);
				break;
			case 3:
				image = ss.grabImage(8, 1, 100, 100);
				break;
			case 4:
				image = ss.grabImage(9, 1, 100, 100);
				break;
			default:
				image = ss.grabImage(5, 1, 100, 100);
				break;
				
		}

=======
		image = ss.grabImage(5, 1, 100, 100);
>>>>>>> master
		x = GamePanel.PWIDTH;
		y = GamePanel.PHEIGHT-220;
		
		this.hitbox = new Rectangle(x,y,100,10);
		
		outOfBounds = false;
	}
<<<<<<< HEAD
	
	
=======
>>>>>>> master
	
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