package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Obstaculo extends Entidad{
	private int x,y;
	private BufferedImage image;
	
	public Obstaculo() {
		x=GamePanel.PWIDTH-300;
		y=GamePanel.PHEIGHT-220;
		
		this.hitbox = new Rectangle(x,y,100,10);
	};
	
	public void tick() {
	}
	
	public void pinturita(Graphics dbg, SpriteSheet ss) {
		image = ss.grabImage(5, 1, 100, 100);	
		dbg.drawImage(image, x-30, y-40, null);
	}
	
}