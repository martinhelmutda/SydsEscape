package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.border.EmptyBorder;

public class Menu extends Ordenes{
	private String[] opcion = {"Inicio","Salir"};
	private int seleccion=0;
	
	public Menu(Director director) {
		super(director);	
	}

	
	public void empezar() {
			
	}


	public void tick() {
		
	}

	public void pinturitas(Graphics dgb) {
		dgb.setColor(Color.black);
		dgb.fillRect(0,0,GamePanel.PWIDTH, GamePanel.PHEIGHT);
		//Aquí mostraremos el efecto de selección entre las opciones
		for(int i=0;i<opcion.length;i++) { //Recorre e imprime todas las opciones
			if(i==seleccion) {
				dgb.setColor(Color.blue);
			}else{
				dgb.setColor(Color.white);
			}
			
			dgb.setFont(new Font("Serif", Font.PLAIN, 40));
			dgb.drawString(opcion[i], GamePanel.PWIDTH/2 -50, 350 + i*100); //Esto dibuja una palabra en la coordenada deseada
			//Tomamos la anchura de la clase GAME PANEL y la dividimos entre 2 para centrar el texto
			
		}//Tomamos el número de opciones
		
		
	}


	public void keyPressed(int oo) {//PODEMOS CAMBIAR A UN SWITCH
		if(oo == KeyEvent.VK_DOWN) {
			seleccion++; //Si se presiona alguna de las teclas, la selección cambia
			if(seleccion >= opcion.length) {//Si la seleccion se pasa del numero de opciones, regresa al inicio
				seleccion=0;
			}
		}else if(oo == KeyEvent.VK_UP){
			seleccion--;
			if(seleccion<0) {
				seleccion = opcion.length-1;//Recordemos como funcionan los arraus
			}
		}
		if(oo == KeyEvent.VK_ENTER) {
			if(seleccion==0) {//Inicio
			director.instruccion.push(new Nivel(director));
			}
			else if(oo==1) {//Salir
				System.exit(0);
			}
		}
	}

	public void keyReleased(int oo) {
	
		
	}



}
