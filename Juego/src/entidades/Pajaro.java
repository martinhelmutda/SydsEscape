package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Pajaro extends Entidad{
	private int x,y;
	private BufferedImage image;
	
	private int flyingSpeed;
	private int direction;
	
	private boolean outOfBounds;
	
	public Pajaro(SpriteSheet ss) {
		image = ss.grabImage(5, 1, 100, 100);
		
		Random randomGenerator = new Random();
		int randomY = randomGenerator.nextInt(380);
		flyingSpeed = randomGenerator.nextInt(6) + 1;
		if(randomGenerator.nextInt()%2 == 0){
			direction = 0;
			x = GamePanel.PWIDTH;
		}else{
			direction = 1;
			x = 1;
		}

		y = randomY;
		
		this.hitbox = new Rectangle(x, y, 100, 10);
		
		outOfBounds = false;
	}
	
	public void tick() {
		if(direction == 0){
			x -= flyingSpeed;
		}else{
			x += flyingSpeed;
		}
		
		hitbox = new Rectangle(x, y, 100, 10);
		
		outOfBounds = checkBounds();
	}
	
	public boolean checkBounds(){
		if(x < 0 || y < 0 || x > GamePanel.PWIDTH || y > GamePanel.PHEIGHT){
			return true;
		}
		return false;
	}
	
	public void move(){
		if(direction == 0){
			x -= 5;
		}
		
		hitbox = new Rectangle(x, y, 100, 10);
	}
	
	public String getType(){
		return "pajaro";
	}
	
	public boolean getOutOfBounds(){
		return outOfBounds;
	}
	
	public void pinturita(Graphics dbg) {	
		dbg.drawImage(image, x-30, y-40, null);
	}
	
}