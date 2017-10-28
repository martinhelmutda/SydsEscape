package interfaz;

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageLoader {
	private final static String IMAGEN_DIR="images/"; //Esto dará la dirección de la carpeta
	
	private HashMap mapaImagenes;
	private HashMap mapaNombresG; //Lo usaremos cuando pongamos posiciones
	
	private GraphicsConfiguration graphicsConfig;
	
	public ImageLoader(String letra) {
		iniciaLoader();
		loadImagesFile(letra);
	}
	
	public ImageLoader() {
		iniciaLoader();
	}
	private void iniciaLoader() {
		// TODO Auto-generated method stub
		mapaImagenes=new HashMap();
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    graphicsConfig = ge.getDefaultScreenDevice().getDefaultConfiguration();
	}
	private void loadImagesFile(String letra) {
		// TODO Auto-generated method stub
		String imagenLetra = IMAGEN_DIR + letra;
		System.out.println("Leyendo archivo: " + imagenLetra);
		try {
			InputStream in = this.getClass().getResourceAsStream(imagenLetra);
			BufferedReader buff= new BufferedReader (new InputStreamReader(in));
			String renglon;
			char ch; 
			while((renglon = buff.readLine()) != null) { //Leemos lo que está dentro
				if(renglon.length() == 0){continue;}
				if (renglon.startsWith("//")) {continue;}
				ch = Character.toLowerCase( renglon.charAt(0) ); //Se inicializa al primer caracter del renglon
				switch(ch){
					case 'o':
						getFileNameImage(renglon);//Se especifica más abajo
					break;
					//Aún no las usaremos
					//case 'n':
					//	getNumberedImages(renglon);//Para varias imagenes seguidas. Se especifica abajo
					//break;
					default:
						System.out.println("No se encontro");
					break;
				}
			}buff.close();
		}catch (IOException e) 
		 { System.out.println("Error reading file: " + imagenLetra);
	      System.exit(1);
	    }
	}//FIN

	

	private void getFileNameImage(String renglon) {
		// TODO Auto-generated method stub
		StringTokenizer token = new StringTokenizer(renglon);
		if (token.countTokens()!=2)
			System.out.println("Número incorrecto de argumentos para "+renglon);
		else {
			token.nextToken();
			System.out.println(" Renglon o: ");
			cargaUnaImagen(token.nextToken());

		}
	}

	private boolean cargaUnaImagen(String letra) {
		// TODO Auto-generated method stub
		String nombre = getPrefix(letra); //obtenemos el prefijo del nombre
		if (mapaImagenes.containsKey(nombre)) {
			System.out.println("Error: "+nombre+"ya se ha usado");
			return false;
		}
		
		BufferedImage buffImg = loadImage(letra);
		if (buffImg != null) {
			ArrayList imgLista = new ArrayList();
			imgLista.add(buffImg);
			mapaImagenes.put(nombre, buffImg);
			System.out.println("Guardado" + nombre+"/"+ letra);
			return true;
		}else
			return false;
	}
	
	private String getPrefix(String letra)
	  // nombre antes del punto
	  {
	    int posn;
	    if ((posn = letra.lastIndexOf(".")) == -1) {
	      System.out.println("No se encontró prefijo " + letra);
	      return letra;
	    }
	    else
	      return letra.substring(0, posn);
	  }

	
	/*private void getNumberedImages(String renglon) {
		// TODO Auto-generated method stub
		AUN NO
	}*/
	
	public BufferedImage getImage(String name)
	  /* Get the image associated with <name>. If there are
	     several images stored under that name, return the 
	     first one in the list.
	  */
	  {
	    ArrayList imsList = (ArrayList) mapaImagenes.get(name);
	    if (imsList == null) {
	      System.out.println("No image(s) stored under " + name);  
	      return null;
	    }

	    // System.out.println("Returning image stored under " + name);  
	    return (BufferedImage) imsList.get(0);
	  }  // end of getImage() with name input;

	


	  public BufferedImage getImage(String name, int posn)
	  /* Get the image associated with <name> at position <posn>
	    in its list. If <posn> is < 0 then return the first image
	    in the list. If posn is bigger than the list's size, then
	    calculate its value modulo the size.
	  */
	  {
	    ArrayList imsList = (ArrayList) mapaImagenes.get(name);
	    if (imsList == null) {
	      System.out.println("No image(s) stored under " + name);  
	      return null;
	    }

	    int size = imsList.size();
	    if (posn < 0) {
	      // System.out.println("No " + name + " image at position " + posn +
	      //                      "; return position 0"); 
	      return (BufferedImage) imsList.get(0);   // return first image
	    }
	    else if (posn >= size) {
	      // System.out.println("No " + name + " image at position " + posn); 
	      int newPosn = posn % size;   // modulo
	      // System.out.println("Return image at position " + newPosn); 
	      return (BufferedImage) imsList.get(newPosn);
	    }

	    // System.out.println("Returning " + name + " image at position " + posn);  
	    return (BufferedImage) imsList.get(posn);
	  }  // end of getImage() with posn input;



	  public BufferedImage getImage(String name, String fnmPrefix)
	  /* Get the image associated with the group <name> and filename
	     prefix <fnmPrefix>. 
	  */
	  
	  {
	    ArrayList imsList = (ArrayList) mapaImagenes.get(name);
	    if (imsList == null) {
	      System.out.println("No image(s) stored under " + name);  
	      return null;
	    }

	    int posn = getGroupPosition(name, fnmPrefix);
	    if (posn < 0) {
	      // System.out.println("Returning image at position 0"); 
	      return (BufferedImage) imsList.get(0);   // return first image
	    }

	    // System.out.println("Returning " + name + 
	    //                        " image with pair name " + fnmPrefix);  
	    return (BufferedImage) imsList.get(posn);
	  }  // end of getImage() with fnmPrefix input;

	  private int getGroupPosition(String name, String fnmPrefix)
	  /* Search the hashmap entry for <name>, looking for <fnmPrefix>.
	     Return its position in the list, or -1.
	  */
	  {
	    ArrayList groupNames = (ArrayList) mapaNombresG.get(name);
	    if (groupNames == null) {
	      System.out.println("No group names for " + name);  
	      return -1;
	    }

	    String nm;
	    for (int i=0; i < groupNames.size(); i++) {
	      nm = (String) groupNames.get(i);
	      if (nm.equals(fnmPrefix))
	        return i;          // the posn of <fnmPrefix> in the list of names
	    }

	    System.out.println("No " + fnmPrefix + 
	                  " group name found for " + name);  
	    return -1;
	  }  // end of getGroupPosition()

	  public ArrayList getImages(String name)
	  // return all the BufferedImages for the given name
	  {
	    ArrayList imsList = (ArrayList) mapaImagenes.get(name);
	    if (imsList == null) {
	      System.out.println("No image(s) stored under " + name);  
	      return null;
	    }

	    System.out.println("Returning all images stored under " + name);  
	    return imsList;
	  }  // end of getImages();


	  public boolean isLoaded(String name)
	  // is <name> a key in the imagesMap hashMap?
	  {
	    ArrayList imsList = (ArrayList) mapaImagenes.get(name);
	    if (imsList == null)
	      return false;
	    return true;
	  }  // end of isLoaded()


	  public int numImages(String name)
	  // how many images are stored under <name>?
	  {
	    ArrayList imsList = (ArrayList) mapaImagenes.get(name);
	    if (imsList == null) {
	      System.out.println("No image(s) stored under " + name);  
	      return 0;
	    }
	    return imsList.size();
	  } // end of numImages()
	  
	
	 public BufferedImage loadImage(String letra) 
	   /* Load the image from <fnm>, returning it as a BufferedImage
	      which is compatible with the graphics device being used.
	      Uses ImageIO.
	   */
	   {
	     try {
	       BufferedImage im =  ImageIO.read( 
	                      getClass().getResource(IMAGEN_DIR + letra) );
	   

	       int transparency = im.getColorModel().getTransparency();
	       BufferedImage copy =  graphicsConfig.createCompatibleImage(
	                                im.getWidth(), im.getHeight(),
			                        transparency );
	       // create a graphics context
	       Graphics2D g2d = copy.createGraphics();
	

	      
	       // copy image
	       g2d.drawImage(im,0,0,null);
	       g2d.dispose();
	       return copy;
	     } 
	     catch(IOException e) {
	       System.out.println("Load Image error for " +
	                     IMAGEN_DIR + "/" + letra + ":\n" + e); 
	       return null;
	     }
	  } // end of loadImage() using ImageIO


	


}
