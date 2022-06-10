package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DatesPanel extends JPanel{
	private static final long serialVersionUID = 4319839518855309638L;
	
	private JTable datesTbe;
	private String[] header = {"Categorias", "Valores"};
	private String[][] dates;
	private JScrollPane jScP; 
	
	
	public DatesPanel() {
		setLayout(new GridLayout(1, 3));
		dates = new String[3][2];
		dates[0][0] ="Bueno";  
		dates[0][1] = "20";
		dates[1][0] = "Regular";
		dates[1][1] = "10";
		dates[2][0] = "Malo";
		dates[2][1] = "5";
 		datesTbe = new JTable(dates, header);
 		jScP = new JScrollPane(datesTbe);
 		jScP.setPreferredSize(new Dimension(300, 75));
 		add(jScP);
	}

	public int[] valuesTable() {
		int[] values = {Integer.parseInt(dates[0][1]), Integer.parseInt(dates[1][1]), Integer.parseInt(dates[2][1]) };
		return values;
	}
	
	public String[] dateTable() {
		String[] datesxd = {dates[0][0], dates[1][0], dates[2][0] };
		return datesxd;
	}
}
