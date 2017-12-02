package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Mosco extends Entidad{
	private int x,y;
	private BufferedImage image;
	
	private int flyingSpeed;
	private int direction;
	private int cont=5, time;
	private SpriteSheet ss;
	
	private boolean outOfBounds;
	
	public Mosco(SpriteSheet ss) {
		this.ss = ss;

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
		
		if(direction == 0){ //compara la direccion para asignar la imagen inicial
			image = ss.grabImage(5, 7, 100, 100);
		}else{
			image = ss.grabImage(5, 6, 100, 100);
		}
		
		y = randomY;
		
		this.hitbox = new Rectangle(x, y, 100, 10);
		
		outOfBounds = false;
	}
	
	public void tick() {
		time++;
		if(cont>8){ //itera entre el mapa de imagenes
			cont=5;
		}
		if(direction == 0){
			if(time%10==0){ //solo actualiza la imagen cada cierto rango, para que no vaya muy rapido
				image = ss.grabImage(cont, 7, 100, 100);
				cont++;
			}
			x -= flyingSpeed;
		}else{
			if(time%10==0){
				image = ss.grabImage(cont, 6, 100, 100);
				cont++;
			}
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
