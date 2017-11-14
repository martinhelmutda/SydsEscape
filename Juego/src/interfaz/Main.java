package interfaz;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame principal = new JFrame("SydsEscape");
		principal.setContentPane(new GamePanel());
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setVisible(true);
		principal.setLayout(new BorderLayout());
		principal.setResizable(true);	//No queremos que vean lo que pasa detras de camaras
		principal.pack();	//Redimensiona al tamanio del panel. Obtiene las dimensiones de cada elemento dentro del frame
		principal.setLocationRelativeTo(null);
	}
}
