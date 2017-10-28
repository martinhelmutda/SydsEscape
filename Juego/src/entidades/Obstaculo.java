package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import interfaz.GamePanel;

public class Obstaculo extends Entidad{
	private int x,y;
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
	}
	
	
}