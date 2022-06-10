package GUI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PrincipalFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PanelObjects panelObjects;
	
	public PrincipalFrame() {
		panelObjects = new PanelObjects();
		addKeyListener(new KeyListener() {		
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				panelObjects.getRaquetaAbajo().KeyReleased(e);
				panelObjects.getRaquetaArriba().KeyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				panelObjects.getRaquetaAbajo().KeyPressed(e);
				panelObjects.getRaquetaArriba().KeyPressed(e);
			}
		});
		
		setTitle("Pong Vertical");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		setSize(500, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(panelObjects);
		setVisible(true);
	}
	
	
	
	public PanelObjects getPanelObjects() {
		return panelObjects;
	}
	
	public static void main(String[] args) throws InterruptedException {
		PrincipalFrame f = new PrincipalFrame();
		while (true) {
			f.getPanelObjects().move();
			f.getPanelObjects().repaint();	 //Repaint se uso para limpiar el fondo cada vez que se cambie de posicion la figura
			Thread.sleep(10); //Dice al procesador que descanse por 10 mls para ejecutar otros hilos como en este caso el metodo paint 
			
		}
	}
}
