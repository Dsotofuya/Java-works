package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MainPanel2 extends JPanel{


	private static final long serialVersionUID = 1L;
	private Double  margen = 1.2;
	private int  margen2 = 8;
	private String[] datosX = {"Programacion" , "calculo" , "probabilidad", "fisica" , "asfd"};
	private double[] datosY = {3, 2 ,5 ,6 ,767};
	private double minPosicion;
	private double maxPosition;
	
	public MainPanel2() {
		setBackground(Color.WHITE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D linea = (Graphics2D)g;
		linea.setPaint(Color.BLACK);
		
		drawY(g , Height() , Width());
		drawX(g , Height() , Width());
		linea.setStroke(new BasicStroke(2f));
		drawInY(g , Height() , Width());
		draiInX(g , Height() , Width());
		printX(g , Height() , Width());
		linea.setStroke(new BasicStroke(0.5f));
		drawGrid(g , Height() , Width());
		printY(g, Height() , Width());
		
		printASD(g, Height(), Width());
		drawPoliLine(g, Height(), Width());
	}	
	
	
	
	public void drawX(Graphics g , double height , double width) {
		
		
		g.drawLine((int)width/margen2 ,(int)(height/ margen ) , (int) ((width / margen)) , (int)((height/ margen )));
		
		int[] pointsxX = {(int) ((width / margen)*1.024), (int) ((width / margen)), (int) ((width / margen))};
		int[] pointsyX = {(int)((height/ margen )), (int)((height/ margen )*1.024), (int)((height/ margen )/1.024)};
		
		g.fillPolygon(pointsxX, pointsyX, 3);
	}
	
	public void drawY(Graphics g , double height , double width) {
		
		
		g.drawLine((int)width/margen2 , (int)(height/ margen )  ,(int) width / margen2 ,(int) height / margen2);
	
		
		int [] pointsxY = { (int) (width / margen2) ,(int) ((width / margen2)/1.15), (int) ((width / margen2)*1.15)};
		int [] pointsyY = { (int) ((height / margen2)/1.5), (int)height / margen2 , (int)height / margen2};
		
		g.fillPolygon(pointsxY, pointsyY, 3);
	}
	
	public void drawInY(Graphics g , double height , double width) {
	
		
		double sizeY = (height/ margen ) - height / margen2;
		double total = sizeY / datosY.length;
			
		for (int i = 1; i <= datosY.length; i++) {
			double punto ;
			double punInicialX = width / margen2;
			double punInicialY = (height/ margen ) ;
			punto =  punInicialY - total*i;
			
			g.drawLine((int) (punInicialX/1.1), (int)punto, (int) (punInicialX*1.1), (int)punto);
		}
	}
	
	public void draiInX(Graphics g , double height , double width) {
		
		
		double sizeX = ((width / margen)) - width/margen2 ;
		double totalX = sizeX / datosX.length;
			
		for (int j = 1; j <= datosX.length; j++) {
		
			double punto ;
			double punInicialX = width / margen2;
			
			double punInicialY = (height/ margen ) ;
			
			punto =  punInicialX + totalX*j;
			
			g.drawLine((int)punto, (int) (punInicialY*1.01), (int)punto, (int) (punInicialY/1.01));
		}
	}
	
	public void drawGrid(Graphics g , double height , double width) {
		
		g.setColor(Color.blue);
		
		
		double sizeX = ((width / margen)) - width/margen2 ;
		double totalX = sizeX / datosX.length;
		
			
		for (int j = 1; j <= datosX.length; j++) {
		
			double punto ;
			double punInicialX = width / margen2;
			
			double punInicialY = (height/ margen ) ;
			
			punto =  punInicialX + totalX*j;
			
			g.drawLine((int)punto, (int)punInicialY, (int)punto, (int)height / margen2);
		}
		

		double sizeY = (height/ margen ) - height / margen2;
		double total = sizeY / datosY.length;
			
		for (int i = 1; i <= datosY.length; i++) {
			double punto ;
			double punInicialX = width / margen2;
			double punInicialY = (height/ margen ) ;
			
			punto =  punInicialY - total*i;
			
			g.drawLine((int)punInicialX, (int)punto, (int) ((width/ margen )), (int)punto);
		}
	}
	
	public void printX(Graphics g , double height , double width) {
		
		double sizeX = (int) ((width / margen)) - width/margen2 ;
		double totalX = sizeX / datosX.length;
		double count =1 ;
		
		for (int j = 0; j < datosX.length; j++) {
		
			double punto ;
			double punInicialX = width / margen2;
			
			double punInicialY = (height/ margen ) ;
			
			punto =  punInicialX + totalX*count;
			count = count +1 ;
			g.drawString(datosX[j], (int) (punto/1.02), (int) (punInicialY*1.04));
		}
	}
	
public void printY(Graphics g , double height , double width) {
		
	double sizeY = (height/ margen ) - height / margen2;
	double total = sizeY / datosY.length;
	
		for (int i = 0; i < datosY.length; i++) {
			if (maxPosition < datosY[i]) {
				maxPosition = datosY[i];
			}	
			
		}
		double punto ;
		double punInicialX = width / margen2;
		double punInicialY =(int) ( height/ margen ) ;
		punto =  punInicialY - total*datosY.length;
		
		g.drawString(String.valueOf(maxPosition), (int) (punInicialX/1.5) , (int) punto);
		

		double division ;
		for (int i = 1; i < datosY.length; i++) {
			punto =  punInicialY - total*i;
			
			division = maxPosition / datosY.length;
			minPosicion = (int) division;
			g.drawString(String.valueOf(division*i), (int) (punInicialX/1.5) , (int)punto);
		}
		
		
	}

	public void printASD(Graphics g , double height , double width) {
		g.setColor(Color.red);
		double sizeX = ((width / margen)) - width/margen2 ;
		double totalX = sizeX / datosX.length;
		int count =1 ;
		
		for (int j = 0; j < datosX.length; j++) {
		
			double puntoX ;
			double punInicialX = width / margen2;
			
			puntoX =  punInicialX + totalX*count;
			count = count +1 ;
			
			double diference = ((height/ margen ) - (height / margen2)) / datosY.length;
			double puntoY = (((int)datosY[j] * diference) / (minPosicion)) ;
			
			g.fillOval((int) (puntoX/1.01), (int) ((height/ margen)-puntoY), 5, 5);
			
		}
	}
	
	public void drawPoliLine(Graphics g , double height , double width) {
		
		g.setColor(Color.red);
		double sizeX = ((width / margen)) - width/margen2 ;
		double totalX = sizeX / datosX.length;
		int count =1 ;
		
		for (int j = 0; j < datosX.length; j++) {
		
			double puntoX ;
			double punInicialX = width / margen2;
			
			puntoX =  punInicialX + totalX*count;
			count = count +1 ;
			
			
			
			double diference = ((height/ margen ) - (height / margen2)) / datosY.length;
			double puntoY = (((int)datosY[j] * diference) / (minPosicion)) ;
		
			
			g.drawLine((int) (puntoX/1.01), (int) ((height/ margen)-puntoY), (int) (puntoX/1.01)*1, (int) ((height/ margen)-puntoY));
		}
		
		
		
	}

	public double Height() {
		return getHeight();
	}
	
	public double Width() {
		return getWidth();
	}
}
	
