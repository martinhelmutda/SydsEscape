package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Bicho extends Entidad{
	private int x,y;
	private BufferedImage image;
<<<<<<< HEAD
	private SpriteSheet ss;
	
	private int flyingSpeed;
	private int direction;
	private int cont=5, time;
=======
	
	private int flyingSpeed;
	private int direction;
>>>>>>> master
	
	private boolean outOfBounds;
	
	public Bicho(SpriteSheet ss) {
<<<<<<< HEAD
		this.ss = ss;
=======
		image = ss.grabImage(5, 1, 100, 100);
		
>>>>>>> master
		Random randomGenerator = new Random();
		flyingSpeed = randomGenerator.nextInt(6) + 1;
		if(randomGenerator.nextInt()%2 == 0){
			direction = 0;
			x = GamePanel.PWIDTH;
		}else{
			direction = 1;
			x = 1;
		}

<<<<<<< HEAD
		if(direction == 0){ //compara la direccion para asignar la imagen inicial
			image = ss.grabImage(5, 2, 100, 100);
		}else{
			image = ss.grabImage(5, 3, 100, 100);
		}
		
=======
>>>>>>> master
		y = GamePanel.PHEIGHT-220;
		
		this.hitbox = new Rectangle(x, y, 100, 10);
		
		outOfBounds = false;
	}
	
	public void tick() {
<<<<<<< HEAD
		time++;
		if(cont>8){
			cont=5;
		}
		
		if(direction == 0){ //hace una comparacion de direccion para elegir el grupo de imagenes a mostrar y hacia donde se movera en x 
			if(time%10==0){ //solo actualiza la imagen cada cierto rango, para que no vaya muy rapido
				image = ss.grabImage(cont, 2, 100, 100);
				cont++;
			}
			x -= flyingSpeed;
		}else{
			if(time%10==0){
				image = ss.grabImage(cont, 3, 100, 100);
				cont++;
			}
			x += flyingSpeed;
		}

=======
		if(direction == 0){
			x -= flyingSpeed;
		}else{
			x += flyingSpeed;
		}
		
>>>>>>> master
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
	
	public boolean getOutOfBounds(){
		return outOfBounds;
	}
	
	public void pinturita(Graphics dbg) {	
		dbg.drawImage(image, x-30, y-40, null);
	}
	
}