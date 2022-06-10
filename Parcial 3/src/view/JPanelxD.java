package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JPanelxD extends JPanel {

	private ArrayList<BufferedImage> xd;
	
	public JPanelxD(ArrayList<BufferedImage> xd) {
		this.xd = xd;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}
