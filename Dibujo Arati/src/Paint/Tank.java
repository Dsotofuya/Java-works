package Paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {

	private int x = 0;

	private int xAceleration = 0;

	private TankPanel tankPanel;

	//Recive el panel porque va a trabajar con los eventos que contiene el mismo
	public Tank(TankPanel tankPanel) {
		this.tankPanel = tankPanel;
	}

	// Si la posicion x + su aceleracion es mayor a 0 y x + aceleracion es menor que el ancho del panel entonces se suma
	// x+ la aceleracion apra cambiar la posicion de x
	public void move() {
		if (x + xAceleration > 0 && x + xAceleration < tankPanel.getWidth()-10) {
			x = x + xAceleration;
		}
	}

	
	//Pinta el tanque
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, 440, 50, 50);
		g.fillRect(x + 18, 425, 15, 20);
	}
	
	//Recive el evento de que la tecla fue solatada y cuando esto apsa la aceleración será 0
	public void KeyReleased(KeyEvent e) {
		xAceleration = 0;
	}
	
	
	//Recibe un evento y cuando el codigo del evento es igual a la flecha izquiera o derecha del teclado se cambia la aceleración
	public void KeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xAceleration = -5;
		} if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xAceleration = 5;
		}
	}

}
