package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Control.Control;
import Costants.Costants;

public class vehicle_Panel extends JPanel {

	private static final long serialVersionUID = 8319878495528211598L;
	private JLabel brand_lbl;
	private JLabel line_lbl;
	private JLabel model_lbl;
	private JLabel value_lbl;
	private JLabel value2_lbl;
	private JLabel empty_lbl;
	private JComboBox<Object> brand_txt;
	private JComboBox<Object> line_txt;
	private JComboBox<Object> model_txt;
	private JButton find_btn;
	private Control control;

	public vehicle_Panel(Control control) {
		super();
		this.control = control;
		init();
		TitledBorder title = BorderFactory.createTitledBorder("Buscar Vehiculo");
		title.setTitleColor(Color.BLUE);
		setBorder(title);
		setLayout(new GridLayout(5, 2));
		add(brand_lbl);
		add(brand_txt);
		add(line_lbl);
		add(line_txt);
		add(model_lbl);
		add(model_txt);
		add(value_lbl);
		add(value2_lbl);
		add(empty_lbl);
		add(find_btn);
	}

	private void init() {
		brand_lbl = new JLabel("Marca");
		brand_txt = new JComboBox<Object>();
		brand_txt.setActionCommand(Costants.BRAND_SELECTED);
		brand_txt.addActionListener(control);
		line_lbl = new JLabel("Linea");
		line_txt = new JComboBox<Object>();
		line_txt.setActionCommand(Costants.LINE_SELECTED);
		line_txt.addActionListener(control);
		model_lbl = new JLabel("Modelo");
		model_txt = new JComboBox<Object>();
		model_txt.setActionCommand(Costants.MODEL_SELECTED);
		model_txt.addActionListener(control);
		value_lbl = new JLabel("Valor");
		value2_lbl = new JLabel("-----------------------------------------");
		empty_lbl = new JLabel();
		find_btn = new JButton("Buscar");
		find_btn.setActionCommand(Costants.FIND);
		find_btn.addActionListener(control);
	}
	
	public void writeJCBBrand(Object[] brandList) {
		for (Object object : brandList) {
			brand_txt.addItem(object);
		}
	}
	
	public void writeJCBLine(Object[] lineList) {
		line_txt.removeAllItems();
		for (Object object : lineList) {
			line_txt.addItem(object);
		}
	}
	
	public void writeJCBModel(Object[] modelList) {
		model_txt.removeAllItems();
		for (Object object : modelList) {
			model_txt.addItem(object);
		}
	}
	
	public String brandSelected() {
		return (String) brand_txt.getSelectedItem();
	}
	
	public String lineSelected() {
		return (String) line_txt.getSelectedItem();
	}
	
	public String modelSelected() {
		return (String) model_txt.getSelectedItem();
	}
	public void clean(){
		        for(int i = 0; getComponents().length > i; i++){
		            if(getComponents()[i] instanceof JTextField){
		                ((JTextField)getComponents()[i]).setText("");
		            }
		        }
		        value2_lbl.setText("");
	}
	
	public void setValueText(String value){
		value2_lbl.setForeground(Color.blue);
		value2_lbl.setText(value);
	}
	
}
