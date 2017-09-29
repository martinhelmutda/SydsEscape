package interfaz;

import java.awt.Graphics;
import java.util.Stack;

public class Director {
	//Aquí se actualiza todo
	public Stack<Ordenes> instruccion;
	
	public Director() {
		instruccion = new Stack<Ordenes>();
		instruccion.push(new Menu(this));
		//instruccion.push(new Nivel(this));
		System.out.println("Krakatoa");
	}
	
	public void tick() {
		instruccion.peek().tick(); //Pide el objeto de la cima de un stack sin eliminarlo
	}
	
	public void pinturitas(Graphics dgb) {
		instruccion.peek().pinturitas(dgb);
	}
	
	public void keyPressed(int oo) {
		instruccion.peek().keyPressed(oo);
	}
	
	public void keyReleased(int oo) {
		instruccion.peek().keyReleased(oo);
	}
}
