package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel{
	private static final long serialVersionUID = 1L;
	JFrame ventana = new JFrame();
	
	public Menu() {
		//ventana.setUndecorated(true); //es para quitar el borde de la ventana
		ventana.setLocation(100, 10); //centra la ventana
		ventana.add(this);
		ventana.setVisible(true);
		ventana.setSize(1080, 720);
	}


}
