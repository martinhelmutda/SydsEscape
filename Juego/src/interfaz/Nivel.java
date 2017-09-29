package interfaz;

import java.awt.Graphics;

import entidades.Syd;

public class Nivel extends Ordenes{
	
	private Syd syd;

	public Nivel(Director director) {
		super(director);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void empezar() {
		// TODO Auto-generated method stub
		syd = new Syd(40,40);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		syd.tick();
	}

	@Override
	public void pinturitas(Graphics dgb) {
		// TODO Auto-generated method stub
		syd.pinturita(dgb);
	}

	@Override
	public void keyPressed(int oo) {
		// TODO Auto-generated method stub
		syd.keyPressed(oo);
	}

	@Override
	public void keyReleased(int oo) {
		// TODO Auto-generated method stub
		syd.keyReleased(oo);
	}


}
