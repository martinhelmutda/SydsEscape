package interfaz;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		//Crea la ventana principal
		JFrame principal = new JFrame("SydsEscape");
		principal.setContentPane(new GamePanel());
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setVisible(true);
		principal.setLayout(new BorderLayout());
		principal.setResizable(false);//No quermeos que vean lo que pasa detrás de cámaras
		principal.pack();//Redimensiona al tamaño del panel. Obtiene las dimensiones de cada elemento dentro del frame
		principal.setLocationRelativeTo(null);
	}
}
