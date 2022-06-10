package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class CakePanel extends JPanel {
	private static final long serialVersionUID = -8135653959416811613L;
	
	private DatesPanel datesPanel;
	private int[] values; 
	private String[] dates;
	
	
	public CakePanel() {
		datesPanel = new DatesPanel();
		values = datesPanel.valuesTable();
		dates = datesPanel.dateTable();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintGraphic(values, dates, g);
	}
	
	public void paintGraphic(int[] values, String[] dates, Graphics g) {
		int valueTotal = 0;
		int count = 0;
		int yVar = 0;
		int j = 0;
		for (int i : values) {
			valueTotal = valueTotal + i;
			int var = i*360 / valueTotal;
			g.setColor(randomColor());
			g.fillArc(20, 25, 200, 200, count, var);
			yVar = yVar +25;
			g.fillRect(250, yVar, 20, 20);
			g.drawString(dates[j++], 280, yVar+15);	
			g.setColor(Color.black);
//			g.drawString(String.valueOf(i), 200, 200);
			count = count + var;
		}
	}
	
	public Color randomColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color colorRandom = new Color(r, g, b); 
		return colorRandom;	
	}
}
