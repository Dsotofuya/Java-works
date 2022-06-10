package Paint;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private TankPanel panel;
	
	public Frame() {
		panel = new TankPanel();
		
		//Esta es una clase anonima donde solo se usara en esta clase y sus componentes
		addKeyListener(new KeyListener() {		
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				panel.getTank().KeyReleased(e);
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				panel.getTank().KeyPressed(e);	
			}
		});

		
		getContentPane().setBackground(Color.GRAY);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		add(panel);
		setVisible(true);
	}

	public TankPanel getPanel() {
		return panel;
	}

	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame();
		while (true) {
			f.getPanel().move();
			f.getPanel().repaint();	 //Repaint se uso para limpiar el fondo cada vez que se cambie de posicion la figura
			Thread.sleep(10); //Dice al procesador que descanse por 10 mls para ejecutar otros hilos como en este caso el metodo paint 
			
		}
	}

}
