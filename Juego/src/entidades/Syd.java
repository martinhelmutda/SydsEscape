package entidades;

import java.awt.Image;

public class Syd {
	private int vida; //estoy agregando comentarios como modo de prueba
	private int sol; //solo son comentarios, don't worry
	private int posX; //agregando m�s comentarios para las pruebas
	private int posY;
	private int puntos;
	private String estado;
	private Image imagen;

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getSol() {
		return sol;
	}

	public void setSol(int sol) {
		this.sol = sol;
	}
	
	

}
