package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class BarsPanel extends JPanel {
		private static final long serialVersionUID = -7754346078369209097L;
	
	private DatesPanel datesPanel;
	private int[] values; 
	private String[] dates;
	
	public BarsPanel() {
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
		int xVar = 30;
		int yVar = 0;
		int j = 0;
		int maxValue = returnMaxValue(values[0], values[1], values[2]);
			for (int i : values) {
			int var = i*200 / maxValue;
			g.setColor(randomColor());
			g.fillRect(xVar, 225 , 50, var);
			yVar = yVar + 25;
			g.fillRect(250, yVar, 20, 20);
			g.drawString(dates[j++], 280, yVar+15);	
			g.setColor(Color.black);
			g.drawString(String.valueOf(i), 15+xVar, var-maxValue);
			g.drawLine(30, 225, 225, 225);
			g.drawLine(30, 30, 30, 225);
			xVar = xVar + 50;
			
			}
		}
	
	
    private int returnMaxValue(int v1,int v2,int v3){
        if (v1>v2 && v1>v3)
            return v1;
        else
            if (v2>v3)
                return v2;
            else
                return v3;
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
