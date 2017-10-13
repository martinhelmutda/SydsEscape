package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import interfaz.GamePanel;

public class Obstaculo extends Entidad{
	private int x,y;
	private int width, height;

	
	public Obstaculo(int width, int height) {
		x=GamePanel.PWIDTH-500;
		y=GamePanel.PHEIGHT-160;
		this.width=width;
		this.height=height;
		
		this.hitbox = new Rectangle(x,y,width,height);
	};
	
	public void tick() {

	}
	
	public void pinturita(Graphics dbg) {
		dbg.setColor(Color.BLACK);
		dbg.fillRect((int)x,(int)y,width,height);
	}
	
	
}