package entidades;

import java.util.Random;

import interfaz.SpriteSheet;

public class EntityGenerator {

	private SpriteSheet ss;
	private boolean isNight;
	
	public EntityGenerator(SpriteSheet sprite){
		this.ss = sprite;
	}
	
	public void setNight(boolean isNight){
		this.isNight = isNight;
	}
	
	public Entidad createEntity(){
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(10);
		if(isNight){
			switch(random){
			case 0: case 4: return new Obstaculo(ss);
			case 1: case 5: case 8:  return new Bicho(ss); 
			case 2: case 6: case 9: case 7: return new Mosco(ss); //los enemigos tipo volador son m�s frecuentes
			case 3: return new Agua(ss);	//El agua es 3 veces mas rara
			}
		}else{
			switch(random){
			case 0: case 4: case 7: return new Obstaculo(ss);
			case 1: case 5: case 8: return new Bicho(ss);
			case 2: case 6: case 9: return new Abeja(ss);
			case 3: return new Agua(ss);	//El agua es 3 veces mas rara
			}
		}

		return null;
	}
	

}
