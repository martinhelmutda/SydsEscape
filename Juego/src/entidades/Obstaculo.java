package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
<<<<<<< HEAD
import java.util.Random;

=======
import java.awt.image.BufferedImage;
>>>>>>> master
import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Obstaculo extends Entidad{
	private int x,y;
<<<<<<< HEAD
	private int width, height;
	public Random rand;

	
	public Obstaculo(int width, int height) {
		x=GamePanel.PWIDTH-500;
		y=GamePanel.PHEIGHT-220;
		this.width=width;
		this.height=height;
		
		this.hitbox = new Rectangle(x,y,width,height);
		rand = new Random();
	};
	
	public void tick() {
		x+=2;

	}
	
	public void pinturita(Graphics dbg) {
		dbg.setColor(Color.BLACK);
		dbg.fillRect((int)x,(int)y,width,height);
		
		this.hitbox = new Rectangle(x,y,width,height);//declaramos el área de golpe
=======
	private BufferedImage image;
	
	public Obstaculo(SpriteSheet ss) {
		image = ss.grabImage(5, 1, 100, 100);
		x=GamePanel.PWIDTH-300;
		y=GamePanel.PHEIGHT-220;
		
		this.hitbox = new Rectangle(x,y,100,10);
	};
	
	public void tick() {
	}
	
	public void pinturita(Graphics dbg) {	
		dbg.drawImage(image, x-30, y-40, null);
>>>>>>> master
	}
	
}