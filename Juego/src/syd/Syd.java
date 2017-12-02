package syd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import entidades.Entidad;
import interfaz.GamePanel;
import interfaz.SpriteSheet;

public class Syd extends Entidad{	
	private SydState state1;
	private SydState state2;
	private SydState state3;
	private SydState state4;
	private SydState state5;
	private SydState state6;
	private SydState state7;
	private SydState state8;
	private SydState state9;
	private SydState state10;
	private SydState currentState;
	
	public int x, y, cont;
	public static int contador = 1, score;
	
	private boolean right=false, left=false;
	private boolean jump=false, fall=false, hit = false; 
	
	private boolean stop, stopBack;

	private double jumpSpeed = 17;
	private double currentJumpSpeed = jumpSpeed;
	
	private double hitSpeed = 8;
	private double currentHitSpeed = hitSpeed;
	
	private double maxFallSpeed = 15;//esta es la velocidad maxima de caída que puede tener
	private double currentFallSpeed = 2;//al llegar al punto mas alto regresara con una aceleracion que comienxa con currentFallSpeed y termina con maxFallSpeed
	
	private int life, sun;
	
	private boolean superSyd;
	private int superActive;
	
	private boolean invulnerable;
	public int invulnerableTick;
	
	private int sunTick;
	public boolean sunGrab;
	
	public Syd(SpriteSheet ss) {
		state1 = new State1(ss, this); 
		state2 = new State2(ss, this); 
		state3 = new State3(ss, this); 
		state4 = new State4(ss, this); 
		state5 = new State5(ss, this); 
		state6 = new State6(ss, this); 
		state7 = new State7(ss, this); 
		state8 = new State8(ss, this); 
		state9 = new State9(ss, this); 
		state10 = new State10(ss, this); 
		
		currentState = state1;
		
		x = 150; 
		y = GamePanel.PHEIGHT-250;
		this.hitbox = new Rectangle(x, y-30, 40, 90);		//declaramos el área de golpe
		
		life = 100;
		sun = 0;
		
		superSyd = false;
		superActive = 0;
		
		invulnerable = false;
		invulnerableTick = 100;
		
		sunTick = 0;
		sunGrab = true;
	}
	
	/*Metodos del StateSyd*/
	public void setState(SydState s) {
		currentState = s;
	}
	
	public SydState getState1(){
		System.out.println("state1");
		return state1;
	}
	
	public SydState getState2(){
		System.out.println("state2");
		return state2;
	}
	
	public SydState getState3(){
		System.out.println("state3");
		return state3;
	}
	
	public SydState getState4(){
		System.out.println("state4");
		return state4;
	}
	
	public SydState getState5(){
		System.out.println("state5");
		return state5;
	}
	
	public SydState getState6(){
		System.out.println("state6");
		return state6;
	}
	
	public SydState getState7(){
		System.out.println("state7");
		return state7;
	}
	
	public SydState getState8(){
		System.out.println("state8");
		return state8;
	}
	
	public SydState getState9(){
		System.out.println("state9");
		return state9;
	}
	
	public SydState getState10(){
		System.out.println("state10");
		return state10;
	}
	/**/
	
	public void hit(){
		if(invulnerable == false){
			life -= 10;
			hit = true;
			invulnerable = true;
		}
		
		if(life < 0){
			life = 0;
		}
	}
	
	public void activateSuperSyd(){
		if(sun == 100){
			superSyd = true;
		}
	}
	
	public boolean getSuperSyd(){
		return superSyd;
	}
	
	public int getLife(){
		return life;
	}
	
	public boolean getRight(){
		if(right){ //si se esta moviendo a la derecha y ademas llega a la mitad
			if(x >= 400){ 
				return true;
			}
		}
		return false;
	}
	
	public void regenLife(){
		life += 10;
		
		if(life > 100){
			life = 100;
		}
	}
	
	int conta;
	public void tick() { //constantemente se estara leyendo la tecla que se presiona. Este metodo es responsable de cambiar el objeto de lugar
		currentState.tick();
		score++;
	
		
		if(x >= 400){
			stop = true;
		}else{
			stop = false;
		}
		
		if(x <= 6){
			stopBack = true;
		}else{
			stopBack = false;
		}
		
		if(fall||jump) { //Si está saltando o cayendo no podemos darle mucha velocidad en x porque hara un gran parabola
			if(right && !stop) {
				x += 5;
			}
			else if(left && !stopBack) {
				x -= 5; //la figura se desplaza a la izquierda cada que se detecta la presi�n de la tecla
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
				if((int)y<GamePanel.PHEIGHT-250) {//EL suelo del juego es de 160 pixeles, por lo tanto es la altura del panel menos los 160
					//Dejamos 5 pixeles de colchon
					y += currentFallSpeed; //el valor de y se estará incrementando (recordemos que incrementar es bajar) 
					if(currentFallSpeed<maxFallSpeed) {//Si el valor de caida es menor al maximo 
						currentFallSpeed+=0.5;//Se puede ir acelerando
					}
				}else {
					fall=false;//Una vez que alcanza el suelo deja de caer
				}
				
			}
		}
		
		if(hit) {
			y -= currentHitSpeed;
			currentHitSpeed -= 0.5;
				
			if (currentHitSpeed <= 0) { 
				currentHitSpeed = hitSpeed;
				hit=false;
				fall=true; 
			}
		}
		
		if(!fall) { //Si ya no esta en estado de caida, el valor inicial regresa a .5
			currentFallSpeed=0.5;
		}
		
		if(!jump&&!fall) { //Si no esta saltando ni cayendo la velocidad debe ser alta

			if(!stop){
				if(right) {
					x+=5;	
				}
			}
			
			if(!stopBack){
				if(left) {
					//image = ss.grabImage(4, 1, 100, 100);
					x-=5; //la figura se desplaza la izquierda cada que se detecta la presión de la tecla
				}
			}
		}
		hitbox.setLocation(x,y);//el área de golpe no cambia, por lo tanto solo debemos ir ajustando las coordenadas en donde se encuentra nuestro objeto
		if((right || left) && !jump && !fall){
			if(contador < 4){
				contador++;
			}
			else{
				contador = 1;
			}
		}
		
		if(sunGrab){
			if(sun < 100){
				if(sunTick >= 50){
					sun++;
					sunTick = 0;
				}
				sunTick++;
			}
		}
		
		if(superSyd == true){
			if(superActive == 3){
				sun--;
				superActive = 0;
			}
			
			if(sun == 0){
				superSyd = false;
			}
			
			superActive++;
		}
		
		if(invulnerable == true){
			invulnerableTick--;
			if(invulnerableTick == 0){
				invulnerable = false;
				invulnerableTick = 100;
			}
		}
	}
	
	public void pinturitas(Graphics dbg) {
		currentState.pinturitas(dbg);
		
		lifebar(dbg);
		sunbar(dbg);
		
	}
	
	public void lifebar(Graphics dbg){
		//Muestra la vida actual		
		dbg.setColor(Color.black);
		dbg.fillRect(98, 518, 204, 24);
		
		dbg.setColor(Color.white);
		dbg.fillRect(100, 520, 200, 20);
		
		if(life >= 0){
			dbg.setColor(Color.cyan);
			dbg.fillRect(100, 520, life*2, 20);
		}
		
		dbg.setFont(new Font("Arial", Font.PLAIN, 20));
		dbg.setColor(Color.black);
		dbg.drawString(String.valueOf(life), 105, 538);
	}
	
	public void sunbar(Graphics dbg){
		//Muestra el sol
		dbg.setColor(Color.black);
		dbg.fillRect(98, 548, 204, 24);
		
		dbg.setColor(Color.white);
		dbg.fillRect(100, 550, 200, 20);
		
		if(sun >= 0){
			dbg.setColor(Color.yellow);
			dbg.fillRect(100, 550, sun*2, 20);
		}
		
		dbg.setFont(new Font("Arial", Font.PLAIN, 20));
		dbg.setColor(Color.black);
		dbg.drawString(String.valueOf(sun), 105, 568);
	}
	
	public void keyPressed(int key) {
		currentState.keyPressed(key);
		
		if((key == KeyEvent.VK_D)||(key == KeyEvent.VK_RIGHT))right=true;
		if((key == KeyEvent.VK_A)||(key == KeyEvent.VK_LEFT))left=true;
		if((key == KeyEvent.VK_SPACE) && (jump == false) && (y >= GamePanel.PHEIGHT-250)) jump=true;
		if(key == KeyEvent.VK_Q) activateSuperSyd();
	}
	
	public void keyReleased(int key) {
		currentState.keyReleased(key);
		
		if((key == KeyEvent.VK_D)||(key == KeyEvent.VK_RIGHT))right=false;
		if((key == KeyEvent.VK_A)||(key == KeyEvent.VK_LEFT))left=false;
	}
}