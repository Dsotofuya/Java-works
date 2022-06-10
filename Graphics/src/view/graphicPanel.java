package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class graphicPanel extends JPanel {
	private static final long serialVersionUID = -2538585891461214299L;

	public graphicPanel() {
	}
	
	public void paint(Graphics graphics) {
		graphics.drawRect(50, 50, 100, 50);
		graphics.setColor(Color.CYAN);
		graphics.fillRect(200, 50, 100, 50);
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.setFont(new Font(getFont().getName(), getFont().getStyle(), 30));
		graphics.drawString("DON PEPE Y LAS RANAS", 200, 75);
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.drawOval(50, 150, 50, 50);
		graphics.setColor(Color.red);
		graphics.fillOval(200, 150, 50, 50);
		graphics.drawLine(50, 50, 100, 100);
		
		Image img = Toolkit.getDefaultToolkit().getImage("src/zData/img.jpg");
		
		/*graphics.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		 * 1. img,
		 * 2. pos x inicial
		 * 3. pos y inicial
		 * 4. pos x final
		 * 5. pos y final
		 * 6. pos x inicial imagen
		 * 7. pos y inicial imagen
		 * 8. pos x final imagen
		 * 9. pos y final imagen
		 * 10. observador */
		graphics.drawImage(img, 50, 300, this);
		graphics.drawImage(img, 300, 300, 600, 500, 0, 0, 240, 210, this);
	}
	
}
