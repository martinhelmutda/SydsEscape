package entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import interfaz.GamePanel;

public class Syd extends Entidad{
	private int x,y;
	private int width, height;
	
	private boolean right=false, left=false;
	private boolean jump=false, fall=false; 

	private double jumpSpeed = 17;
	private double currentJumpSpeed=jumpSpeed;
	
	private double maxFallSpeed = 15;//esta es la velocidad maxima de caída que puede tener
	private double currentFallSpeed = 2;//al llegar al punto mas alto regresara con una aceleracion que comienxa con currentFallSpeed y termina con maxFallSpeed
	
	public Syd(int width, int height) {
		x=GamePanel.PWIDTH-160;
		y=GamePanel.PHEIGHT-160;
		this.width = width;
		this.height = height;
		
		this.hitbox = new Rectangle(x,y,width,height);//declaramos el área de golpe
	};
	
	public void tick() { //constantemente se estara leyendo la tecla que se presiona. Este metodo es responsable de cambiar el objeto de lugar
		
		if(fall||jump) { //Si está saltando o cayendo no podemos darle mucha velocidad en x porque hara un gran parabola
			if(right) {
				x+=3;
				if(x>=GamePanel.PWIDTH-5) x=5;//Si la coordenada x está próxima al fin del Panel, enronces regresa por las coordenada x=5
				
			}
			else if(left) {
				x-=3; //la figura se desplaza 5 pixeles a la izquierda cada que se detecta la presión de la tecla
				if(x<=5) x=GamePanel.PWIDTH-5;//Si la figura se aproxima al límite por el extremo izquierdo, continua su recorrido por el extremo derecho de la pantalla
			}
			
			if(jump) {
			//Agregamos la gravedad
			//Recordemos que el extremo superior izquierdo es 0,0 entonces si queremos subir, debemos restar
				y -= currentJumpSpeed; //El salto será de los pixeles que currentJumpSpeed indique
				currentJumpSpeed -= 0.5;//currentJumpSpeed estara disminuyendo su valor cada que el render pase por aqui hasta que finalmente llegue a 0, el maximo de altura
				
				if (currentJumpSpeed <=0) { //Si ya llego a la maxima altura
					currentJumpSpeed=jumpSpeed; //La caida comienza desde el valor inicial de caida
					jump=false; //El salto deja de correr 
					fall=true; //comienza a caer
				}
			}
			
			if(fall) { //Si ya está en estado de caída. 
				if((int)y<GamePanel.PHEIGHT-165) {//EL suelo del juego es de 160 pixeles, por lo tanto es la altura del panel menos los 160
					
					y += currentFallSpeed; //el valor de y se estará incrementando (recordemos que incrementar es bajar) 
					if(currentFallSpeed<maxFallSpeed) {//Si el valor de caida es menor al maximo 
						currentFallSpeed+=0.5;//Se puede ir acelerando
					}
				}else {
					fall=false;//Una vez que alcanza el suelo deja de caer
				}
				
			}
		}
		
		
		if(!fall) { //Si ya no esta en estado de caida, el valor inicial regresa a .1
			currentFallSpeed=0.5;
		}
		if(!jump&&!fall) { //Si no esta saltando ni cayendo la velocidad debe ser alta
			if(right) {
				x+=7;
				if(x>=GamePanel.PWIDTH-5) x=5;//Si la coordenada x está próxima al fin del Panel, enronces regresa por las coordenada x=5
				
			}
			else if(left) {
				x-=7; //la figura se desplaza 5 pixeles a la izquierda cada que se detecta la presión de la tecla
				if(x<=5) x=GamePanel.PWIDTH-5;//Si la figura se aproxima al límite por el extremo izquierdo, continua su recorrido por el extremo derecho de la pantalla
			}
		}
		hitbox.setLocation(x,y);//el área de golpe no cambia, por lo tanto solo debemos ir ajustando las coordenadas en donde se encuentra nuestro objeto
	}
	
	public void pinturita(Graphics dbg) {
		dbg.setColor(Color.DARK_GRAY);
		dbg.fillRect((int)x,(int)y,width,height);
	}
	public void keyPressed(int key) {
		if((key == KeyEvent.VK_D)||(key == KeyEvent.VK_RIGHT))right=true;
		if((key == KeyEvent.VK_A)||(key == KeyEvent.VK_LEFT))left=true;
		if((key == KeyEvent.VK_SPACE)&&(jump==false)) jump=true;
	}
	public void keyReleased(int key) {
		if((key == KeyEvent.VK_D)||(key == KeyEvent.VK_RIGHT))right=false;
		if((key == KeyEvent.VK_A)||(key == KeyEvent.VK_LEFT))left=false;
	}	

}
