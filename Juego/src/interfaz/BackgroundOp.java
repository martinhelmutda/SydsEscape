package interfaz;

import java.awt.image.BufferedImage;

public class BackgroundOp {
	private BufferedImage image;
	private int contador;
	
	public BackgroundOp(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage grabBackground(){
		if(contador == 4800){
			contador = 0;
		}
		
		BufferedImage img = image.getSubimage(contador, 0, 800, 600);
		contador += 5;
		return img;
	}
	



}
