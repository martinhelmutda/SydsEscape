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
		principal.setResizable(false);	//No queremos que vean lo que pasa detr�s de c�maras
		principal.pack();	//Redimensiona al tama�o del panel. Obtiene las dimensiones de cada elemento dentro del frame
		principal.setLocationRelativeTo(null);
	}
}
