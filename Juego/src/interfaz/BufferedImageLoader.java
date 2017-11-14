package interfaz;


import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	private BufferedImage image;
	private int contador = 0;
	
	public BufferedImage loadImage(String path) throws IOException{
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
	
	public BufferedImage grabBackground(BufferedImage imagen){
		if(contador == 4000){
			contador = 0;
		}
		BufferedImage img = imagen.getSubimage(contador, 0, 800, 600);
		contador ++;
		return img;
	}
}
