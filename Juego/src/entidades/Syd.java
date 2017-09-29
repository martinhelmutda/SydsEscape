package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import interfaz.GamePanel;

public class Syd extends Rectangle{
	//Extender el Rectangle te permite hacer límites para colisiones,  etc.
	
	private static final long serialVersionUID = 1L;
	
	private boolean right=false, left=false;
	private boolean jump=false, fall=false; 
	private double x,y;
	private int width, height;
	private double jumpSpeed = 5;
	private double currentJumpSpeed=jumpSpeed;
	
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	
	public  Syd(int width, int height) {
		x=GamePanel.PWIDTH-160;
		y=GamePanel.PHEIGHT-160;
		this.width=width;
		this.height=height;
	};
	
	public void tick() {
		if(right) {
			x+=5;
			if(x<=5) {
				x=GamePanel.PWIDTH-5;
			}else if(x>=GamePanel.PWIDTH-5) {
				x=5;
			}
		}
		if(left) {
			x-=5;
			if(x<=5) {
				x=GamePanel.PWIDTH-5;
			}else if(x>=GamePanel.PWIDTH-5) {
				x=5;
			}
		}
		if(jump) {
			//Agregamos la gravedas
			y -= currentJumpSpeed;
			currentJumpSpeed -= .1;
			
			if (currentJumpSpeed <=0) {
				currentJumpSpeed=jumpSpeed;
				jump=false;
				fall=true;
			}
		}
		
		if(fall) {
			y += currentFallSpeed;
			if((int)y>=GamePanel.PHEIGHT-160) {
				fall=false;
			}
			if(currentFallSpeed<maxFallSpeed) {
				currentFallSpeed+=.1;
			}
		}
		if(!fall) {
			currentFallSpeed=.1;
		}
	}
	
	public void pinturita(Graphics dbg) {
		dbg.setColor(Color.DARK_GRAY);
		dbg.fillRect((int)x,(int)y,width,height);
	}
	public void keyPressed(int oo) {
		if((oo == KeyEvent.VK_D)||(oo==KeyEvent.VK_RIGHT))right=true;
		if((oo == KeyEvent.VK_A)||(oo==KeyEvent.VK_LEFT))left=true;
		if((oo == KeyEvent.VK_SPACE)&&(jump==false)) jump=true;
	}
	public void keyReleased(int oo) {
		if((oo == KeyEvent.VK_D)||(oo==KeyEvent.VK_RIGHT))right=false;
		if((oo == KeyEvent.VK_A)||(oo==KeyEvent.VK_LEFT))left=false;
	}	

}
